package m_dreyar.dmrt.init;

import m_dreyar.dmrt.blocks.BlockTeleporter;
import m_dreyar.dmrt.blocks.BlockTest;
import m_dreyar.dmrt.blocks.BlockTestItemHolder;
import m_dreyar.dmrt.blocks.BlockTestOre;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

// Handles the initialization and registration of blocks
public class ModBlocks {

	public static Block testBlock;
	public static Block testOre;
	public static Block testItemHolder;
	public static Block teleporter;

	// Initialized all blocks
	public static void init() {
		testBlock = new BlockTest();
		testOre = new BlockTestOre();
		testItemHolder = new BlockTestItemHolder();
		teleporter = new BlockTeleporter();
	}

	// Registers all blocks
	public static void register() {
		registerBlock(testBlock);
		registerBlock(testOre);
		registerBlock(testItemHolder);
		registerBlock(teleporter);
	}

	// Registers one block and its item
	private static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);
	}

	// Registers the renders for all blocks
	public static void registerRenders() {
		registerRender(testBlock);
		registerRender(testOre);
		registerRender(testItemHolder);
		registerRender(teleporter);
	}

	// Registers the render for a block
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
