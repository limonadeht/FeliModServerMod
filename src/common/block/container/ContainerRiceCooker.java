package common.block.container;

import client.model.tileentity.TileEntityRiceCooker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import recipe.RiceCookerRecipes;

public class ContainerRiceCooker extends Container{

	private TileEntityRiceCooker ricecooker;

	public int lastburnTime;
	public int lastcurrentItemBurnTime;
	public int lastcookTime;


	public ContainerRiceCooker(InventoryPlayer inventory,TileEntityRiceCooker tileentity){
		this.ricecooker = tileentity;

		this.addSlotToContainer(new Slot(tileentity,0, 17,17));
		this.addSlotToContainer(new Slot(tileentity,1, 17,53));
		this.addSlotToContainer(new SlotFurnace(inventory.player,tileentity ,2, 116,34));

		for(int i = 0;i < 3;i++){
			for(int j = 0;j < 9;j++){
				this.addSlotToContainer(new Slot(inventory,j+i*9+9,8+j*18,84+i*18));
			}
		}

		for(int i=0; i< 9;i++){
			this.addSlotToContainer(new Slot(inventory,i,8+i*18,142));
		}
	}

	public void addCrafttingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.ricecooker.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.ricecooker.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.ricecooker.currentItemBurnTime);
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0;i < this.crafters.size();i++){
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if(this.lastcookTime != this.ricecooker.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.ricecooker.cookTime);
			}
			if(this.lastburnTime != this.ricecooker.cookTime){
				icrafting.sendProgressBarUpdate(this, 1, this.ricecooker.burnTime);
			}
			if(this.lastcurrentItemBurnTime != this.ricecooker.cookTime){
				icrafting.sendProgressBarUpdate(this, 2, this.ricecooker.currentItemBurnTime);
			}
		}

		this.lastcookTime = this.ricecooker.cookTime;
		this.lastburnTime = this.ricecooker.burnTime;
		this.lastcurrentItemBurnTime = this.ricecooker.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if (par1 == 0)
		{
			this.ricecooker.cookTime = par2;
		}

		if (par1 == 1)
		{
			this.ricecooker.burnTime = par2;
		}

		if (par1 == 2)
		{
			this.ricecooker.currentItemBurnTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.ricecooker.isUseableByPlayer(entityplayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityplayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2)
			{

				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (par2 != 1 && par2 != 0)
			{
				if (RiceCookerRecipes.smelting().getSmeltingResult(itemstack1) != null)
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
					else if (TileEntityRiceCooker.isItemFuel(itemstack1))
					{
						if (!this.mergeItemStack(itemstack1, 1, 2, false))
						{
							return null;
						}
					}
					else if (par2 >= 3 && par2 < 30)
					{
						if (!this.mergeItemStack(itemstack1, 30, 39, false))
						{
							return null;
						}
					}
					else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
					{
						return null;
					}
				}
				else if (!this.mergeItemStack(itemstack1, 3, 39, false))
				{
					return null;
				}

				if (itemstack1.stackSize == 0)
				{
					slot.putStack((ItemStack)null);
				}
				else
				{
					slot.onSlotChanged();
				}

				if (itemstack1.stackSize == itemstack.stackSize)
				{
					return null;
				}

				slot.onPickupFromSlot(entityplayer, itemstack1);
			}
		}
		return itemstack;
	}
}
