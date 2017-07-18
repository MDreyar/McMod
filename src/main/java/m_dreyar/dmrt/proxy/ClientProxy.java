package m_dreyar.dmrt.proxy;

import m_dreyar.dmrt.init.RegisterBlocks;
import m_dreyar.dmrt.init.RegisterItems;

// Client proxy containing code that should only be handled by a physical client
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		super.init();
		RegisterItems.registerRenders(); // Register all item renders
		RegisterBlocks.registerRenders(); // Register all block renders
	}
}
