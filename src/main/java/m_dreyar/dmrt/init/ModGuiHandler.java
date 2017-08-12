package m_dreyar.dmrt.init;

import m_dreyar.dmrt.GuiHandlerRegistry;
import m_dreyar.dmrt.Reference;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler {
	
	public static void registerGuiHandlers(){
		registerGuiHandler(Reference.GuiHandlers.TESTCHEST.getGuiHandler(), Reference.GuiHandlers.TESTCHEST.getGuiID());
	}
	
	private static void registerGuiHandler(IGuiHandler handler, int ID){
		GuiHandlerRegistry.registerGuiHandler(handler, ID);
	}
}
