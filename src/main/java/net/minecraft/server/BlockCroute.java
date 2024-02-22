package net.minecraft.server;

import java.util.Random;

public class BlockCroute extends Block {

    public BlockCroute() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
        this.durability = 2000.0F;
        c(64);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.CROUTE_TERRESTRE);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return MaterialMapColor.E;
    }
}
