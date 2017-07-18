package m_dreyar.dmrt.items;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.init.ModItems;
import net.minecraft.item.ItemSword;

public class ItemTestSword extends ItemSword {

	public ItemTestSword() {
		super(ModItems.TESTMATERIAL);
		setUnlocalizedName(Reference.Items.TESTSWORD.getUnlocalizedName());
		setRegistryName(Reference.Items.TESTSWORD.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
	}
}
