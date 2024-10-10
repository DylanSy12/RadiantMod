package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class CustomPickaxe extends ItemPickaxe {
	
	public CustomPickaxe() {
		super(Main.myToolMaterial2);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
