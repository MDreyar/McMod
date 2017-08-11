package m_dreyar.dmrt.gui;

import m_dreyar.dmrt.tileentity.TileEntityTestChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTestChest extends Container {

	private TileEntityTestChest tileEntityTestChest;

	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

	private final int VANILLA_FIRST_SLOT_INDEX = 0;
	private final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
	private final int TE_INVENTORY_SLOT_COUNT = 9;

	public ContainerTestChest(InventoryPlayer playerInv, TileEntityTestChest tileIn) {
		tileEntityTestChest = tileIn;

		// Add hotbar
		final int SLOT_X_SPACING = 18;
		final int SLOT_Y_SPACING = 18;
		final int HOTBAR_XPOS = 8;
		final int HOTBAR_YPOS = 109;
		for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
			int slotNumber = x;
			addSlotToContainer(new Slot(playerInv, slotNumber, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
		}

		// Add player inventory
		final int PLAYER_INV_XPOS = 8;
		final int PLAYER_INV_YPOS = 51;
		for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
			for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
				int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
				int xpos = PLAYER_INV_XPOS + x * SLOT_X_SPACING;
				int ypos = PLAYER_INV_YPOS + y * SLOT_Y_SPACING;
				addSlotToContainer(new Slot(playerInv, slotNumber, xpos, ypos));
			}
		}

		if (TE_INVENTORY_SLOT_COUNT != tileEntityTestChest.getSizeInventory()) {
			System.err.println("Mismatched slot count in ContainerTestChest(" + TE_INVENTORY_SLOT_COUNT + ") and TileInventory (" + tileEntityTestChest.getSizeInventory() + ")");
		}

		// Add tile inventory
		final int TILE_INV_XPOS = 8;
		final int TILE_INV_YPOS = 20;
		for (int x = 0; x < TE_INVENTORY_SLOT_COUNT; x++) {
			int slotNumber = x;
			addSlotToContainer(new Slot(tileEntityTestChest, slotNumber, TILE_INV_XPOS + SLOT_X_SPACING * x, TILE_INV_YPOS));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileEntityTestChest.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		Slot sourceSlot = (Slot)inventorySlots.get(index);
		if(sourceSlot == null || !sourceSlot.getHasStack()){
			return ItemStack.EMPTY;
		}
		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();
		
		// Check if the slot clicked is a vanilla container slot
		if(index >= VANILLA_FIRST_SLOT_INDEX && index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT){
			// Try to merge the stack into the tile inventory
			if(!mergeItemStack(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)){
				return ItemStack.EMPTY;
			}
		} else if (index >= TE_INVENTORY_FIRST_SLOT_INDEX && index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT){
			// Try to merge the stack into the player inventory
			if(!mergeItemStack(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)){
				return ItemStack.EMPTY;
			}
		} else {
			System.err.println("Invalid slotIndex: " + index);
			return ItemStack.EMPTY;
		}
		
		if(sourceStack.getCount() == 0){
			sourceSlot.putStack(ItemStack.EMPTY);
		} else {
			sourceSlot.onSlotChanged();
		}
		
		sourceSlot.onTake(playerIn, sourceStack);
		return copyOfSourceStack;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		tileEntityTestChest.closeInventory(playerIn);
	}
}
