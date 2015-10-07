package common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class EntityStarCannonnDamageSource extends DamageSource
{
	public EntityStarCannonnDamageSource(String par1Str)
	{
		super(par1Str);
	}

	public static DamageSource causeBulletDamage(EntityStarCannonBullet par0EntityBullet, Entity par1Entity)
	{
        	return (new EntityDamageSourceIndirect("bullet", par0EntityBullet, par1Entity)).setProjectile();
	}
}
