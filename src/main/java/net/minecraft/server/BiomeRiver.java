package net.minecraft.server;

public class BiomeRiver extends BiomeBase {

    public BiomeRiver(int i) {
        super(i);
        this.au.clear();
        this.at.add(new BiomeBase.BiomeMeta(EntityBear.class, 50, 4, 4));
    }
}
