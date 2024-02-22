package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.CreeperAqua;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreeperAquaPowerEvent;

import net.minecraft.server.EntityCreeperAqua;

public class CraftCreeperAqua extends CraftMonster implements CreeperAqua {

    public CraftCreeperAqua(CraftServer server, EntityCreeperAqua entity) {
        super(server, entity);
    }

    public boolean isPowered() {
        return getHandle().isPowered();
    }

    public void setPowered(boolean powered) {
        CraftServer server = this.server;
        CreeperAqua entity = (CreeperAqua) this.getHandle().getBukkitEntity();

        if (powered) {
        	CreeperAquaPowerEvent event = new CreeperAquaPowerEvent((CreeperAqua) entity, CreeperAquaPowerEvent.PowerCause.SET_ON);
            server.getPluginManager().callEvent(event);

            if (!event.isCancelled()) {
                getHandle().setPowered(true);
            }
        } else {
        	CreeperAquaPowerEvent event = new CreeperAquaPowerEvent((CreeperAqua) entity, CreeperAquaPowerEvent.PowerCause.SET_OFF);
            server.getPluginManager().callEvent(event);

            if (!event.isCancelled()) {
                getHandle().setPowered(false);
            }
        }
    }

    @Override
    public EntityCreeperAqua getHandle() {
        return (EntityCreeperAqua) entity;
    }

    @Override
    public String toString() {
        return "CraftCreeperAqua";
    }

    public EntityType getType() {
        return EntityType.CREEPERAQUA;
    }
}
