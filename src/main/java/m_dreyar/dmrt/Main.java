package m_dreyar.dmrt;

import m_dreyar.dmrt.init.ModBlocks;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.init.ModRecipies;
import m_dreyar.dmrt.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main {

	@SidedProxy(modId = Reference.MOD_ID, clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy; // Contains a CommonProxy or ClientProxy
	
	public static final CreativeTabs CREATIVETAB = new CreativeTab();

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ModItems.init(); // Initialize all items
		ModItems.register(); // Register all items

		ModBlocks.init(); // Initialize all blocks
		ModBlocks.register(); // Registers all blocks
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(); // Run necessary initialization code for current proxy
		
		ModRecipies.register();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}
