package mymod._06_BrandNewBiomes;

import java.awt.Color;
import java.util.Random;

import mymod.Main;
import mymod.CodakidFiles.CKWorldGenerater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GodBiome extends Biome {
	
	private static BiomeProperties properties = new Biome.BiomeProperties("God Land");
	static {
		
	    //Set properties here
		properties.setBaseHeight(0.3f);
		properties.setHeightVariation(1f);
		properties.setWaterColor(Color.WHITE.getRGB());
//		properties.setTemperature(0f);
		properties.setRainDisabled();
	}

	public GodBiome() {
		super(properties);
		this.setRegistryName(new ResourceLocation(Main.MODID, "god_biome"));
		
//		this.decorator. = ;
		
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunk, int num1, int num2, double num3) {
		
		//Set top and filler blocks here
		int number = rand.nextInt(50) + 1;
		
		if(number < 3) {
			this.topBlock = Main.godLuckyBlock.getDefaultState();
			this.fillerBlock = Main.godBlock.getDefaultState();
		}
		else {
			this.topBlock = Main.godBlock.getDefaultState();
			this.fillerBlock = Main.godOre.getDefaultState();
		}

		this.generateBiomeTerrain(worldIn, rand, chunk, num1, num2, num3);
	}

}
