package org.bukkit.craftbukkit.entity;

import org.apache.commons.lang.Validate;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.ArrowSpeed;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

import net.minecraft.server.EntityArrowSpeed;

public class CraftArrowSpeed extends AbstractProjectile implements ArrowSpeed {

    public CraftArrowSpeed(CraftServer server, EntityArrowSpeed entity) {
        super(server, entity);
    }

    public void setKnockbackStrength(int knockbackStrength) {
        Validate.isTrue(knockbackStrength >= 0, "Knockback cannot be negative");
        getHandle().setKnockbackStrength(knockbackStrength);
    }

    public int getKnockbackStrength() {
        return getHandle().knockbackStrength;
    }

    public boolean isCritical() {
        return getHandle().isCritical();
    }

    public void setCritical(boolean critical) {
        getHandle().setCritical(critical);
    }

    public ProjectileSource getShooter() {
        return getHandle().projectileSource;   
    }

    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof LivingEntity) {
            getHandle().shooter = ((CraftLivingEntity) shooter).getHandle();
        } else {
            getHandle().shooter = null;
        }
        getHandle().projectileSource = shooter;
    }

    @Override
    public EntityArrowSpeed getHandle() {
        return (EntityArrowSpeed) entity;
    }

    @Override
    public String toString() {
        return "CraftArrowSpeed";
    }

    public EntityType getType() {
        return EntityType.ARROWSPEED;
    }

    @Deprecated
    public LivingEntity _INVALID_getShooter() {
        if (getHandle().shooter == null) {
            return null;
        }
        return (LivingEntity) getHandle().shooter.getBukkitEntity();
    }

    @Deprecated
    public void _INVALID_setShooter(LivingEntity shooter) {
        getHandle().shooter = ((CraftLivingEntity) shooter).getHandle();
    }

    // Spigot start
    private final ArrowSpeed.Spigot spigot = new ArrowSpeed.Spigot()
    {
        @Override
        public double getDamage()
        {
            return getHandle().j();
        }

        @Override
        public void setDamage(double damage)
        {
            getHandle().b( damage );
        }
    };

    public ArrowSpeed.Spigot spigot()
    {
        return spigot;
    }
    // Spigot end
}
