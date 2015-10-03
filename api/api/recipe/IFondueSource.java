package api.recipe;

import java.util.ArrayList;

import api.appliance.SoupType;
import net.minecraft.item.ItemStack;

public interface IFondueSource {

	SoupType beforeType();

	ArrayList<ItemStack> getProcessedInput();

	Object getInput();

	SoupType afterType();

	public boolean matches(ItemStack items);

}
