package common.food;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class FeliModServerModItems
{
	public static Item itemFoodsample;
	public static Item itemLimoneFood;

	public static void registerFeliModServerItems()
	{
		itemFoodsample = new itemFoodsample(400, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemFoodsample, "test");

		itemLimoneFood = new itemLimoneFood(401, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemLimoneFood, "Limone Food");
	}
}
