package org.bukkit.block;

import org.bukkit.inventory.BicarFurnaceInventory;

/**
 * Represents a furnace.
 */
@SuppressWarnings("deprecation")
public interface BicarFurnace extends BlockState, ContainerBlock {

    /**
     * Get burn time.
     *
     * @return Burn time
     */
    public short getBurnTime();

    /**
     * Set burn time.
     *
     * @param burnTime Burn time
     */
    public void setBurnTime(short burnTime);

    /**
     * Get cook time.
     *
     * @return Cook time
     */
    public short getCookTime();

    /**
     * Set cook time.
     *
     * @param cookTime Cook time
     */
    public void setCookTime(short cookTime);

    public BicarFurnaceInventory getInventory();
}
