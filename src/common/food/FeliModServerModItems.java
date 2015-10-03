package common.food;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class FeliModServerModItems
{
	public static Item itemFoodsample;
	public static Item itemLimoneFood;
	public static Item itemSabakanFood;
	public static Item itemSaba;
	public static Item itemDebug;

	public static void registerFeliModServerItems()
	{
		itemFoodsample = new itemFoodsample(400, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemFoodsample, "test");

		itemLimoneFood = new itemLimoneFood(401, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemLimoneFood, "Limone Food");

		itemSabakanFood = new itemSabakanFood(402, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemSabakanFood, "Sabakan");

		itemSaba = new itemSaba().setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemSaba, "Saba");

		itemDebug = new itemDebug().setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemDebug, "Debugger Item");
	}
}
