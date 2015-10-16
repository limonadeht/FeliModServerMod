package recipe;

import java.util.HashMap;

import common.Register;
import net.minecraft.item.ItemStack;

public class neiNewRecipeRegister {

	public static HashMap<ItemStack, ItemStack> newRecipeList = new HashMap<ItemStack, ItemStack>();

	/*架空のレシピを登録*/
	public void setRecipeList()
	{
		newRecipeList.put(new ItemStack(Register.itemSaba, 1, 0), new ItemStack(Register.itemSaba, 1, 0));
	}

}
