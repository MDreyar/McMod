package m_dreyar.dmrt.blocks;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTestOre extends Block {

	public BlockTestOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.Blocks.TESTORE.getUnlocalizedName());
		setRegistryName(Reference.Blocks.TESTORE.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
		setHardness(3.0F);
		setResistance(5.0F);
	}
}
