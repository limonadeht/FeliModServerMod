package common.item;

import common.FeliModServerMod;
import net.minecraft.item.Item;

public class ItemRice extends Item
{
	public ItemRice()
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setUnlocalizedName("itemRice");
		this.setTextureName("felimodserver:item_rice");
	}
}
