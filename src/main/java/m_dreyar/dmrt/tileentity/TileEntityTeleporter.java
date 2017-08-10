package m_dreyar.dmrt.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.BlockPos;

public class TileEntityTeleporter extends TileEntity{

	public boolean canTeleportHere(){
		BlockPos position = getPos();
		if(world.getBlockState(position.up()).getBlock().equals(Blocks.AIR)){
			if(world.getBlockState(position.up(2)).getBlock().equals(Blocks.AIR)){
				return true;
			}
		}
		return false;
	}
	
	public void teleportHere(EntityPlayer player){
		BlockPos position = getPos();
		player.setPositionAndUpdate(position.getX() + 0.5, position.up().getY(), position.getZ() + 0.5);
	}
	
	public EnumActionResult attemptTeleport(EntityPlayer player){
		if(!world.isRemote){
			if(canTeleportHere()){
				teleportHere(player);
				return EnumActionResult.SUCCESS;
			}else{
				return EnumActionResult.FAIL;
			}
		}
		return EnumActionResult.PASS;
	}
}
