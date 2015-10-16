package common;

import client.model.render.ItemTvRenderer;
import client.model.tileentity.TileEntityRiceCooker;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import event.BucketFillEvent;
import handler.BucketHandler;
import handler.GuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import recipe.Craftingrecipe;
import recipe.RiceCookerRecipes;
import recipe.neiNewRecipeRegister;
import server.ServerProxy;

/**
 *
 * @author Lemon1232
 * @author isuzu_shiranui
 * @author hayan0722
 *
 */

@Mod(modid = ILHsJapaneseFood.MOD_ID, version = ILHsJapaneseFood.VERSION)
public class ILHsJapaneseFood
{
	@Mod.Instance("ILH's JapaneseFood")
	public static ILHsJapaneseFood Instance;
	public static final String MOD_ID = "ILH's JapaneseFood";
	public static final String VERSION = "Beta-2.3";

	public static int blockRenderId;
	public static final int BlockFoodCraftTable = 1;

	@SidedProxy(clientSide = "client.ClientProxy", serverSide = "server.ServerProxy")
	public static ServerProxy serverproxy;



	//CreativeTabクラッシュ回避のため該当クラスを削除、メインクラスにてクリエイティブタブの生成を行うように
	//public static final CreativeTabs tabFeliModServerMod = new tabFeliModServerMod("FeliModServerMod");

	//Rice CookerのGuiId
	 public static final int RiceCookerGUI_ID = 1;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
	}

	@EventHandler
    public void Init(FMLInitializationEvent e)
    {
		//アイテム・ブロック系すべてをここでregisterする
		Register.REgister();

		MinecraftForge.EVENT_BUS.register(new BucketFillEvent());

		Craftingrecipe.registerFeliModServerModCraftingRecipes();
		RiceCookerRecipes.registerFeliModServerModRiceCookerRecipes();

		BucketHandler.INSTANCE.buckets.put(Register.FluidBlockLimone, Register.FelModiItemBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		serverproxy.registerRenderers();
		serverproxy.registerRenderThings();
		serverproxy.registerTileEntitySpecialRenderer();

		NetworkRegistry.INSTANCE.registerGuiHandler(ILHsJapaneseFood.Instance, new GuiHandler());

		GameRegistry.registerTileEntity(TileEntityRiceCooker.class, "BlockRiceCooker");

		(new neiNewRecipeRegister()).setRecipeList();

		/*NEIへの登録は、プロキシクラスを利用することでクライアントサイドのみで行う*/
		serverproxy.LoadNEI();


		//アイテムを3D描画する
		//わけわからないのでいったん見送り
		//MinecraftForgeClient.registerItemRenderer(FeliModServerModItems.itemFoodsample, (IItemRenderer)new ItemRenderBento());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Register.BlockTV), ItemTvRenderer.instance);
    }

	public static CreativeTabs tabFeliModServerMod
    = new CreativeTabs("ILH's JapaneseFood")
{
    public Item getTabIconItem()
    {
        return Register.itemYakinikudonburi;
    }
};
}
