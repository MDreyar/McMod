package m_dreyar.dmrt.init;

import m_dreyar.dmrt.Reference;
import m_dreyar.dmrt.tileentity.TileEntityTestBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void register(){
		GameRegistry.registerTileEntity(TileEntityTestBlock.class, Reference.MOD_ID + ":TileEntityTestBlock");
	}
}
