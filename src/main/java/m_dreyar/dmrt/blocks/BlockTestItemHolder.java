package m_dreyar.dmrt.blocks;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.tileentity.TileEntityTestItemHolder;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTestItemHolder extends Block implements ITileEntityProvider {

	public BlockTestItemHolder() {
		super(Material.IRON);
		setUnlocalizedName(Reference.Blocks.TESTITEMHOLDER.getUnlocalizedName());
		setRegistryName(Reference.Blocks.TESTITEMHOLDER.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
		setHardness(5.0F);
		setResistance(10.0F);
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	// If player is holding testItem, try to put it in the block, else try to
	// get a testItem from the block
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEntityTestItemHolder) {
				TileEntityTestItemHolder tileBlock = (TileEntityTestItemHolder) tileEntity;
				ItemStack heldItem = playerIn.getHeldItemMainhand();
				if (heldItem != null) {
					if (heldItem.getItem() == ModItems.testItem) {
						if (tileBlock.putStick()) {
							heldItem.setCount(heldItem.getCount() - 1);
							return true;
						} else {
							return true;
						}
					}
				}
				tileBlock.takeStick();
				return true;
			}
		}
		return true;
	}

	// When the block is broken drop all testItem's currently in the block
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.getTileEntity(pos) instanceof TileEntityTestItemHolder) {
			TileEntityTestItemHolder tileEntity = (TileEntityTestItemHolder) worldIn.getTileEntity(pos);
			tileEntity.takeAllSticks();
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTestItemHolder();
	}
}
