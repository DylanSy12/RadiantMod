package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;

public class RadiantHoe extends ItemHoe 
{
	public RadiantHoe() 
	{
		super(Main.radiantHoeMaterial);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
