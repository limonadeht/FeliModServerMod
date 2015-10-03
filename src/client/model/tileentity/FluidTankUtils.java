package client.model.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class FluidTankUtils extends FluidTank
{
	public FluidTankUtils(int capacity) {
		super(capacity);
	}

	public FluidTankUtils(FluidStack stack, int capacity) {
		super(stack, capacity);
	}

	public FluidTankUtils(Fluid fluid, int amount, int capacity) {
		super(fluid, amount, capacity);
	}

	//判定処理の短縮用のemptyフラグ
	public boolean isEmpty() {
	    return (getFluid() == null) || getFluid().getFluid() == null || (getFluid().amount <= 0);
	}

	//判定処理の短縮用の満タンフラグ
	public boolean isFull() {
	    return (getFluid() != null) && (getFluid().amount == getCapacity());
	}

	//Fluid型で中身を得る
	public Fluid getFluidType() {
	    return getFluid() != null ? getFluid().getFluid() : null;
	}

	//翻訳された液体名を得るメソッド
	public String getFluidName()
	{
	    return (this.fluid != null) && (this.fluid.getFluid() != null) ? this.fluid.getFluid().getLocalizedName(this.fluid): "Empty";
	}

	//同期処理用
	@SideOnly(Side.CLIENT)
	public void setAmount(int par1)
	{
		if (this.fluid != null && this.fluid.getFluid() != null)
		{
			this.fluid.amount = par1;
		}
	}
}
