package common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class tabFeliModServerMod extends CreativeTabs
{
	public tabFeliModServerMod(String label)
	{
		super(label);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(Items.apple, 1, 0).getItem();
	}

}
