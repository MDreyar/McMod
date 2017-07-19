package m_dreyar.dmrt.blocks;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.init.ModItems;
import m_dreyar.dmrt.tileentity.TileEntityTestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// A simple test block to figure it all out
public class BlockTest extends Block implements ITileEntityProvider{

	public BlockTest() {
		super(Material.GROUND);
		setUnlocalizedName(Reference.Blocks.TESTBLOCK.getUnlocalizedName());
		setRegistryName(Reference.Blocks.TESTBLOCK.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if(tileEntity instanceof TileEntityTestBlock){
				TileEntityTestBlock tileBlock = (TileEntityTestBlock) tileEntity;
				ItemStack heldItem = playerIn.getHeldItemMainhand();
				if(heldItem != null){
					if(heldItem.getItem() == ModItems.testItem){
						if(tileBlock.putStick()){
							heldItem.setCount(heldItem.getCount() - 1);
							return true;
						}else{
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
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if(worldIn.getTileEntity(pos) instanceof TileEntityTestBlock){
			TileEntityTestBlock tileEntity = (TileEntityTestBlock) worldIn.getTileEntity(pos);
			tileEntity.takeAllSticks();
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTestBlock();
	}
}
