package m_dreyar.dmrt;

import m_dreyar.dmrt.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

	public CreativeTab() {
		super("tabDMRT");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.testItem);
	}

}
