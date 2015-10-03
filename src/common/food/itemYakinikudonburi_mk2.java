package common.food;

import java.util.List;

import common.FeliModServerMod;
import common.block.FeliModServerModBlocks;
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

public class itemYakinikudonburi_mk2 extends Item
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

	private ItemStack emptyItem = null;

	public itemYakinikudonburi_mk2(float par1, float par2, boolean par3)
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setUnlocalizedName("Yakinikudonburi");
		this.itemUseDuration = 3;
		this.healAmount = 1;
		this.HealthAmount = 2; //HPの回復する量 1 = 0.5heart
		this.saturationModifier = par2;
		this.maxStackSize = 1;
		this.setMaxDamage(8);
		this.setNoRepair();
		this.setTextureName("felimodserver:Yakinikudonburi");
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
        list.add("焼肉丼");
        list.add(EnumChatFormatting.DARK_GREEN + "Compressed: 8");
        list.add(EnumChatFormatting.GOLD + "Hunger: " + healAmount);
        list.add(EnumChatFormatting.DARK_AQUA + "mogumogu: " + itemUseDuration);
        list.add(EnumChatFormatting.DARK_RED + "Heal: " + HealthAmount);

        String potionid = this.getPotionEffect(itemStack);
        if(potionid == null)
        {
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: none");
        }else{
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: " + potionId + potionDuration);
        }
        list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
    }

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		if(par7 != 1){
			return false;
		}else{
			if(player.canPlayerEdit(x, y + 1, z, par7, stack) && player.canPlayerEdit(x, y + 2, z, par7, stack)){
				world.setBlock(x, y + 1, z, FeliModServerModBlocks.BlockBento);
				world.notifyBlockOfNeighborChange(x, y + 1, z, FeliModServerModBlocks.BlockBento);
				--stack.stackSize;
				return true;
			}else{
				return false;
			}
		}
	}

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {

		if (entityplayer.capabilities.isCreativeMode) {
			itemstack.damageItem(1, entityplayer);
	        entityplayer.getFoodStats().addStats(healAmount, potionEffectProbability);
	        world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(itemstack, world, entityplayer);
	        return itemstack;
		}

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
        return 40;
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

	public itemYakinikudonburi_mk2 setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("felimodserver:Yakinikudonburi");
	}

}
