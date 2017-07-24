package m_dreyar.dmrt.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipies {

	// Register all smelting recipes
	public static void registerSmelting() {
		GameRegistry.addSmelting(ModBlocks.testOre, new ItemStack(ModItems.testIngot, 1), 50f);
	}
}
