package m_dreyar.dmrt.proxy;

import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.init.ModTESR;

// Client proxy containing code that should only be handled by a physical client
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		super.init();
		ModItems.registerRenders(); // Register all item renders
		ModBlocks.registerRenders(); // Register all block renders
		ModTESR.registerTESR(); // Register special renderers
	}

}
