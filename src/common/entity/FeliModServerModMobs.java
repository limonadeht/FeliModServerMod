package common.entity;

import common.FeliModServerMod;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class FeliModServerModMobs
{
	public static void registerFeliModServerModMobs()
	{
		EntityRegistry.registerModEntity(EntityLychever.class, "Lychever", 0, FeliModServerMod.MOD_ID, 250, 1, false);
        EntityRegistry.addSpawn(EntityLychever.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);

        EntityRegistry.registerGlobalEntityID(EntityStarCannonBullet.class, "StarCannon.bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.instance().registerModEntity(EntityStarCannonBullet.class, "StarCannon.bullet", 1, FeliModServerMod.MOD_ID, 128, 1, true);

        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
        }
	}
}
