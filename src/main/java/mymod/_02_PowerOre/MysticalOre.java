package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MysticalOre extends Block {

	public MysticalOre(){
		
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(8f);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(0.5f);
	}
	
}
