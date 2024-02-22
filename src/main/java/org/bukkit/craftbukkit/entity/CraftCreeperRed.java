package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityCreeper;
import net.minecraft.server.EntityCreeperRed;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.CreeperRed;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.CreeperRedPowerEvent;

public class CraftCreeperRed extends CraftMonster implements CreeperRed {

    public CraftCreeperRed(CraftServer server, EntityCreeperRed entity) {
        super(server, entity);
    }

    public boolean isPowered() {
        return getHandle().isPowered();
    }

    public void setPowered(boolean powered) {
        CraftServer server = this.server;
        CreeperRed entity = (CreeperRed) this.getHandle().getBukkitEntity();

        if (powered) {
        	CreeperRedPowerEvent event = new CreeperRedPowerEvent((CreeperRed) entity, CreeperRedPowerEvent.PowerCause.SET_ON);
            server.getPluginManager().callEvent(event);

            if (!event.isCancelled()) {
                getHandle().setPowered(true);
            }
        } else {
        	CreeperRedPowerEvent event = new CreeperRedPowerEvent((CreeperRed) entity, CreeperRedPowerEvent.PowerCause.SET_OFF);
            server.getPluginManager().callEvent(event);

            if (!event.isCancelled()) {
                getHandle().setPowered(false);
            }
        }
    }

    @Override
    public EntityCreeperRed getHandle() {
        return (EntityCreeperRed) entity;
    }

    @Override
    public String toString() {
        return "CraftCreeperRed";
    }

    public EntityType getType() {
        return EntityType.CREEPERRED;
    }
}
