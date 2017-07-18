package m_dreyar.dmrt.init;

import m_dreyar.dmrt.items.ItemTest;
import m_dreyar.dmrt.items.ItemTestIngot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

// Handles the initialization and registration of items and their textures
public class RegisterItems {

	public static Item testItem;
	public static Item testIngot;

	// Initialized all items
	public static void init() {
		testItem = new ItemTest();
		testIngot = new ItemTestIngot();
	}

	// Registers all items
	public static void register() {
		ForgeRegistries.ITEMS.register(testItem);
		ForgeRegistries.ITEMS.register(testIngot);
	}

	// Registers the renders for all items
	public static void registerRenders() {
		registerRender(testItem);
		registerRender(testIngot);
	}

	// Registers the render for a item
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
