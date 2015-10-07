package client.gui;

import org.lwjgl.opengl.GL11;

import client.model.tileentity.TileEntityRiceCooker;
import common.block.container.ContainerRiceCooker;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiRiceCooker extends GuiContainer{

	public static final ResourceLocation bground = new ResourceLocation("felimodserver", "textures/gui/ricefurnace.png");

	public TileEntityRiceCooker tileentity;

	public GuiRiceCooker(InventoryPlayer inventoryplayer, TileEntityRiceCooker entity){
		super(new ContainerRiceCooker(inventoryplayer, entity));

		this.tileentity=entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerBackgroundLayer(int per1,int per2){

		 	String s = this.tileentity.hasCustomInventoryName() ? this.tileentity.getInventoryName() : I18n.format(this.tileentity.getInventoryName(), new Object[0]);
	        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRendererObj.drawString(I18n.format("inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float per1, int per2, int per3) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(bground);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        if (this.tileentity.isBurning())
        {
            int i1 = this.tileentity.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(x + 17, y + 37 + 12 - i1, 176, 12 - i1, 14, i1 + 1);

            i1 = this.tileentity.getCookProgressScaled(24);
            this.drawTexturedModalRect(x + 79, y + 34, 176, 14, i1 + 1, 16);
        }
	}

	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}
