package common.block;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FeliModServerModBlocks
{
	public static Block BlockBento;
	public static Block BlockWhitedStone;

	public static Block BlockFoodCraftTable;

	public static Block BlockRiceCookerIdle;
	public static Block BlockRiceCookerActive;

	public static Block BlockRice;


	public static void registerFeliModServerModBlocks()
	{
		BlockBento = new BlockBento(Material.fire).setBlockName("Bento").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockBento, "Bento");

		BlockFoodCraftTable = new BlockFoodCraftTable().setBlockName("Food CraftTable");
		GameRegistry.registerBlock(BlockFoodCraftTable, "Food CraftTable");

		//機械
		BlockRiceCookerIdle = new BlockRiceCooker(false).setBlockName("Rice Cooker").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockRiceCookerIdle, "RiceCookerIdle");

		BlockRiceCookerActive = new BlockRiceCooker(true).setBlockName("Rice Cooker Active").setLightLevel(1.0F);
		GameRegistry.registerBlock(BlockRiceCookerActive, "RiceCookerActive");

		BlockRice = new BlockRice().setBlockName("Rice").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockRice, "Rice");
	}
}
