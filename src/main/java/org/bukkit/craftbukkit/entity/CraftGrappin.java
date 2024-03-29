package org.bukkit.craftbukkit.entity;

import net.minecraft.server.BlockPosition;
import net.minecraft.server.EntityFishingHook;
import net.minecraft.server.EntityGrappin;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.MathHelper;

import org.apache.commons.lang.Validate;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Grappin;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class CraftGrappin extends AbstractProjectile implements Grappin {
    private double biteChance = -1;

    public CraftGrappin(CraftServer server, EntityGrappin entity) {
        super(server, entity);
    }

    public ProjectileSource getShooter() {
        if (getHandle().owner != null) {
            return getHandle().owner.getBukkitEntity();
        }

        return null;
    }

    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof CraftHumanEntity) {
            getHandle().owner = (EntityHuman) ((CraftHumanEntity) shooter).entity;
        }
    }

    @Override
    public EntityGrappin getHandle() {
        return (EntityGrappin) entity;
    }

    @Override
    public String toString() {
        return "CraftGrappin";
    }

    public EntityType getType() {
        return EntityType.GRAPPIN;
    }

    public double getBiteChance() {
    	EntityGrappin hook = getHandle();

        if (this.biteChance == -1) {
            if (hook.world.isRainingAt(new BlockPosition(MathHelper.floor(hook.locX), MathHelper.floor(hook.locY) + 1, MathHelper.floor(hook.locZ)))) {
                return 1/300.0;
            }
            return 1/500.0;
        }
        return this.biteChance;
    }

    public void setBiteChance(double chance) {
        Validate.isTrue(chance >= 0 && chance <= 1, "The bite chance must be between 0 and 1.");
        this.biteChance = chance;
    }

    @Deprecated
    public LivingEntity _INVALID_getShooter() {
        return (LivingEntity) getShooter();
    }

    @Deprecated
    public void _INVALID_setShooter(LivingEntity shooter) {
        setShooter(shooter);
    }
}
