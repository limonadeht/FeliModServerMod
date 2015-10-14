package handler;

import common.item.FeliModServerModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class CraftingHandler{
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		for (int i = 0; i < craftMatrix.getSizeInventory(); i++) // Checks all
																	// the slots
		{
			if (craftMatrix.getStackInSlot(i) != null) // If there is an item
			{
				ItemStack j = craftMatrix.getStackInSlot(i); // Gets the item
				if (j.getItem() != null && j.getItem() == FeliModServerModItems.ItemFoodCrystal)
				{
					ItemStack k = new ItemStack(FeliModServerModItems.ItemFoodCrystal, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					craftMatrix.setInventorySlotContents(i, k);
				}
			}
		}
	}

	public void onSmelting(EntityPlayer player, ItemStack item) {
	}
}
