package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.AquaTNTPrimed;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import net.minecraft.server.EntityAquaTNTPrimed;
import net.minecraft.server.EntityLiving;

public class CraftAquaTNTPrimed extends CraftEntity implements AquaTNTPrimed {

    public CraftAquaTNTPrimed(CraftServer server, EntityAquaTNTPrimed entity) {
        super(server, entity);
    }

    public float getYield() {
        return getHandle().yield;
    }

    public boolean isIncendiary() {
        return getHandle().isIncendiary;
    }

    public void setIsIncendiary(boolean isIncendiary) {
        getHandle().isIncendiary = isIncendiary;
    }

    public void setYield(float yield) {
        getHandle().yield = yield;
    }

    public int getFuseTicks() {
        return getHandle().fuseTicks;
    }

    public void setFuseTicks(int fuseTicks) {
        getHandle().fuseTicks = fuseTicks;
    }

    @Override
    public EntityAquaTNTPrimed getHandle() {
        return (EntityAquaTNTPrimed) entity;
    }

    @Override
    public String toString() {
        return "CraftTNTAquaPrimed";
    }

    public EntityType getType() {
        return EntityType.AQUAPRIMED_TNT;
    }

    public Entity getSource() {
        EntityLiving source = getHandle().getSource();

        if (source != null) {
            Entity bukkitEntity = source.getBukkitEntity();

            if (bukkitEntity.isValid()) {
                return bukkitEntity;
            }
        }

        return null;
    }
}
