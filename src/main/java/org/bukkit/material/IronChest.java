package org.bukkit.material;


import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.DirectionalContainer;


/**
 * Represents a chest
 */
public class IronChest extends DirectionalContainer {

    public IronChest() {
        super(Material.IRON_CHEST);
    }

    /**
     * Instantiate a chest facing in a particular direction.
     *
     * @param direction the direction the chest's lit opens towards
     */
    public IronChest(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated Magic value
     */
    @Deprecated
    public IronChest(final int type) {
        super(type);
    }

    public IronChest(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public IronChest(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public IronChest(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public IronChest clone() {
        return (IronChest) super.clone();
    }
}
