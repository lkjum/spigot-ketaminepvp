package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;

import net.minecraft.server.EntityParrot;

public class CraftParrot extends CraftAnimals implements Parrot {

    public CraftParrot(CraftServer server, EntityParrot entity) {
        super(server, entity);
    }

    @Override
    public EntityParrot getHandle() {
        return (EntityParrot) entity;
    }

    @Override
    public String toString() {
        return "CraftParrot";
    }

    public EntityType getType() {
        return EntityType.PARROT;
    }
}
