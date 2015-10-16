package common.item;

import java.util.List;

import common.ILHsJapaneseFood;
import common.entity.EntityStarCannonBullet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemStarCannon extends Item
{
	private int maxdamage;
	private float range;
	private double attack;
	private int wait_attack;
	private int wait_reload;
	private String gunsound;
	private Boolean knockback;
	private Boolean fire;

	public ItemStarCannon(int par1, float par2, double par3, int par4, int par5, String par6, Boolean par7, Boolean par8)
	{
		this.maxdamage = par1;
    	this.range = par2;
    	this.attack = par3;
    	this.wait_attack = par4;
    	this.wait_reload = par5;
    	this.gunsound = par6;
    	this.knockback = par7;
    	this.fire = par8;

        this.maxStackSize = 1;
        this.setMaxDamage(this.maxdamage);
        this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
		list.add(EnumChatFormatting.BOLD + "" +EnumChatFormatting.DARK_RED + "Please do not touch on this item!");
		list.add(EnumChatFormatting.BOLD + "" +EnumChatFormatting.DARK_RED + "There is a serious bug. It is possible that world to collapse!");
	}

	//右クリック
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	//耐久値が0（ダメージ値max）なら弾の有無判定へ
    	if (par1ItemStack.getItemDamage() == this.maxdamage)
    	{
    		//弾があれば消費して耐久値回復
    		if (par3EntityPlayer.inventory.hasItem(Items.nether_star))
    		{
    			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
    			par2World.playSoundAtEntity(par3EntityPlayer, "tile.piston.in", 0.5F, 0.5F); //装填音
    			par3EntityPlayer.inventory.consumeInventoryItem(Items.nether_star); //弾消費
    			par1ItemStack.damageItem(this.maxdamage * -1, par3EntityPlayer); //耐久値回復
    			par3EntityPlayer.attackTime = this.wait_reload;

    		}
    	}else{
    		if (par3EntityPlayer.attackTime == 0) //連射防止
			{
    			EntityStarCannonBullet entitybullet = new EntityStarCannonBullet(par2World, par3EntityPlayer, this.range * 2.0F);

    			//クリティカル
    			int ran = (int)(Math.random() * 10);
    			if (ran < 2)
    			{
            		entitybullet.setIsCritical(true);
    			}

    			//攻撃力
    			entitybullet.setDamage(entitybullet.getDamage() + this.attack);

    			//ノックバック
    			if (this.knockback == true)
    			{
    				entitybullet.setKnockbackStrength(1);
    			}

    			//炎上
    			if (this.fire == true)
    			{
    				entitybullet.setFire(100);
    			}

    			par1ItemStack.damageItem(1, par3EntityPlayer); //耐久値消費
    			par2World.playSoundAtEntity(par3EntityPlayer, ILHsJapaneseFood.MOD_ID  + ":" + this.gunsound, 0.7F, 0.7F); //発射音

    			if (!par2World.isRemote)
    			{
    				par2World.spawnEntityInWorld(entitybullet); //エンティティ呼びだし
    			}

    			par3EntityPlayer.attackTime = this.wait_attack;
        	}
    	}

    	return par1ItemStack;
    }

  //右クリック時の動作
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	if (par1ItemStack.getItemDamage() == this.maxdamage)
    	{
    		return EnumAction.block;

    	}else{
    		return EnumAction.bow;

    	}
    }

    //エンチャント不可
    public boolean isItemTool(ItemStack par1ItemStack)
    {
       return false;
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    public boolean isFull3D()
    {
        return true;
    }
}
