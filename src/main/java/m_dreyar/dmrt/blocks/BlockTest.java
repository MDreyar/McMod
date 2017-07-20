package m_dreyar.dmrt.blocks;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

// A simple test block to figure it all out
public class BlockTest extends Block {

	public BlockTest() {
		super(Material.IRON);
		setUnlocalizedName(Reference.Blocks.TESTBLOCK.getUnlocalizedName());
		setRegistryName(Reference.Blocks.TESTBLOCK.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
		setHardness(5.0F);
		setResistance(10.0F);
	}
}
