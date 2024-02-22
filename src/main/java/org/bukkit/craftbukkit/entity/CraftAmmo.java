package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityAmmo;
import net.minecraft.server.EntityArrow;

import org.apache.commons.lang.Validate;
import org.bukkit.Ammo;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class CraftAmmo extends AbstractProjectile implements Ammo {

    public CraftAmmo(CraftServer server, EntityAmmo entity) {
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
    public EntityAmmo getHandle() {
        return (EntityAmmo) entity;
    }

    @Override
    public String toString() {
        return "CraftAmmo";
    }

    public EntityType getType() {
        return EntityType.AMMO;
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
    private final Ammo.Spigot spigot = new Ammo.Spigot()
    {
        public double getDamage()
        {
            return getHandle().j();
        }

        public void setDamage(double damage)
        {
            getHandle().b( damage );
        }
    };

    public Ammo.Spigot spigot()
    {
        return spigot;
    }
    // Spigot end
}
