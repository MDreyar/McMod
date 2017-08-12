package m_dreyar.dmrt.proxy;

import static m_dreyar.dmrt.Main.log;

import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.init.ModTESR;

// Client proxy containing code that should only be handled by a physical client
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		super.init();
		
		log.debug("Registering item renders");
		ModItems.registerRenders(); // Register all item renders
		
		log.debug("Registering block renders");
		ModBlocks.registerRenders(); // Register all block renders
		
		log.debug("Registering special renderers");
		ModTESR.registerTESR(); // Register special renderers
	}

}
