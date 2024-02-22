package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * Represents a furnace.
 */
public class CokeBurner extends FurnaceAndDispenser {

    public CokeBurner() {
        super(Material.BICAR_FURNACE);
    }

    /**
     * Instantiate a furnace facing in a particular direction.
     *
     * @param direction the direction the furnace's "opening" is facing
     */
    public CokeBurner(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated Magic value
     */
    @Deprecated
    public CokeBurner(final int type) {
        super(type);
    }

    public CokeBurner(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public CokeBurner(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public CokeBurner(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public CokeBurner clone() {
        return (CokeBurner) super.clone();
    }
}

