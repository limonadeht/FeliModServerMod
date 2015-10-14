package client;

import org.lwjgl.input.Keyboard;

import client.model.render.RenderTv;
import client.model.tileentity.TileEntityBento;
import client.model.tileentity.TileEntityTv;
import common.entity.EntityStarCannonBullet;
import common.model.render.RenderBento;
import common.model.render.RenderStarCannon;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import server.ServerProxy;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		TileEntitySpecialRenderer render = new RenderBento();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBento.class, render);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}

	@Override
	public boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
	}

	@Override
	public void registerRenderers() {
		//エンティティとレンダーの紐付け
		RenderingRegistry.registerEntityRenderingHandler(EntityStarCannonBullet.class, new RenderStarCannon());

		//TV
		TileEntitySpecialRenderer render = new RenderTv();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTv.class, render);
	}

	/*NEIのロードの確認を行い、登録のメソッドを呼び出す*/
	@Override
	public void LoadNEI()
	{
		if (Loader.isModLoaded("NotEnoughItems"))
		{
			try
	        {
	    		LoadNEIConfig.load();
	        }
	        catch (Exception e)
	        {
	        	e.printStackTrace(System.err);
	        }
		}
	}
}
