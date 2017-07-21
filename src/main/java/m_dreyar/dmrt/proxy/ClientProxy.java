package m_dreyar.dmrt.proxy;

import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.tileentity.TileEntityTestItemHolder;
import m_dreyar.dmrt.tileentity.renderer.RendererTestItemHolder;
import net.minecraftforge.fml.client.registry.ClientRegistry;

// Client proxy containing code that should only be handled by a physical client
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		super.init();
		ModItems.registerRenders(); // Register all item renders
		ModBlocks.registerRenders(); // Register all block renders
		registerTESR(); // Register special renderers
	}
	
	private void registerTESR(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestItemHolder.class, new RendererTestItemHolder());
	}
}
