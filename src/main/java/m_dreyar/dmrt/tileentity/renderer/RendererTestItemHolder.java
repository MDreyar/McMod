package m_dreyar.dmrt.tileentity.renderer;

import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.tileentity.TileEntityTestItemHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class RendererTestItemHolder extends TileEntitySpecialRenderer<TileEntityTestItemHolder> {

	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().world, 0, 0, 0, new ItemStack(ModItems.testItem));

	// Render all the items in the TileEntity on the block
	@Override
	public void render(TileEntityTestItemHolder te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		super.render(te, x, y, z, partialTicks, destroyStage, alpha);

		ITEM.hoverStart = 0;
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(x, y, z);
			GlStateManager.translate(0.5f, -0.0625f, 0.6f);
			GlStateManager.scale(2f, 2f, 2f);
			for (int i = 0; i < te.getStickCount(); i++) {
				GlStateManager.rotate(45, 0, 1, 0);
				GlStateManager.translate(0.05f, 0, 0);
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0, 0, false);
			}
		}
		GlStateManager.popMatrix();
	}
}
