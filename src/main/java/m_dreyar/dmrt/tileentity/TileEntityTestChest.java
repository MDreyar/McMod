package m_dreyar.dmrt.tileentity;

import java.util.Arrays;

import m_dreyar.dmrt.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityTestChest extends TileEntity implements IInventory {

	private final int INVENTORY_SIZE = 9;
	private ItemStack[] itemStacks;

	public TileEntityTestChest() {
		itemStacks = new ItemStack[INVENTORY_SIZE];
		clear();
	}

	@Override
	public String getName() {
		return "container." + Reference.Blocks.TESTCHEST.getRegistryName() + ".name";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.length;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemStack : itemStacks) {
			if (!itemStack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return itemStacks[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack itemStackInSlot = itemStacks[index];
		if (itemStackInSlot.isEmpty()) {
			return ItemStack.EMPTY;
		}

		ItemStack itemStackRemoved;
		if (itemStackInSlot.getCount() <= count) {
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(index, ItemStack.EMPTY);
		} else {
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.getCount() == 0) {
				setInventorySlotContents(index, ItemStack.EMPTY);
			}
		}
		markDirty();
		return itemStackRemoved;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack itemStackRemoved = itemStacks[index];
		if (!itemStackRemoved.isEmpty()) {
			setInventorySlotContents(index, ItemStack.EMPTY);
		}
		return itemStackRemoved;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		itemStacks[index] = stack;
		markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (world.getTileEntity(pos) != this) {
			return false;
		}
		final double MAX_DISTANCE_SQUARED = 8.0 * 8.0;
		return player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < MAX_DISTANCE_SQUARED;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		Arrays.fill(itemStacks, ItemStack.EMPTY);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		NBTTagList dataForAllSlots = new NBTTagList();
		for(int i = 0; i < itemStacks.length; i++){
			if(!itemStacks[i].isEmpty()){
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		compound.setTag("Items", dataForAllSlots);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		final byte NBT_TYPE_COMPOUND = 10; // NBTTagCompound
		NBTTagList dataForAllSlots = compound.getTagList("Items", NBT_TYPE_COMPOUND);
		
		Arrays.fill(itemStacks, ItemStack.EMPTY);
		for(int i = 0; i < dataForAllSlots.tagCount(); i++){
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;
			
			if(slotIndex >= 0 && slotIndex < itemStacks.length){
				itemStacks[slotIndex] = new ItemStack(dataForOneSlot);
			}
		}
	}
}
