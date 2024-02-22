package org.bukkit.craftbukkit.inventory;

import org.bukkit.block.BicarFurnace;
import org.bukkit.inventory.BicarFurnaceInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.TileEntityBicarFurnace;

public class CraftInventoryBicarFurnace extends CraftInventory implements BicarFurnaceInventory {
    public CraftInventoryBicarFurnace(TileEntityBicarFurnace inventory) {
        super(inventory);
    }

    public ItemStack getResult() {
        return getItem(2);
    }

    public ItemStack getFuel() {
        return getItem(1);
    }

    public ItemStack getSmelting() {
        return getItem(0);
    }

    public void setFuel(ItemStack stack) {
        setItem(1,stack);
    }

    public void setResult(ItemStack stack) {
        setItem(2,stack);
    }

    public void setSmelting(ItemStack stack) {
        setItem(0,stack);
    }

    @Override
    public BicarFurnace getHolder() {
        return (BicarFurnace) inventory.getOwner();
    }
}
