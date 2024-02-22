package net.minecraft.server;

public class ItemAnvilOP extends ItemMultiTexture {

    public ItemAnvilOP(Block block) {
        super(block, block, new String[] { "intact", "slightlyDamaged", "veryDamaged"});
    }

    public int filterData(int i) {
        return i << 2;
    }
}