package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class MysticalShovel extends ItemSpade {
	
	public MysticalShovel() {
		super(Main.myToolMaterial15);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

}
