package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class CustomAxe extends ItemAxe {
	
	public CustomAxe() {
		super(Main.myToolMaterial10,53f,-2f);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
