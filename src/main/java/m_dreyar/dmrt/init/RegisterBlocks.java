package m_dreyar.dmrt.init;

import m_dreyar.dmrt.blocks.BlockTest;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

// Handles the initialization and registration of blocks
public class RegisterBlocks {

	public static Block testBlock;
	
	// Initialized all blocks
		public static void init() {
			testBlock = new BlockTest();
		}

		// Registers all blocks
		public static void register() {
			registerBlock(testBlock);
		}
		
		// Registers one block and its item
		private static void registerBlock(Block block){
			ForgeRegistries.BLOCKS.register(block);
			ItemBlock itemBlock = new ItemBlock(block);
			itemBlock.setRegistryName(block.getRegistryName());
			ForgeRegistries.ITEMS.register(itemBlock);
		}

		// Registers the renders for all blocks
		public static void registerRenders() {
			registerRender(testBlock);
		}

		// Registers the render for a block
		private static void registerRender(Block block) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
}
