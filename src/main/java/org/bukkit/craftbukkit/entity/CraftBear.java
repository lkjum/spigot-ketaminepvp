package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Bear;
import org.bukkit.entity.EntityType;

import net.minecraft.server.EntityBear;

public class CraftBear extends CraftMonster implements Bear {

    public CraftBear(CraftServer server, EntityBear entity) {
        super(server, entity);
    }

    @Override
    public EntityBear getHandle() {
        return (EntityBear) entity;
    }

    @Override
    public String toString() {
        return "CraftBear";
    }

    public EntityType getType() {
        return EntityType.BEAR;
    }

}
