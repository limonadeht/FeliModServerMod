package client;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import server.RiceCookerContainer;

public class GuiRiceCooker extends GuiContainer
{
	 private static final ResourceLocation TEXTURE = new ResourceLocation("<DomainName>", "textures/gui/gui_texture.png");
	    public GuiRiceCooker(int x, int y, int z) {
	        super(new RiceCookerContainer(x, y, z));
	    }

	    /*GUIの文字等の描画処理*/
	    @Override
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseZ) {
	        super.drawGuiContainerForegroundLayer(mouseX, mouseZ);
	    }

	    /*GUIの背景の描画処理*/
	    @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseZ) {
	        this.mc.renderEngine.bindTexture(TEXTURE);
	        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
	    }

	    /*GUIが開いている時にゲームの処理を止めるかどうか。*/
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
}
