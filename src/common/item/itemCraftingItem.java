package common.item;

import common.ILHsJapaneseFood;
import net.minecraft.item.Item;

public class itemCraftingItem extends Item
{
	public itemCraftingItem()
	{
		this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		this.setMaxDamage(30);
	}


}
