package client.gui;

import client.model.tileentity.TileEntityRiceCooker;
import common.FeliModServerMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiRiceCooker extends GuiContainer{

	public static final ResourceLocation bground = new ResourceLocation(FeliModServerMod.MOD_ID,"/FeliModServerMod/resource/assets/felimodserver/textures/gui/ricefurnace.png");

	public TileEntityRiceCooker ricecooker;

	public GuiRiceCooker(InventoryPlayer inventoryplayer, TileEntityRiceCooker entity){
		super(ContainerRiceCooker(inventoryplayer,entity));

		this.ricecooker=entity;

		this.xSize=256;
		this.ySize=256;
	}

	public void drawGuiContainerBackgroundLayer(int per1,int per2){
		String name = this.ricecooker.hasCustomInventoryName() ? this.ricecooker.getInventoryName() : I18n.format(this.ricecooker.getInventoryName(), new Object[0]);

		this.fontRendererObj.drawString(name, this.xSize/2-this.fontRendererObj.getStringWidth(name)/2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize-96+2, 4210752);
	}

	@override
	protected void drawGuiContainerBackgroundLayer(float ver1, int ver2, int ver3){

	}

}
