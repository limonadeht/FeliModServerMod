package felimodserver.block;

import cpw.mods.fml.common.registry.GameRegistry;
import felimodserver.FeliModServerMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FeliModServerModBlocks
{
	public static Block BlockBento;

	public static void registerFeliModServerModBlocks()
	{
		BlockBento = new BlockBento(Material.fire).setBlockName("Bento").setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		GameRegistry.registerBlock(BlockBento, "Bento");
	}
}
