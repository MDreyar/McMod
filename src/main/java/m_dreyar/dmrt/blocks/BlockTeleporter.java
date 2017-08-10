package m_dreyar.dmrt.blocks;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.tileentity.TileEntityTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTeleporter extends Block implements ITileEntityProvider{

	public BlockTeleporter() {
		super(Material.IRON);
		setUnlocalizedName(Reference.Blocks.TELEPORTER.getUnlocalizedName());
		setRegistryName(Reference.Blocks.TELEPORTER.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
		setHardness(5.0F);
		setResistance(10.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTeleporter();
	}
}
