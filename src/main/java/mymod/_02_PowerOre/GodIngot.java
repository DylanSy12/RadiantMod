package mymod._02_PowerOre;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GodIngot extends Item 
{
	public GodIngot() 
	{
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.isBeaconPayment(getDefaultInstance());
	}
}
