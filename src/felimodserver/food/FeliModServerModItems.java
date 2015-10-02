package felimodserver.food;

import cpw.mods.fml.common.registry.GameRegistry;
import felimodserver.FeliModServerMod;
import net.minecraft.item.Item;

public class FeliModServerModItems
{
	public static Item itemFoodsample;

	public static void registerFeliModServerItems()
	{
		itemFoodsample = new itemFoodsample(400, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemFoodsample, "test");
	}
}
