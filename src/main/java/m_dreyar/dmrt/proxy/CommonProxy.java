package m_dreyar.dmrt.proxy;

import m_dreyar.dmrt.GuiHandler;
import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.init.ModRecipies;
import m_dreyar.dmrt.init.ModTileEntities;
import m_dreyar.dmrt.init.ModWorldGen;
import net.minecraftforge.fml.common.network.NetworkRegistry;

// Common proxy containing code that both the physical server and client can run
public class CommonProxy {

	public void preInit() {
		ModItems.init(); // Initialize all items
		ModItems.register(); // Register all items

		ModBlocks.init(); // Initialize all blocks
		ModBlocks.register(); // Registers all blocks
		
		
	}

	public void init() {
		ModRecipies.registerSmelting(); // Register all smelting recipes
		ModTileEntities.register(); // Register all TileEntities
		ModWorldGen.registerWorldGenerators(); // Register all world generators
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	public void postInit() {

	}
}
