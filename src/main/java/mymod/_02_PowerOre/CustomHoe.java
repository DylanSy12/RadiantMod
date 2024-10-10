package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;

public class CustomHoe extends ItemHoe {
	
	public CustomHoe() {
		super(Main.myToolMaterial11);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
