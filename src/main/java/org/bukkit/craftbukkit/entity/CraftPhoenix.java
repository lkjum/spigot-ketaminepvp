package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phoenix;

import net.minecraft.server.EntityPhoenix;

public class CraftPhoenix extends CraftAnimals implements Phoenix {

    public CraftPhoenix(CraftServer server, EntityPhoenix entity) {
        super(server, entity);
    }

    @Override
    public EntityPhoenix getHandle() {
        return (EntityPhoenix) entity;
    }

    @Override
    public String toString() {
        return "CraftPhoenix";
    }

    public EntityType getType() {
        return EntityType.PHOENIX;
    }
}
