package common.food;

import java.util.List;

import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class itemSabakanFood extends Item
{

	public final int itemUseDuration;
	private final int healAmount;
	private boolean alwaysEdible;
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;
	private final float saturationModifier;

	private int HealthAmount;


	public itemSabakanFood(float par1, float par2, boolean par3)
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setMaxDamage(3);
		this.setUnlocalizedName("felimodserver:limone_food");
		this.saturationModifier = par2;
		this.itemUseDuration = 3;
		this.healAmount = 30;
		this.HealthAmount = 1;
		this.setNoRepair();
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
        list.add("鯖管だけに、鯖缶 なんちって! :D");
        list.add(EnumChatFormatting.GOLD + "HealAmount: " + healAmount);
        list.add(EnumChatFormatting.DARK_AQUA + "mogumogu: " + itemUseDuration);

        String potionid = this.getPotionEffect(itemStack);
        if(potionid == null)
        {
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: none");
        }else{
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: " + potionId + potionDuration);
        }
        list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
        }

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		//damageItem()で耐久値を1減らしている
        itemstack.damageItem(1, entityplayer);
        entityplayer.getFoodStats().addStats(healAmount, potionEffectProbability);
        world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(itemstack, world, entityplayer);
        return itemstack;
    }

	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability)
        {
            entityplayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }

	//食べる速さ。デフォルト32
	public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 3;
    }

	public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.eat;
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
           if (entityplayer.canEat(this.alwaysEdible))
           {
        	   int healthamount = HealthAmount;
        	   HealthAmount = healthamount;
        	   //if(itemstack.getItemDamage() >= this.getMaxDamage() - 1)
               entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
               entityplayer.heal(healthamount);
               if(entityplayer.capabilities.isCreativeMode)
               {
            	   entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
               }
           }
        return itemstack;
    }

	public int func_150905_g(ItemStack itemstack)
    {
        return this.healAmount;
    }

	public float func_150906_h(ItemStack itemstack)
    {
        return this.saturationModifier;
    }

	public itemSabakanFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("felimodserver:limone_food");
	}
}
