package m_dreyar.dmrt;

import static m_dreyar.dmrt.Main.log;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerRegistry implements IGuiHandler {

	private static HashMap<Integer, IGuiHandler> guiHandlers = new HashMap<Integer, IGuiHandler>();
	
	public static void registerGuiHandler(IGuiHandler gui, int id){
		guiHandlers.put(id, gui);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		log.debug("Attempting to open server GUI with id " + ID);
		
		IGuiHandler handler = guiHandlers.get(ID);
		if(handler != null){
			return handler.getServerGuiElement(ID, player, world, x, y, z);
		}else{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		log.debug("Attempting to open client GUI with id " + ID);
		
		IGuiHandler handler = guiHandlers.get(ID);
		if(handler != null){
			return handler.getClientGuiElement(ID, player, world, x, y, z);
		}else{
			return null;
		}
	}

}
