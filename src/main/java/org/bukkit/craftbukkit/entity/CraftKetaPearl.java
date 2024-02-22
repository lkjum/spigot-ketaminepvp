package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.KetaPearl;

import net.minecraft.server.EntityKetaPearl;

public class CraftKetaPearl extends CraftProjectile implements KetaPearl 
{
    public CraftKetaPearl(CraftServer server, EntityKetaPearl entity) 
    {
        super(server, entity);
    }

    @Override
    public EntityKetaPearl getHandle() {
        return (EntityKetaPearl) entity;
    }

    @Override
    public String toString() {
        return "CraftKetaPearl";
    }

    public EntityType getType() {
        return EntityType.KETA_PEARL;
    }
}
