package m_dreyar.dmrt.tileentity;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;

public class TileEntityTeleporter extends TileEntity {

	private boolean canTeleportHere() {
		BlockPos position = getPos();
		if (world.getBlockState(position.up()).getBlock().equals(Blocks.AIR)) {
			if (world.getBlockState(position.up(2)).getBlock().equals(Blocks.AIR)) {
				return true;
			}
		}
		return false;
	}

	private void teleportHere(EntityPlayer player) {
		if(world.isRemote){
			spawnParticle(500);
		}else{
			BlockPos position = getPos();
			player.setPositionAndUpdate(position.getX() + 0.5, position.up().getY(), position.getZ() + 0.5);
		}
	}

	private void spawnParticle(int amount) {
		for (int i = 0; i < amount; i++) {
			Random random = world.rand;
			double posX = getPos().getX() + random.nextDouble();
			double posY = getPos().getY() + random.nextDouble();
			double posZ = getPos().getZ() + random.nextDouble();
			double speedY = random.nextDouble();
			world.spawnParticle(EnumParticleTypes.PORTAL, posX, posY, posZ, 0, speedY, 0, new int[0]);
		}
	}

	public EnumActionResult attemptTeleport(EntityPlayer player) {
		if (canTeleportHere()) {
			teleportHere(player);
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}
}
