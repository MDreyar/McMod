package m_dreyar.dmrt.items;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import net.minecraft.item.Item;

// A simple ingot for smelting test
public class ItemTestIngot extends Item{

	public ItemTestIngot() {
		setUnlocalizedName(Reference.Items.TESTINGOT.getUnlocalizedName());
		setRegistryName(Reference.Items.TESTINGOT.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
	}
}
