package common.food;

import java.util.List;

import cofh.api.energy.IEnergyContainerItem;
import common.ILHsJapaneseFood;
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

public class itemLimoneFood extends Item implements IEnergyContainerItem
{

	public final int itemUseDuration;
	private final int healAmount;
	private boolean alwaysEdible;
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;
	private final float saturationModifier;


	public itemLimoneFood(float par1, float par2, boolean par3)
	{
		this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		this.setMaxDamage(15);
		this.setUnlocalizedName("felimodserver:limone_food");
		this.saturationModifier = par2;
		this.itemUseDuration = 3;
		this.healAmount = 1;
		this.setNoRepair();
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
		if (ILHsJapaneseFood.serverproxy.isShiftKeyDown()) {
			list.add("This is Food using Energy");
	        list.add("Pleace Energy Charged.");
	        list.add(EnumChatFormatting.GOLD + "Hunger: " + healAmount);

	        String potionid = this.getPotionEffect(itemStack);
	        if(potionid == null)
	        {
	        	list.add(EnumChatFormatting.AQUA + "PotionEffect: none");
	        }else{
	        	list.add(EnumChatFormatting.AQUA + "PotionEffect: " + potionId + potionDuration);
	        }
	        list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
	        list.add(EnumChatFormatting.DARK_GRAY + "StoredEnergy: " + this.getEnergyStored(itemStack) + "/" + this.getMaxEnergyStored(itemStack));
		}else{
			list.add(EnumChatFormatting.ITALIC + "LShift: Expand tooltip.");
		}

    }

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		//damageItem()で耐久値を1減らしている
        itemstack.damageItem(1, entityplayer);
        this.getEnergyStored(itemstack);
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
        	   //if(itemstack.getItemDamage() >= this.getMaxDamage() - 1)
               entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
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

	public itemLimoneFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate)
	{
		return 80;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate)
	{
		return 80;
	}

	@Override
	public int getEnergyStored(ItemStack container)
	{
		return 100;
	}

	@Override
	public int getMaxEnergyStored(ItemStack container)
	{
		return 1000;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("felimodserver:limone_food");
	}

}
