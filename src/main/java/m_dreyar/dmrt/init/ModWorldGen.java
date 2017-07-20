package m_dreyar.dmrt.init;

import m_dreyar.dmrt.worldgen.GenOre;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {

	public static void registerWorldGenerators(){
		GameRegistry.registerWorldGenerator(new GenOre(), 0);
	}
}
