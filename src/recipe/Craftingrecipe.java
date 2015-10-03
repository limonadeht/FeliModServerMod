package recipe;

import common.food.FeliModServerModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Craftingrecipe{
	public static void registerFeliModServerModCraftingRecipes(){
//���V�s�̃��\�b�h���`�@�߂�l����void�@
        GameRegistry.addRecipe(new ItemStack(FeliModServerModItems.itemSaba),
                "c",
                "f",
                "c",
                'f', Items.fish,
                'c', Items.coal
        );
//���V�s�̐ݒ�@�����܂łň�̃��V�s
        GameRegistry.addRecipe(new ItemStack(FeliModServerModItems.itemSabakanFood),
                "iii",
                "isi",
                "iii",
                's', FeliModServerModItems.itemSaba,
                'i', Items.iron_ingot
        );

   }

}

