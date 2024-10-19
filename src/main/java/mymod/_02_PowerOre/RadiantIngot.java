package mymod._02_PowerOre;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RadiantIngot extends Item 
{
	public RadiantIngot() 
	{
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.isBeaconPayment(getDefaultInstance());
	}
}
