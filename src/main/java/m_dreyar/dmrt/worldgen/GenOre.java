package m_dreyar.dmrt.worldgen;

import java.util.Random;

import m_dreyar.dmrt.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenOre implements IWorldGenerator {

	private final WorldGenMinable oreGenOverworld;

	public GenOre() {
		oreGenOverworld = new WorldGenMinable(ModBlocks.testOre.getDefaultState(), 7, BlockMatcher.forBlock(Blocks.STONE));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		final BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		switch (world.provider.getDimensionType()) {
		case OVERWORLD:
			for (int i = 0; i < 16; i++) {
				oreGenOverworld.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(53) + 10, random.nextInt(16)));
			}
			break;
		case NETHER:
			break;
		case THE_END:
			break;
		}
	}

}
