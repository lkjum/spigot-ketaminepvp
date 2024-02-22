package org.bukkit;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.FurnaceAndDispenser;

/**
 * Represents a furnace.
 */
public class BicarFurnace extends FurnaceAndDispenser {

    public BicarFurnace() {
        super(Material.BICAR_FURNACE);
    }

    /**
     * Instantiate a furnace facing in a particular direction.
     *
     * @param direction the direction the furnace's "opening" is facing
     */
    public BicarFurnace(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated Magic value
     */
    @Deprecated
    public BicarFurnace(final int type) {
        super(type);
    }

    public BicarFurnace(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public BicarFurnace(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public BicarFurnace(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public BicarFurnace clone() {
        return (BicarFurnace) super.clone();
    }
}

