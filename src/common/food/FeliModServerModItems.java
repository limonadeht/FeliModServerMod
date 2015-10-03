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
	public static Item itemYakinikudonburi;
	public static Item itemYakinikudonburi_mk2;
	public static Item itemYakinikudonburi_mk3;
	public static Item itemYakinikudonburi_mk4;
	public static Item itemYakinikudonburi_mk5;

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

		itemYakinikudonburi = new itemYakinikudonburi(403, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi, "Yakinikudonburi");

		itemYakinikudonburi_mk2 = new itemYakinikudonburi_mk2(404, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk2, "Yakinikudonburi Mk2");

		itemYakinikudonburi_mk3 = new itemYakinikudonburi_mk3(405, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk3, "Yakinikudonburi Mk3");

		itemYakinikudonburi_mk4 = new itemYakinikudonburi_mk4(406, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk4, "Yakinikudonburi Mk4");

		itemYakinikudonburi_mk5 = new itemYakinikudonburi_mk5(407, 5, false).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk5, "Yakinikudonburi Mk5");
	}
}
