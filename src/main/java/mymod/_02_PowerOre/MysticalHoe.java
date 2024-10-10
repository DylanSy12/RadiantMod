package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;

public class MysticalHoe extends ItemHoe {
	
	public MysticalHoe() {
		super(Main.myToolMaterial14);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
