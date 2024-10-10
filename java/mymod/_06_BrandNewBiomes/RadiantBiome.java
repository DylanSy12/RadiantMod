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

public class RadiantBiome extends Biome {
	
	private static BiomeProperties properties = new Biome.BiomeProperties("Radiant Land");
	static {
		
	    //Set properties here
		properties.setBaseHeight(0.3f);
		properties.setHeightVariation(1f);
		properties.setWaterColor(Color.ORANGE.getRGB());
//		properties.setTemperature(0f);
		properties.setRainDisabled();
	}

	public RadiantBiome() {
		super(properties);
		this.setRegistryName(new ResourceLocation(Main.MODID, "radiant_biome"));
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunk, int num1, int num2, double num3) {
		
		//Set top and filler blocks here
		int number = rand.nextInt(45) + 1;
		
		if(number < 3) {
			this.topBlock = Main.luckyBlock.getDefaultState();
			this.fillerBlock = Main.radiantBlock.getDefaultState();
		}
		
		else {
			this.topBlock = Main.radiantBlock.getDefaultState();
			this.fillerBlock = Main.myOre.getDefaultState();
		}

		this.generateBiomeTerrain(worldIn, rand, chunk, num1, num2, num3);
	}

}
