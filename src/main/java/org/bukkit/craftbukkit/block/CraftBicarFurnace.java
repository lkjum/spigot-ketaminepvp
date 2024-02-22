package org.bukkit.craftbukkit.block;

import net.minecraft.server.TileEntityBicarFurnace;
import net.minecraft.server.TileEntityFurnace;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BicarFurnace;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventoryBicarFurnace;
import org.bukkit.inventory.BicarFurnaceInventory;
import org.bukkit.inventory.FurnaceInventory;

public class CraftBicarFurnace extends CraftBlockState implements BicarFurnace {
    private final TileEntityBicarFurnace furnace;

    public CraftBicarFurnace(final Block block) {
        super(block);

        furnace = (TileEntityBicarFurnace) ((CraftWorld) block.getWorld()).getTileEntityAt(getX(), getY(), getZ());
    }

    public CraftBicarFurnace(final Material material, final TileEntityBicarFurnace te) {
        super(material);
        furnace = te;
    }

    public BicarFurnaceInventory getInventory() {
        return new CraftInventoryBicarFurnace(furnace);
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
    public TileEntityBicarFurnace getTileEntity() {
        return furnace;
    }
}
