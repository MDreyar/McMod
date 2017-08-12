package m_dreyar.dmrt.gui.handler;

import m_dreyar.dmrt.container.ContainerTestChest;
import m_dreyar.dmrt.gui.GuiTestChest;
import m_dreyar.dmrt.tileentity.TileEntityTestChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerTestChest implements IGuiHandler {

	private final static int TESTCHEST = 1;
	
	public static int getGuiId(){
		return TESTCHEST;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != TESTCHEST) {
			System.err.println("Invalid ID: expected " + TESTCHEST + ", received " + ID);
		}

		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityTestChest) {
			TileEntityTestChest tile = (TileEntityTestChest) tileEntity;
			return new ContainerTestChest(player.inventory, tile);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != TESTCHEST) {
			System.err.println("Invalid ID: expected " + TESTCHEST + ", received " + ID);
		}

		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityTestChest) {
			TileEntityTestChest tile = (TileEntityTestChest) tileEntity;
			return new GuiTestChest(player.inventory, tile);
		}
		return null;
	}

}
