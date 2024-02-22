package net.minecraft.server;

import java.util.Random;

public class BlockObsired extends Block {

    public BlockObsired() {
        super(Material.ORE);
        this.a(CreativeModeTab.b);
        c(64);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.OBSIRED);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return MaterialMapColor.K;
    }
}
