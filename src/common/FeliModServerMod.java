package common;

import client.model.tileentity.TileEntityRiceCooker;
import common.block.FeliModServerModBlocks;
import common.entity.FeliModServerModMobs;
import common.fluid.FeliModServerModFluids;
import common.item.FeliModServerModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import handler.BucketHandler;
import handler.GuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	 public static final int RiceCookerGUI_ID = 1;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
	}

	@EventHandler
    public void Init(FMLInitializationEvent e)
    {
		FeliModServerModItems.registerFeliModServerItems();
		FeliModServerModBlocks.registerFeliModServerModBlocks();
		FeliModServerModMobs.registerFeliModServerModMobs();
		Craftingrecipe.registerFeliModServerModCraftingRecipes();
		RiceCookerRecipes.registerFeliModServerModRiceCookerRecipes();

		BucketHandler.INSTANCE.buckets.put(FeliModServerModFluids.FluidBlockLimone, FeliModServerModItems.FelModiItemBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		serverproxy.registerRenderers();
		serverproxy.registerRenderThings();
		serverproxy.registerTileEntitySpecialRenderer();

		NetworkRegistry.INSTANCE.registerGuiHandler(FeliModServerMod.Instance, new GuiHandler());

		GameRegistry.registerTileEntity(TileEntityRiceCooker.class, "BlockRiceCooker");

		(new neiNewRecipeRegister()).setRecipeList();

		/*NEIへの登録は、プロキシクラスを利用することでクライアントサイドのみで行います。*/

		serverproxy.LoadNEI();


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
