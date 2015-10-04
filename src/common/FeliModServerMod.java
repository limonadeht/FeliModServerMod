package common;

import client.model.tileentity.TileEntityRiceCooker;
import common.block.FeliModServerModBlocks;
import common.food.FeliModServerModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import handler.GuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import recipe.Craftingrecipe;
import recipe.RiceCookerRecipes;
import server.ServerProxy;

/**
 *
 * @author Lemon1232
 * @author isuzu_shiranui
 * @author hayan0722
 *
 */

@Mod(modid = FeliModServerMod.MOD_ID, version = FeliModServerMod.VERSION)
public class FeliModServerMod
{
	@Mod.Instance("FeliModServer")
	public static FeliModServerMod Instance;
	public static final String MOD_ID = "FeliModServer";
	public static final String VERSION = "Beta-1.0";

	public static int blockRenderId;
	public static final int BlockFoodCraftTable = 1;

	@SidedProxy(clientSide = "client.ClientProxy", serverSide = "server.ServerProxy")
	public static ServerProxy serverproxy;



	//CreativeTabクラッシュ回避のため該当クラスを削除、メインクラスにてクリエイティブタブの生成を行うように
	//public static final CreativeTabs tabFeliModServerMod = new tabFeliModServerMod("FeliModServerMod");

	//Rice CookerのGuiId
	 public static final int GUI_ID = 1;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

	}

	@EventHandler
    public void Init(FMLInitializationEvent e)
    {
		FeliModServerModItems.registerFeliModServerItems();
		FeliModServerModBlocks.registerFeliModServerModBlocks();
		Craftingrecipe.registerFeliModServerModCraftingRecipes();
		RiceCookerRecipes.registerFeliModServerModRiceCookerRecipes();

		serverproxy.registerRenderThings();
		serverproxy.registerTileEntitySpecialRenderer();

		NetworkRegistry.INSTANCE.registerGuiHandler(FeliModServerMod.Instance, new GuiHandler());

		GameRegistry.registerTileEntity(TileEntityRiceCooker.class, "BlockRiceCooker");

		//NetworkRegistry.INSTANCE().registerGuiHandler(Instance, GuiHandler);

		//アイテムを3D描画する
		//わけわからないのでいったん見送ります。
		//MinecraftForgeClient.registerItemRenderer(FeliModServerModItems.itemFoodsample, (IItemRenderer)new ItemRenderBento());
    }

	public static CreativeTabs tabFeliModServerMod
    = new CreativeTabs("FeliModServer")
{
    public Item getTabIconItem()
    {
        return FeliModServerModItems.itemYakinikudonburi;
    }
};
}
