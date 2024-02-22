package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityMinecartChest;
import net.minecraft.server.EntityMinecartKetaChest;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class CraftMinecartKetaChest extends CraftMinecart implements StorageMinecart {
    private final CraftInventory inventory;

    public CraftMinecartKetaChest(CraftServer server, EntityMinecartKetaChest entity) {
        super(server, entity);
        inventory = new CraftInventory(entity);
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "CraftMinecartKetaChest{" + "inventory=" + inventory + '}';
    }

    public EntityType getType() {
        return EntityType.MINECART_KETA_CHEST;
    }
}
