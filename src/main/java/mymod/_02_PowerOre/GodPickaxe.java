package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class GodPickaxe extends ItemPickaxe 
{
	public GodPickaxe() 
	{
		super(Main.godPickaxeMaterial);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
