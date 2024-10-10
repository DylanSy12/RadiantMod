package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class GodShovel extends ItemSpade {
	
	public GodShovel() {
		super(Main.myToolMaterial18);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
