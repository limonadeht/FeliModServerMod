package common;

import java.awt.Color;

import common.block.BlockBento;
import common.block.BlockFoodCraftTable;
import common.block.BlockRice;
import common.block.BlockRiceCooker;
import common.block.BlockSushi_1;
import common.block.BlockTv;
import common.entity.EntityLychever;
import common.entity.EntityStarCannonBullet;
import common.fluid.BlockLimoneFluid;
import common.fluid.ItemBucketLimone;
import common.food.itemFoodsample;
import common.food.itemLimoneFood;
import common.food.itemSaba;
import common.food.itemSabakanFood;
import common.food.itemYakinikudonburi;
import common.food.itemYakinikudonburi_mk2;
import common.food.itemYakinikudonburi_mk3;
import common.food.itemYakinikudonburi_mk4;
import common.food.itemYakinikudonburi_mk5;
import common.item.IItemArmor;
import common.item.ItemEnderCannon;
import common.item.ItemFoodCrystal;
import common.item.ItemFooderAxe;
import common.item.ItemFooderPickaxe;
import common.item.ItemFooderToolMaster;
import common.item.ItemRice;
import common.item.ItemSpawnEggLychever;
import common.item.ItemStarCannon;
import common.item.itemDebug;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSpade;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Register
{
	//ブロック
	public static Block BlockBento;
	public static Block BlockTV;
	public static Block BlockSushi_1;
	public static Block BlockFoodCraftTable;
	public static Block BlockRiceCookerIdle;
	public static Block BlockRiceCookerActive;
	public static Block BlockRice;

	//アイテム
	public static Item itemSaba;
	public static Item itemDebug;
	public static Item ItemFoodCrystal;
	public static Item itemRice;
	public static Item itemRiceSeed;
	public static Item itemEnderCannon;
	public static Item ItemStarCannon;
	public static Item FelModiItemBucket;

	//食べ物
	public static Item itemYakinikudonburi;
	public static Item itemYakinikudonburi_mk2;
	public static Item itemYakinikudonburi_mk3;
	public static Item itemYakinikudonburi_mk4;
	public static Item itemYakinikudonburi_mk5;
	public static Item itemFoodsample;
	public static Item itemLimoneFood;
	public static Item itemSabakanFood;

	//ツール
	public static Item ItemFooderPickaxe;
	public static Item ItemFooderShovel;
	public static Item ItemFooderAxe;
	public static Item ItemFooderSword;
	public static Item ItemFooderToolMaster;

	//防具
	public static Item itemFooderArmorHelmet;
	public static Item itemFooderArmorChestPlate;
	public static Item itemFooderArmorLeggings;
	public static Item itemFooderArmorBoots;

	//液体系
	public static Fluid FluidLimone;
	public static Block FluidBlockLimone;
	public static Item ItemBucketLimone;


	public static void REgister()
	{
		BlockBento = new BlockBento(Material.fire).setBlockName("Bento").setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockBento, "Bento");

		BlockFoodCraftTable = new BlockFoodCraftTable().setBlockName("Food CraftTable");
		GameRegistry.registerBlock(BlockFoodCraftTable, "Food CraftTable");

		//機械
		BlockRiceCookerIdle = new BlockRiceCooker(false).setBlockName("Rice Cooker").setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockRiceCookerIdle, "RiceCookerIdle");

		BlockRiceCookerActive = new BlockRiceCooker(true).setBlockName("Rice Cooker Active").setLightLevel(1.0F);
		GameRegistry.registerBlock(BlockRiceCookerActive, "RiceCookerActive");

		BlockRice = new BlockRice().setBlockName("Rice").setBlockTextureName("felimodserver/texture/plants");
		GameRegistry.registerBlock(BlockRice, "Rice");

		BlockTV = new BlockTv(Material.iron).setBlockName("TV").setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockTV, "TV");

		BlockSushi_1 = new BlockSushi_1().setBlockName("Sushi_1");
		GameRegistry.registerBlock(BlockSushi_1, "Sushi_1");

		itemFoodsample = new itemFoodsample(400, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemFoodsample, "test");

		itemLimoneFood = new itemLimoneFood(401, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemLimoneFood, "Limone Food");

		itemSabakanFood = new itemSabakanFood(402, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemSabakanFood, "Sabakan");

		itemSaba = new itemSaba().setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemSaba, "Saba");

		itemDebug = new itemDebug().setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemDebug, "Debugger Item");

		itemYakinikudonburi = new itemYakinikudonburi(403, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi, "Yakinikudonburi");

		itemYakinikudonburi_mk2 = new itemYakinikudonburi_mk2(404, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk2, "Yakinikudonburi Mk2");

		itemYakinikudonburi_mk3 = new itemYakinikudonburi_mk3(405, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk3, "Yakinikudonburi Mk3");

		itemYakinikudonburi_mk4 = new itemYakinikudonburi_mk4(406, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk4, "Yakinikudonburi Mk4");

		itemYakinikudonburi_mk5 = new itemYakinikudonburi_mk5(407, 5, false).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemYakinikudonburi_mk5, "Yakinikudonburi Mk5");

		ItemFoodCrystal = new ItemFoodCrystal().setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod).setUnlocalizedName("itemFoodCrystal");
		GameRegistry.registerItem(ItemFoodCrystal, "FoodCrystal");

		itemRiceSeed = new ItemSeeds(Register.BlockRice, Blocks.farmland).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod).setUnlocalizedName("felimodserver:itemRiceSeed").setTextureName("felimodserver:seeds_rice");
		GameRegistry.registerItem(itemRiceSeed, "Rice Seed");

		itemRice = new ItemRice().setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod).setTextureName("felimodserver:item_rice")
				.setUnlocalizedName("itemRice");
		GameRegistry.registerItem(itemRice, "item_Rice");

		itemEnderCannon = new ItemEnderCannon().setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod).setUnlocalizedName("enderCannon");
		GameRegistry.registerItem(itemEnderCannon, "Ender Canonn");

		Item.ToolMaterial fooderTool = EnumHelper.addToolMaterial("fooderTool", 3, -1, 500.0F, 998.0F, 10);

		//ツール
		ItemFooderPickaxe = new ItemFooderPickaxe(fooderTool).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setTextureName("felimodserver:fooder_pickaxe")
				.setUnlocalizedName("felimodserver:fooder_pickaxe");
		GameRegistry.registerItem(ItemFooderPickaxe, "Fooder's Tool [Pickaxe]");

		ItemFooderShovel = new ItemSpade(fooderTool).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setTextureName("felimodserver:fooder_shovel")
				.setUnlocalizedName("felimodserver:fooder_shovel");
		GameRegistry.registerItem(ItemFooderShovel, "Fooder's Tool [Shovel]");

		ItemFooderAxe = new ItemFooderAxe(fooderTool).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setTextureName("felimodserver:fooder_axe")
				.setUnlocalizedName("felimodserver:fooder_axe");
		GameRegistry.registerItem(ItemFooderAxe, "Fooder's Tool [Axe]");

		ItemFooderToolMaster = new ItemFooderToolMaster(fooderTool).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setTextureName("felimodserver:fooder_tool_master")
				.setUnlocalizedName("felimodserver:fooder_tool_master");
		GameRegistry.registerItem(ItemFooderToolMaster, "Fooder's Tool [Master]");


		//装填数，射程距離(弓の最大1.0F)，攻撃力補正，攻撃後のWAIT，リロード後のWAIT，効果音，ノックバックの有無，炎上効果の有無
		ItemStarCannon = new ItemStarCannon(6, 1.0F, 2.0D, 10, 30, "Star Cannon" ,false ,false)
				.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setUnlocalizedName("felimodserver:starCannon");
		GameRegistry.registerItem(ItemStarCannon, "Star Cannon");


		//SpawnEgg
		Item itemSpawnEgg = new ItemSpawnEggLychever(Color.RED.getRGB(), Color.WHITE.getRGB())
			    .setUnlocalizedName("egg")
			    .setTextureName("spawn_egg")
			    .setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerItem(itemSpawnEgg, "LycheverSpawnEgg");


		//防具
		IItemArmor.ArmorMaterial itemArmor = EnumHelper.addArmorMaterial("FeliModServerItemArmor", -1, new int[]{500,500,500,500}, 5);
		itemArmor.customCraftingMaterial = Register.itemSaba;

		itemFooderArmorHelmet = new ItemArmor(itemArmor, 0, 0).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_helmet").setTextureName("felimodserver:_armor_helmet");
		GameRegistry.registerItem(itemFooderArmorHelmet, "fooder_armor_helmet");

		itemFooderArmorChestPlate = new ItemArmor(itemArmor, 0, 1).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_chestplate").setTextureName("felimodserver:_armor_chestplate");
		GameRegistry.registerItem(itemFooderArmorChestPlate, "fooder_armor_chestplate");

		itemFooderArmorLeggings = new ItemArmor(itemArmor, 0, 2).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_leggings").setTextureName("felimodserver:_armor_leggings");
		GameRegistry.registerItem(itemFooderArmorLeggings, "fooder_armor_leggings");

		itemFooderArmorBoots = new ItemArmor(itemArmor, 0, 3).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod)
				.setUnlocalizedName("fooder_armor_boots").setTextureName("felimodserver:_armor_boots");
		GameRegistry.registerItem(itemFooderArmorBoots, "fooder_armor_boots");

		//MOB
		EntityRegistry.registerModEntity(EntityLychever.class, "Lychever", 0, ILHsJapaneseFood.MOD_ID, 250, 1, false);
        EntityRegistry.addSpawn(EntityLychever.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);

        EntityRegistry.registerGlobalEntityID(EntityStarCannonBullet.class, "StarCannon.bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.instance().registerModEntity(EntityStarCannonBullet.class, "StarCannon.bullet", 1, ILHsJapaneseFood.MOD_ID, 128, 1, true);

        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
        }

        //液体
        FluidLimone = new Fluid("FluidLimone").setDensity(800).setViscosity(1500).setLuminosity(15);
		FluidRegistry.registerFluid(FluidLimone);

		FluidBlockLimone = new BlockLimoneFluid(FluidLimone, Material.water).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		GameRegistry.registerBlock(FluidBlockLimone, "FluidBlockLimone");

		ItemBucketLimone = new ItemBucketLimone(FluidBlockLimone).setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod).setUnlocalizedName("bucketLimone");
		GameRegistry.registerItem(ItemBucketLimone, "BucketLimone");
	}
}
