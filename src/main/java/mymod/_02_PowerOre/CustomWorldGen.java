package mymod._02_PowerOre;

import java.util.Random;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CustomWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 2, 25, 50, Main.myOre, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 2, 40, 100, Main.mysticalOre, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 2, 13, 5, Main.godOre, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/10, Main.godLuckyBlock, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/7, Main.mysticalLuckyBlock, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/4, Main.luckyBlock, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.STONE);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/13, Main.myStructure, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/10, Main.mysticalSmallStructure, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 175, 1/16, Main.godSmallStructure, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.CONCRETE_POWDER, Blocks.END_STONE, Blocks.GLOWSTONE, Blocks.GRASS_PATH, Blocks.GRAVEL, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.ICE, Blocks.MELON_BLOCK, Blocks.MYCELIUM, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.PUMPKIN, Blocks.REEDS, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND);
		Codakid.fullGeneration(world, random, chunkX, chunkZ, 1, 2, 1/20, Main.tntTower, Blocks.BEDROCK);
	}

}
