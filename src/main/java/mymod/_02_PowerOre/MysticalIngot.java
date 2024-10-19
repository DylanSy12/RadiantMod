package mymod._02_PowerOre;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MysticalIngot extends Item 
{
	public MysticalIngot() 
	{
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.isBeaconPayment(getDefaultInstance());
	}
}
