package common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IItemArmor extends ItemArmor
{
	private String iconTexturePath = "felimodserver:";

	public IItemArmor(ArmorMaterial armorMaterial,int par3,int par4,String type, List list, ItemStack itemstack)
	{
		super(armorMaterial,par3,par4);

		this.setMaxStackSize(1);
		this.setArmorTexture(type,par4);
	}

	private void setArmorTexture(String type,int armorPart)
	{
		switch(armorPart)
		{
		case 0:
			this.iconTexturePath += type + "_armor_helmet";
			break;

		case 1:
			this.iconTexturePath += type + "_armor_chestplate";
			break;

		case 2:
			this.iconTexturePath += type + "_armor_leggings";
			break;

		case 3:
			this.iconTexturePath += type + "_armor_boots";
			break;
		}
	}

	@Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHeld) {
        //if (EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId <= 0)) {
            itemStack.addEnchantment(Enchantment.unbreaking, 1);
        //}

    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(this.iconTexturePath);
	}

	public String getArmorTexture(ItemStack itemstack,Entity entity,int slot,String type)
	{
		return this.iconTexturePath;
	}
}
