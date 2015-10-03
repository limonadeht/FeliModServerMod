package recipe;

import common.food.FeliModServerModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Craftingrecipe{
	public static void registerFeliModServerModRecipes(){
//レシピのメソッドを定義　戻り値無しvoid　
        GameRegistry.addRecipe(new ItemStack(FeliModServerModItems.itemSaba),
                "c",
                "f",
                "c",
                'f', Items.fish,
                'c', Items.coal
        );
//レシピの設定　ここまでで一つのレシピ
        GameRegistry.addRecipe(new ItemStack(FeliModServerModItems.itemSabakanFood),
                "iii",
                "isi",
                "iii",
                's', FeliModServerModItems.itemSaba,
                'i', Items.iron_ingot
        );

   }

}

