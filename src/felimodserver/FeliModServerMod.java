package felimodserver;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import felimodserver.block.FeliModServerModBlocks;
import felimodserver.food.FeliModServerModItems;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = FeliModServerMod.MOD_ID, version = FeliModServerMod.VERSION)
public class FeliModServerMod
{
	@Mod.Instance("FeliModServer")
	public static FeliModServerMod Instance;
	public static final String MOD_ID = "FeliModServer";
	public static final String VERSION = "Beta-1.0";

	public static int blockRenderId;

	@SidedProxy(clientSide = "felimodserver.ClientProxy", serverSide = "felimodserver.ServerProxy")
	public static ServerProxy serverproxy;


	public static final CreativeTabs tabFeliModServerMod = new tabFeliModServerMod("FeliModServerMod");


	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

	}

	@EventHandler
    public void Init(FMLInitializationEvent e)
    {
		FeliModServerModItems.registerFeliModServerItems();
		FeliModServerModBlocks.registerFeliModServerModBlocks();

		serverproxy.registerRenderThings();
		serverproxy.registerTileEntitySpecialRenderer();

		//アイテムを3D描画する
		//わけわからないのでいったん見送ります。
		//MinecraftForgeClient.registerItemRenderer(FeliModServerModItems.itemFoodsample, (IItemRenderer)new ItemRenderBento());
    }
}
