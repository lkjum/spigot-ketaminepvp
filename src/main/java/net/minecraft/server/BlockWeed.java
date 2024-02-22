  
package net.minecraft.server;

import java.util.Random;

public class BlockWeed extends BlockCrops {

    public BlockWeed() {}
    
    protected Item n() {
        return Items.BEUH;
    }

    protected Item l() {
        return Items.WEED_SEEDS;
    }
    protected Item special() {
    	return Items.CANNABIS;
    }
    
    public Item getDropType(IBlockData iblockdata, Random random, int i) {
    	if (random.nextInt(2) == 0) {
        return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? this.n() : this.l();
    	}
    	else if (random.nextInt(9) == 0) {
            return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? null :  this.l();
        	}
    	else if (random.nextInt(31) == 0) {
    		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? this.special() : this.l();
    	}
    	else {
		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? this.n() : this.l();
    	}
    }
}

