package client;

import client.gui.GuiRiceCooker;
import codechicken.nei.api.API;
import handler.CatchRecipeHandler;

public class LoadNEIConfig {

	/*別クラスで作るレシピ表示用インターフェースの取得*/
	public static CatchRecipeHandler catchRecipe;

	public static void load()
	{
		catchRecipe = new CatchRecipeHandler();

		API.registerRecipeHandler(catchRecipe);
		API.registerUsageHandler(catchRecipe);
		API.registerGuiOverlay(GuiRiceCooker.class, catchRecipe.getOverlayIdentifier(), 0, 0);
	}

}
