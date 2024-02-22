package net.minecraft.server;

import java.util.Random;

public class BlockIboga extends BlockCrops {

    public BlockIboga() {}
    
    protected Item n() {
        return Items.IBOGA_FRUIT;
    }

    protected Item l() {
        return Items.IBOGA_ROOT;
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