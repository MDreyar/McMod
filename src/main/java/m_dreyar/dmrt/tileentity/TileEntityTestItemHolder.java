package m_dreyar.dmrt.tileentity;

import m_dreyar.dmrt.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

// A simple tile entity that stores test items
public class TileEntityTestItemHolder extends TileEntity {
	private int amountOfSticks = 0;
	private final int MAXSTICKS = 8;

	// Attempt to put a testItem in the TileEntity
	public boolean putStick() {
		if (!world.isRemote) {
			if (amountOfSticks < MAXSTICKS) {
				amountOfSticks++;
				this.markDirty();
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				return true;
			}
		}
		return false;
	}

	// Attempts to take a testItem from the TileEntity
	public void takeStick() {
		if (!world.isRemote) {
			if (amountOfSticks > 0) {
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.testItem)));
				amountOfSticks--;
				this.markDirty();
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
			}
		}
	}

	public void takeAllSticks() {
		if (!world.isRemote) {
			if (amountOfSticks > 0) {
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.testItem, amountOfSticks)));
				amountOfSticks = 0;
				this.markDirty();
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
			}
		}
	}

	// Returns the amount of testItems in the TileEntity
	public int getStickCount() {
		return amountOfSticks;
	}

	// Write data to the NBT tag
	public void writeUpdateTag(NBTTagCompound tag) {
		tag.setInteger("stickCount", amountOfSticks);
	}

	// Read data from the NBT tag
	public void readUpdateTag(NBTTagCompound tag) {
		this.amountOfSticks = tag.getInteger("stickCount");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		writeUpdateTag(compound);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		readUpdateTag(compound);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeUpdateTag(tag);
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		writeUpdateTag(tag);
		return tag;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.getNbtCompound();
		readUpdateTag(tag);
	}
}
