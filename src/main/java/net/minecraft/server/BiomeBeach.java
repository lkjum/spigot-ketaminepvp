package net.minecraft.server;

public class BiomeBeach extends BiomeBase {

    public BiomeBeach(int i) {
        super(i);
        this.au.clear();
        this.ak = Blocks.SAND.getBlockData();
        this.al = Blocks.SAND.getBlockData();
        this.as.A = -999;
        this.as.D = 0;
        this.as.F = 0;
        this.as.G = 0;
        this.au.add(new BiomeBase.BiomeMeta(EntityParrot.class, 8, 4, 4));
    }
}
