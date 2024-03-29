package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.AnvilOPInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.IInventory;

public class CraftInventoryAnvilOP extends CraftInventory implements AnvilOPInventory {
    private final IInventory resultInventory;

    public CraftInventoryAnvilOP(IInventory inventory, IInventory resultInventory) {
        super(inventory);
        this.resultInventory = resultInventory;
    }

    public IInventory getResultInventory() {
        return resultInventory;
    }

    public IInventory getIngredientsInventory() {
        return inventory;
    }

    @Override
    public ItemStack getItem(int slot) {
        if (slot < getIngredientsInventory().getSize()) {
            net.minecraft.server.ItemStack item = getIngredientsInventory().getItem(slot);
            return item == null ? null : CraftItemStack.asCraftMirror(item);
        } else {
            net.minecraft.server.ItemStack item = getResultInventory().getItem(slot - getIngredientsInventory().getSize());
            return item == null ? null : CraftItemStack.asCraftMirror(item);
        }
    }

    @Override
    public void setItem(int index, ItemStack item) {
        if (index < getIngredientsInventory().getSize()) {
            getIngredientsInventory().setItem(index, (item == null ? null : CraftItemStack.asNMSCopy(item)));
        } else {
            getResultInventory().setItem((index - getIngredientsInventory().getSize()), (item == null ? null : CraftItemStack.asNMSCopy(item)));
        }
    }

    @Override
    public int getSize() {
        return getResultInventory().getSize() + getIngredientsInventory().getSize();
    }
}
