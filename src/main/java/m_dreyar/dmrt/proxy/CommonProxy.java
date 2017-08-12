package m_dreyar.dmrt.proxy;

import static m_dreyar.dmrt.Main.log;

import m_dreyar.dmrt.GuiHandlerRegistry;
import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModGuiHandler;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.init.ModRecipies;
import m_dreyar.dmrt.init.ModTileEntities;
import m_dreyar.dmrt.init.ModWorldGen;
import net.minecraftforge.fml.common.network.NetworkRegistry;

// Common proxy containing code that both the physical server and client can run
public class CommonProxy {

	
	public void preInit() {
		log.debug("Initializing and registering items");
		ModItems.init(); // Initialize all items
		ModItems.register(); // Register all items

		log.debug("Initializing and registering blocks");
		ModBlocks.init(); // Initialize all blocks
		ModBlocks.register(); // Registers all blocks
		
		
	}

	public void init() {
		log.debug("Registering smelting recipes");
		ModRecipies.registerSmelting(); // Register all smelting recipes
		
		log.debug("Registering tileEntities");
		ModTileEntities.register(); // Register all TileEntities
		
		log.debug("Registering world generators");
		ModWorldGen.registerWorldGenerators(); // Register all world generators
		
		log.debug("Registering GUI handler registry and importing GUI handlers");
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandlerRegistry());
		ModGuiHandler.registerGuiHandlers();
	}

	public void postInit() {

	}
}
