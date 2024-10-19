package mymod._02_PowerOre;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class MysticalPickaxe extends ItemPickaxe 
{
	public MysticalPickaxe() 
	{
		super(Main.mysticalPickaxeMaterial);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
