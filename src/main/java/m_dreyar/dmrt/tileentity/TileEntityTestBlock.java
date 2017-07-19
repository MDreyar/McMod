package m_dreyar.dmrt.tileentity;

import m_dreyar.dmrt.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

// A simple tile entity that stores test items
public class TileEntityTestBlock extends TileEntity{
	private int amountOfSticks = 0;
	private final int MAXSTICKS = 8;
	
	public boolean putStick(){
		if(!world.isRemote){
			if(amountOfSticks < MAXSTICKS){
				amountOfSticks++;
				this.markDirty();
				return true;
			}
		}
		return false;
	}
	
	public void takeStick(){
		if(!world.isRemote){
			if(amountOfSticks > 0){
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.testItem)));
				amountOfSticks--;
				this.markDirty();
			}
		}
	}
	
	public void takeAllSticks(){
		if(!world.isRemote){
			if(amountOfSticks > 0){
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.testItem, amountOfSticks)));
				amountOfSticks = 0;
				this.markDirty();
			}
		}
	}
	
	public int getStickCount(){
		return amountOfSticks;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("stickCount", amountOfSticks);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.amountOfSticks = compound.getInteger("stickCount");
	}
}
