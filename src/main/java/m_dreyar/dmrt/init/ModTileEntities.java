package m_dreyar.dmrt.init;

import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.tileentity.TileEntityTestItemHolder;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void register(){
		GameRegistry.registerTileEntity(TileEntityTestItemHolder.class, Reference.MOD_ID + ":TileEntityTestBlock");
	}
}
