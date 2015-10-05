package common.item;

import common.FeliModServerMod;
import common.block.FeliModServerModBlocks;
import common.food.itemFoodsample;
import common.food.itemLimoneFood;
import common.food.itemSaba;
import common.food.itemSabakanFood;
import common.food.itemYakinikudonburi;
import common.food.itemYakinikudonburi_mk2;
import common.food.itemYakinikudonburi_mk3;
import common.food.itemYakinikudonburi_mk4;
import common.food.itemYakinikudonburi_mk5;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.util.EnumHelper;

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
	public static Item itemRiceSeed;
	public static Item itemEnderCannon;

	public static Item itemFooderArmorHelmet;
	public static Item itemFooderArmorChestPlate;
	public static Item itemFooderArmorLeggings;
	public static Item itemFooderArmorBoots;

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

		itemRiceSeed = new ItemSeeds(FeliModServerModBlocks.BlockRice, Blocks.farmland).setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerItem(itemRiceSeed, "Rice Seed");

		itemEnderCannon = new ItemEnderCannon().setCreativeTab(FeliModServerMod.tabFeliModServerMod).setUnlocalizedName("enderCannon");
		GameRegistry.registerItem(itemEnderCannon, "Ender Canonn");


		IItemArmor.ArmorMaterial itemArmor = EnumHelper.addArmorMaterial("FeliModServerItemArmor", 50, new int[]{5,10,8,5}, 5);
		itemArmor.customCraftingMaterial = FeliModServerModItems.itemSaba;

		itemFooderArmorHelmet = new ItemArmor(itemArmor, 0, 0).setCreativeTab(FeliModServerMod.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_helmet");
		GameRegistry.registerItem(itemFooderArmorHelmet, "fooder_armor_helmet");

		itemFooderArmorChestPlate = new ItemArmor(itemArmor, 0, 1).setCreativeTab(FeliModServerMod.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_chestplate");
		GameRegistry.registerItem(itemFooderArmorChestPlate, "fooder_armor_chestplate");

		itemFooderArmorLeggings = new ItemArmor(itemArmor, 0, 2).setCreativeTab(FeliModServerMod.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_leggings");
		GameRegistry.registerItem(itemFooderArmorLeggings, "fooder_armor_leggings");

		itemFooderArmorBoots = new ItemArmor(itemArmor, 0, 3).setCreativeTab(FeliModServerMod.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_boots");
		GameRegistry.registerItem(itemFooderArmorBoots, "fooder_armor_boots");
	}
}
