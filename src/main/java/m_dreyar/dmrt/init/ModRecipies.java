package m_dreyar.dmrt.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipies {

	public static void register() {
		GameRegistry.addSmelting(ModBlocks.testOre, new ItemStack(ModItems.testIngot, 1), 50f);
	}
}
