package common.entity;

import common.Register;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityLychever extends EntityLiving
{
	public EntityLychever(World world) {
        super(world);
        	// うろうろ移動するAIの追加
/*		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));*/
		// 見回すAIの追加
		this.tasks.addTask(2, new EntityAILookIdle(this));
    }

    @Override
    public boolean isAIEnabled() { return true; }

    @Override
    public String getLivingSound() { return null; }

    @Override
    public String getHurtSound() { return null; }

    @Override
    public String getDeathSound() { return null; }

    /*
    * このMobが動いているときの音のファイルパスを返す.
    * 引数のblockはMobの下にあるBlock.
    */
    @Override
    protected void func_145780_a(int x, int y, int z, Block block)
    {
	this.playSound("mob.skeleton.step", 0.15F, 1.0F);
    }

   @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }

    @Override
    public Item getDropItem() { return Register.itemSaba; }
}
