package m_dreyar.dmrt;

import m_dreyar.dmrt.gui.handler.GuiHandlerTestChest;
import net.minecraftforge.fml.common.network.IGuiHandler;

// Holds references for easy updating
public class Reference {

	public static final String MOD_ID = "dmrt";
	public static final String MOD_NAME = "Dreyar's many random things";
	public static final String VERSION = "1.12 - 0.0.1.0";
	public static final String ACCEPTED_VERSIONS = "[1.12]";

	public static final String CLIENT_PROXY = "m_dreyar.dmrt.proxy.ClientProxy";
	public static final String COMMON_PROXY = "m_dreyar.dmrt.proxy.CommonProxy";

	public static enum Items {
		TESTITEM("testItem", "test_item"), TESTINGOT("testIngot", "test_ingot"), TESTSWORD("testSword", "test_sword"),
		RECALL("recall", "recall");

		private String unlocalizedName;
		private String registryName;

		Items(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}
	}

	public static enum Blocks {
		TESTBLOCK("testBlock", "test_block"), TESTORE("testOre", "test_ore"),
		TESTITEMHOLDER("testItemHolder", "test_item_holder"), TESTCHEST("testChest", "test_chest"),
		TESTFURNACE("testFurnace", "test_furnace"), TELEPORTER("teleporter", "teleporter");

		private String unlocalizedName;
		private String registryName;

		Blocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}
	}
	
	public static enum GuiHandlers {
		TESTCHEST(new GuiHandlerTestChest(), 1);
		
		private IGuiHandler guiHandler;
		private int guiID;
		
		GuiHandlers(IGuiHandler guiHandler, int guiID){
			this.guiHandler = guiHandler;
			this.guiID = guiID;
		}
		
		public IGuiHandler getGuiHandler(){
			return guiHandler;
		}
		
		public int getGuiID(){
			return guiID;
		}
	}
}
