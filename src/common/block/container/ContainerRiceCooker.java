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

public class ContainerRiceCooker extends Container{

	private TileEntityRiceCooker ricecooker;

	public int lastburnTime;
	public int lastcurrentItemBurnTime;
	public int lastcookTime;


	public ContainerRiceCooker(InventoryPlayer inventory,TileEntityRiceCooker tileentity){
		this.ricecooker = tileentity;

		this.addSlotToContainer(new Slot(tileentity,0, 16,16));
		this.addSlotToContainer(new Slot(tileentity,1, 16,53));
		this.addSlotToContainer(new SlotFurnace(inventory.player,tileentity ,2, 115,33));

		for(int i = 0;i < 3;i++){
			for(int j = 0;j < 9;j++){
				this.addSlotToContainer(new Slot(inventory,j+i*9+9,8+j*18,94+i*18));
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
				icrafting.sendProgressBarUpdate(this, 0, this.ricecooker.burnTime);
			}
			if(this.lastcurrentItemBurnTime != this.ricecooker.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.ricecooker.currentItemBurnTime);
			}
		}

		this.lastcookTime = this.ricecooker.cookTime;
		this.lastburnTime = this.ricecooker.burnTime;
		this.lastcurrentItemBurnTime = this.ricecooker.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){

	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
