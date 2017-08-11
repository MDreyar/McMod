package m_dreyar.dmrt.items;

import java.util.List;

import m_dreyar.dmrt.Main;
import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.tileentity.TileEntityTeleporter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRecall extends Item {

	public ItemRecall() {
		setUnlocalizedName(Reference.Items.RECALL.getUnlocalizedName());
		setRegistryName(Reference.Items.RECALL.getRegistryName());
		setCreativeTab(Main.CREATIVETAB);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// Check for NBT tag, if none found, create one
		NBTTagCompound nbt;
		if (player.getHeldItem(hand).hasTagCompound()) {
			nbt = player.getHeldItem(hand).getTagCompound();
		} else {
			nbt = new NBTTagCompound();
		}

		if (!nbt.hasKey("Loc")) {
			if (worldIn.getTileEntity(pos) instanceof TileEntityTeleporter) {
				int[] loc = { pos.getX(), pos.getY(), pos.getZ() };
				nbt.setIntArray("Loc", loc);
				player.getHeldItem(hand).setTagCompound(nbt);
				return EnumActionResult.SUCCESS;
			}
		}
		return EnumActionResult.PASS;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		// Check for NBT tag
		NBTTagCompound nbt;
		if (playerIn.getHeldItem(handIn).hasTagCompound()) {
			nbt = playerIn.getHeldItem(handIn).getTagCompound();
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}

		if (nbt.hasKey("Loc")) {
			int[] loc = nbt.getIntArray("Loc");
			BlockPos position = new BlockPos(loc[0], loc[1], loc[2]);
			if (worldIn.getTileEntity(position) instanceof TileEntityTeleporter) {
				TileEntityTeleporter tile = (TileEntityTeleporter) worldIn.getTileEntity(position);
				EnumActionResult result = tile.attemptTeleport(playerIn);
				return new ActionResult<ItemStack>(result, playerIn.getHeldItem(handIn));
			} else {
				return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
			}
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		// Check for NBT tag, if none found,
		NBTTagCompound nbt;
		if (stack.hasTagCompound()) {
			nbt = stack.getTagCompound();
		} else {
			return;
		}

		if (nbt.hasKey("Loc")) {
			int[] loc = nbt.getIntArray("Loc");
			tooltip.add("Linked to teleporter at X:" + loc[0] + " Y:" + loc[1] + " Z:" + loc[2]);
		}
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("Loc")) {
				return true;
			}
		}
		return super.hasEffect(stack);
	}
}
