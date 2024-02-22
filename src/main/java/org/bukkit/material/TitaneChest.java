package org.bukkit.material;


import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.DirectionalContainer;


/**
 * Represents a chest
 */
public class TitaneChest extends DirectionalContainer {

    public TitaneChest() {
        super(Material.TITANE_CHEST);
    }

    /**
     * Instantiate a chest facing in a particular direction.
     *
     * @param direction the direction the chest's lit opens towards
     */
    public TitaneChest(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated Magic value
     */
    @Deprecated
    public TitaneChest(final int type) {
        super(type);
    }

    public TitaneChest(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public TitaneChest(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public TitaneChest(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public TitaneChest clone() {
        return (TitaneChest) super.clone();
    }
}
