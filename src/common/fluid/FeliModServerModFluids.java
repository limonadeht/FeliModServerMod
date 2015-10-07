package common.fluid;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FeliModServerModFluids
{
	public static Fluid fluidLimone;
	public static Block FluidBlockLimone;

	public static void registerFeliModServerModFluids()
	{
		fluidLimone = new Fluid("Limone");
		FluidRegistry.registerFluid(fluidLimone);

		FluidBlockLimone = new FluidBlockLimone(fluidLimone, Material.water).setBlockName("Limone");
		GameRegistry.registerBlock(FluidBlockLimone, FeliModServerMod.MOD_ID + "_" + FluidBlockLimone.getUnlocalizedName().substring(5));
		fluidLimone.setUnlocalizedName(FluidBlockLimone.getUnlocalizedName());
	}
}
