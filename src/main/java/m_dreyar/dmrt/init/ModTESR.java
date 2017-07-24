package m_dreyar.dmrt.init;

import m_dreyar.dmrt.tileentity.TileEntityTestItemHolder;
import m_dreyar.dmrt.tileentity.renderer.RendererTestItemHolder;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ModTESR {

	// Register all TESR's
	public static void registerTESR() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestItemHolder.class, new RendererTestItemHolder());
	}
}
