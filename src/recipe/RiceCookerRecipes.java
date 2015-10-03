package recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RiceCookerRecipes {

	private static final RiceCookerRecipes smeltingBase = new RiceCookerRecipes();


	public static RiceCookerRecipes smelting(){
		return smeltingBase;
	}

	public static void registerFeliModServerModRiceCookerRecipes(){
		GameRegistry.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
	}

	public ItemStack getSmeltingResult(ItemStack itemStack) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
