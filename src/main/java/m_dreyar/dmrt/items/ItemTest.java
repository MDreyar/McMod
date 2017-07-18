package m_dreyar.dmrt.items;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import net.minecraft.item.Item;

// A simple test item to figure it all out
public class ItemTest extends Item {

	public ItemTest() {
		setUnlocalizedName(Reference.Items.TESTITEM.getUnlocalizedName());
		setRegistryName(Reference.Items.TESTITEM.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
	}
}
