package m_dreyar.dmrt.gui;

import java.awt.Color;

import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.tileentity.TileEntityTestChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTestChest extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/test_chest.png");
	private TileEntityTestChest tileEntityTestChest;

	public GuiTestChest(InventoryPlayer playerInv, TileEntityTestChest tile) {
		super(new ContainerTestChest(playerInv, tile));
		tileEntityTestChest = tile;
		xSize = 176;
		ySize = 133;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		fontRenderer.drawString(tileEntityTestChest.getDisplayName().getFormattedText(), LABEL_XPOS, LABEL_YPOS, Color.DARK_GRAY.getRGB());
	}
}
