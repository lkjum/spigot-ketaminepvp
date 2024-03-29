package org.bukkit.craftbukkit.inventory;


import net.minecraft.server.ITileInventory;
import net.minecraft.server.InventoryIronChest;

import org.bukkit.block.IronChest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.IronChestInventory;
import org.bukkit.inventory.ItemStack;


public class CraftInventoryIronChest extends CraftInventory implements IronChestInventory {
    private final CraftInventory left;
    private final CraftInventory right;

    public CraftInventoryIronChest(CraftInventory left, CraftInventory right) {
        super(new InventoryIronChest("Large chest", (ITileInventory) left.getInventory(), (ITileInventory) right.getInventory()));
        this.left = left;
        this.right = right;
    }

    public CraftInventoryIronChest(InventoryIronChest largeChest) {
        super(largeChest);
        if (largeChest.left instanceof InventoryIronChest) {
            left = new CraftInventoryIronChest((InventoryIronChest) largeChest.left);
        } else {
            left = new CraftInventory(largeChest.left);
        }
        if (largeChest.right instanceof InventoryIronChest) {
            right = new CraftInventoryIronChest((InventoryIronChest) largeChest.right);
        } else {
            right = new CraftInventory(largeChest.right);
        }
    }

    public Inventory getLeftSide() {
        return left;
    }

    public Inventory getRightSide() {
        return right;
    }

    @Override
    public void setContents(ItemStack[] items) {
        if (getInventory().getContents().length < items.length) {
            throw new IllegalArgumentException("Invalid inventory size; expected " + getInventory().getContents().length + " or less");
        }
        ItemStack[] leftItems = new ItemStack[left.getSize()], rightItems = new ItemStack[right.getSize()];
        System.arraycopy(items, 0, leftItems, 0, Math.min(left.getSize(),items.length));
        left.setContents(leftItems);
        if (items.length >= left.getSize()) {
            System.arraycopy(items, left.getSize(), rightItems, 0, Math.min(right.getSize(), items.length - left.getSize()));
            right.setContents(rightItems);
        }
    }

    @Override
    public IronChest getHolder() {
        return (IronChest) new IronChest(this);
    }
}
