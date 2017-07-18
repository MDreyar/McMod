package m_dreyar.dmrt.init;

import m_dreyar.dmrt.items.ItemTest;
import m_dreyar.dmrt.items.ItemTestIngot;
import m_dreyar.dmrt.items.ItemTestSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

// Handles the initialization and registration of items and their textures
public class ModItems {

	public static Item testItem;
	public static Item testIngot;
	public static Item testSword;
	
	public static ToolMaterial TESTMATERIAL = EnumHelper.addToolMaterial("TESTMATERIAL", 2, 500, 8.0F, 3.0F, 14);

	// Initialized all items
	public static void init() {
		testItem = new ItemTest();
		testIngot = new ItemTestIngot();
		testSword = new ItemTestSword();
	}

	// Registers all items
	public static void register() {
		ForgeRegistries.ITEMS.register(testItem);
		ForgeRegistries.ITEMS.register(testIngot);
		ForgeRegistries.ITEMS.register(testSword);
	}

	// Registers the renders for all items
	public static void registerRenders() {
		registerRender(testItem);
		registerRender(testIngot);
		registerRender(testSword);
	}

	// Registers the render for a item
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
