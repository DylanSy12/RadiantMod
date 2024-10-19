package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class RadiantShovel extends ItemSpade 
{
	public RadiantShovel() 
	{
		super(Main.radiantShovelMaterial);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
