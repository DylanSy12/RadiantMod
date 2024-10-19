package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class RadiantAxe extends ItemAxe 
{
	public RadiantAxe() 
	{
		super(Main.radiantAxeMaterial, 53f, -2f);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
