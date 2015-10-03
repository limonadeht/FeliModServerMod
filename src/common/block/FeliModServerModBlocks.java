package common.block;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FeliModServerModBlocks
{
	public static Block BlockBento;
	public static Block BlockFoodCraftTable;
	public static Block BlockRiceCooker;

	public static void registerFeliModServerModBlocks()
	{
		BlockBento = new BlockBento(Material.fire).setBlockName("Bento").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockBento, "Bento");

		BlockFoodCraftTable = new BlockFoodCraftTable().setBlockName("Food CraftTable");
		GameRegistry.registerBlock(BlockFoodCraftTable, "Food CraftTable");

		/*BlockRiceCooker = new BlockRiceCooker().setBlockName("Rice Cooker").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockRiceCooker, "Rice Cooker");*/
	}
}
