package org.bukkit.craftbukkit.block;

import net.minecraft.server.TileEntityCokeBurner;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CokeBurner;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventoryCokeBurner;
import org.bukkit.inventory.CokeBurnerInventory;

public class CraftCokeBurner extends CraftBlockState implements CokeBurner {
    private final TileEntityCokeBurner furnace;

    public CraftCokeBurner(final Block block) {
        super(block);

        furnace = (TileEntityCokeBurner) ((CraftWorld) block.getWorld()).getTileEntityAt(getX(), getY(), getZ());
    }

    public CraftCokeBurner(final Material material, final TileEntityCokeBurner te) {
        super(material);
        furnace = te;
    }

    public CokeBurnerInventory getInventory() {
        return new CraftInventoryCokeBurner(furnace);
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        boolean result = super.update(force, applyPhysics);

        if (result) {
            furnace.update();
        }

        return result;
    }

    public short getBurnTime() {
        return (short) furnace.burnTime;
    }

    public void setBurnTime(short burnTime) {
        furnace.burnTime = burnTime;
    }

    public short getCookTime() {
        return (short) furnace.cookTime;
    }

    public void setCookTime(short cookTime) {
        furnace.cookTime = cookTime;
    }

    @Override
    public TileEntityCokeBurner getTileEntity() {
        return furnace;
    }
}
