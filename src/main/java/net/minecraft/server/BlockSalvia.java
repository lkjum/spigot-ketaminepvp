package net.minecraft.server;

import java.util.Random;

public class BlockSalvia extends BlockCrops {

    public BlockSalvia() {}
    
    protected Item n() {
        return Items.SALVIA_FLOWER;
    }

    protected Item l() {
        return Items.SALVIA_SEEDS;
    }
    
    public Item getDropType(IBlockData iblockdata, Random random, int i) 
    {
    	if (random.nextInt(4) == 0)
    	{
    		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? this.n() : this.l();
    	}
    	else 
    	{
    		return null;
    	}
    }
}