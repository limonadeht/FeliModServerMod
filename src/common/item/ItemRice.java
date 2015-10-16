package common.item;

import common.ILHsJapaneseFood;
import net.minecraft.item.Item;

public class ItemRice extends Item
{
	public ItemRice()
	{
		this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		this.setUnlocalizedName("itemRice");
		this.setTextureName("felimodserver:item_rice");
	}
}
