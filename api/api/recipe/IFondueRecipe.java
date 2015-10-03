package api.recipe;

import java.util.ArrayList;

import api.appliance.SoupType;
import net.minecraft.item.ItemStack;

public interface IFondueRecipe {

	Object getInput();

	ArrayList<ItemStack> getProcessedInput();

	ItemStack getOutput();

	SoupType getType();

	public boolean matches(ItemStack items);

}
