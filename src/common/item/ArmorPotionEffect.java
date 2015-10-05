package common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorPotionEffect extends ItemArmor
{
	public ArmorPotionEffect(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack)
	{
		//ヘルメット
		if(player.getCurrentArmor(3) != null)
		{
			ItemStack armor3 = player.getCurrentArmor(3);
			if(armor3.getItem() == FeliModServerModItems.itemFooderArmorHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id,0,0));
			}

			//他のヘルメットも設定したい場合はココに書く
		}

		//チェスト
		if(player.getCurrentArmor(2) != null)
		{
			ItemStack armor2 = player.getCurrentArmor(2);
			if(armor2.getItem() == FeliModServerModItems.itemFooderArmorChestPlate)
			{
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,0,0));
			}
		}

		//レギンス
		if(player.getCurrentArmor(1) != null)
		{
			ItemStack armor1 = player.getCurrentArmor(1);
			if(armor1.getItem() == FeliModServerModItems.itemFooderArmorLeggings)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,0,0));
			}
		}

		//ブーツ
		if(player.getCurrentArmor(0) != null)
		{
			ItemStack armor0 = player.getCurrentArmor(0);
			if(armor0.getItem() == FeliModServerModItems.itemFooderArmorBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id,0,1));
			}
		}
	}
}
