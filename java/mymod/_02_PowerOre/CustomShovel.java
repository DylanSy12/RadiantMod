package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class CustomShovel extends ItemSpade {
	
	public CustomShovel() {
		super(Main.myToolMaterial12);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
