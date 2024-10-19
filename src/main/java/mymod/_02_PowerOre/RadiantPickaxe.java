package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class RadiantPickaxe extends ItemPickaxe 
{
	public RadiantPickaxe() 
	{
		super(Main.radiantPickaxeMaterial);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
