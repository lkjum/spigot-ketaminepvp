package net.minecraft.server;

import java.util.Random;

public class BlockBedrock extends Block
{

    public BlockBedrock(Material m) 
    {
        super(m);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i)
    {
        return null;
    }
}
