package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityCrackos;
import net.minecraft.server.EntityZombie;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Crackos;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class CraftCrackos extends CraftMonster implements Crackos {

    public CraftCrackos(CraftServer server, EntityCrackos entity) {
        super(server, entity);
    }

    @Override
    public EntityCrackos getHandle() {
        return (EntityCrackos) entity;
    }

    @Override
    public String toString() {
        return "CraftCrackos";
    }

    public EntityType getType() {
        return EntityType.CRACKOS;
    }

    public boolean isBaby() {
        return getHandle().isBaby();
    }

    public void setBaby(boolean flag) {
        getHandle().setBaby(flag);
    }

    public boolean isVillager() {
        return getHandle().isVillager();
    }

    public void setVillager(boolean flag) {
        getHandle().setVillager(flag);
    }
}
