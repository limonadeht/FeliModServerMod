package common.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderCannon extends EntityThrowable
{
	public EntityEnderCannon(World p_i1782_1_)
    {
        super(p_i1782_1_);
    }

    public EntityEnderCannon(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

    @SideOnly(Side.CLIENT)
    public EntityEnderCannon(World world, double par2, double par4, double par6)
    {
        super(world, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition movingObjectPosition)
    {
    	this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        if (movingObjectPosition.entityHit != null)
        {
        	movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.worldObj.isRemote)
        {
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == this.worldObj)
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size
                    if (this.getThrower().isRiding())
                    {
                        this.getThrower().mountEntity((Entity)null);
                    }

                    this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                    this.getThrower().fallDistance = 0.0F;
                    //this.getThrower().attackEntityFrom(DamageSource.fall, event.attackDamage);
                    this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
                    }
                }
            }

            this.setDead();
        }
    }
}
