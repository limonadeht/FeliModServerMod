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

public class ContainerRiceCooker extends Container{

	private TileEntityRiceCooker ricecooker;

	public int lastburnTime;
	public int lastcurrentItemBurnTime;
	public int lastcookTime;

	static final int sourceSize = 1;
	static final int fuelSize = 1;
	static final int productSize = 1;
	static final int inventorySize = 27;
	static final int hotbarSize = 9;

	static final int sourceIndex = 0;
	static final int fuelIndex = sourceIndex + sourceSize;
	static final int productIndex = fuelIndex + fuelSize;
	static final int inventoryIndex = productIndex + productSize;
	static final int hotbarIndex = inventoryIndex + inventorySize;


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

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityplayer, int per2) {
		//クリックされたスロットを取得
		Slot slot = (Slot)this.inventorySlots.get(per2);
		if(slot == null) {
			return null;
		}

		if(slot.getHasStack() == false) {
			return null;
		}

		//クリックされたスロットのItemStackを取得
		ItemStack itemStack = slot.getStack();

		//書き換えるた後比較したいので変更前のItemStackの状態を保持しておく
		ItemStack itemStackOrg = slot.getStack().copy();

		//素材スロットがクリックされたらインベントリかホットバーの空いてるスロットに移動
		if(sourceIndex <= per2 && per2 <= sourceIndex + sourceSize) {
			if (!this.mergeItemStack(itemStack, inventoryIndex, inventoryIndex + inventorySize + hotbarSize, false)) {
				return null;
			}

			slot.onSlotChange(itemStack, itemStackOrg);
		}
		//燃料スロットがクリックされた
		else if(fuelIndex <= per2 && per2 < fuelIndex + fuelSize) {
			//素材アイテムか判定（※isSourceItemはこのサンプルでは実装されていないメソッドです）
			if(TileEntityRiceCooker.isItemSource(itemStack)) {
				//素材アイテムなので素材スロットへ移動
				if (!this.mergeItemStack(itemStack, sourceIndex, sourceIndex + sourceSize, false)) {
					return null;
				}

				slot.onSlotChange(itemStack, itemStackOrg);
			}
			else {
				//素材アイテムではないのでインベントリかホットバーの空いてるスロットに移動
				if (!this.mergeItemStack(itemStack, inventoryIndex, inventoryIndex + inventorySize + hotbarSize, false)) {
					return null;
				}

				slot.onSlotChange(itemStack, itemStackOrg);
			}
		}
		// 結果スロットがクリックされたらインベントリかホットバーの空いてるスロットに移動
		else if(productIndex <= per2 && per2 < productIndex + productSize) {
			if (!this.mergeItemStack(itemStack, inventoryIndex, inventoryIndex + inventorySize + hotbarSize, false)) {
				return null;
			}

			slot.onSlotChange(itemStack, itemStackOrg);
		}
		//インベントリがクリックされた
		else if(inventoryIndex <= per2 && per2 < inventoryIndex + inventorySize) {
			if(TileEntityRiceCooker.isItemSource(itemStack)) {
				//素材アイテムなので素材スロットへ移動
				if (!this.mergeItemStack(itemStack, sourceIndex, sourceIndex + sourceSize, false)) {
					return null;
				}
			}
			else if(TileEntityRiceCooker.isItemFuel(itemStack)) {
				//燃料アイテムなので燃料スロットへ移動
				if (!this.mergeItemStack(itemStack, fuelIndex, fuelIndex + fuelSize, false)) {
					return null;
				}
			}
			else {
				//どちらでもないのでホットバーに移動
				if (!this.mergeItemStack(itemStack, hotbarIndex, hotbarIndex + hotbarSize, false)) {
					return null;
				}
			}
		}
		//ホットバーがクリックされた
		else if(hotbarIndex <= per2 && per2 < hotbarIndex + hotbarSize) {
			if(TileEntityRiceCooker.isItemSource(itemStack)) {
				//素材アイテムなので素材スロットへ移動
				if (!this.mergeItemStack(itemStack, sourceIndex, sourceIndex + sourceSize, false)) {
					return null;
				}
			}
			else if(TileEntityRiceCooker.isItemFuel(itemStack)) {
				//燃料アイテムなので燃料スロットへ移動
				if (!this.mergeItemStack(itemStack, fuelIndex, fuelIndex + fuelSize, false)) {
					return null;
				}
			}
			else {
				//どちらでもないのでインベントリに移動
				if (!this.mergeItemStack(itemStack, inventoryIndex, inventoryIndex + inventorySize, false)) {
					return null;
				}
			}
		}

		//シフトクリックで移動先スロットが溢れなかった場合は移動元スロットを空にする
		if (itemStack.stackSize == 0) {
			slot.putStack((ItemStack)null);
		}
		//移動先スロットが溢れた場合は数だけ変わって元スロットにアイテムが残るので更新通知
		else {
			slot.onSlotChanged();
		}

		//シフトクリック前後で数が変わらなかった＝移動失敗
		if (itemStack.stackSize == itemStackOrg.stackSize) {
			return null;
		}

		slot.onPickupFromSlot(entityplayer, itemStack);

		return itemStackOrg;
	}
}
