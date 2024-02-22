package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;

import net.minecraft.server.EntityRoadrunner;

public class CraftLlama extends CraftAnimals implements Llama {

    public CraftLlama(CraftServer server, EntityRoadrunner entity) {
        super(server, entity);
    }

    @Override
    public EntityRoadrunner getHandle() {
        return (EntityRoadrunner) entity;
    }

    @Override
    public String toString() {
        return "CraftLlama";
    }

    public EntityType getType() {
        return EntityType.LLAMA;
    }
}
