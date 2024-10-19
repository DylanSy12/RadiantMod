package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class GodAxe extends ItemAxe 
{
	public GodAxe() 
	{
		super(Main.godAxeMaterial, 105f, -1.5f);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
