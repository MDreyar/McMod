package m_dreyar.dmrt;

import m_dreyar.dmrt.init.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{

	public CreativeTab() {
		super("tabDMRT");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(RegisterItems.testItem);
	}

}
