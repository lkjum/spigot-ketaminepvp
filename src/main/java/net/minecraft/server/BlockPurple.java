package net.minecraft.server;

import java.util.Random;

public class BlockPurple extends BlockCrops {
	
	
	protected BlockPurple() {}
	
	protected boolean c(Block block) {
        return block == Blocks.MYCELIUM;
    }
	protected Item n() {
        return Items.PURPLE;
    }
	protected Item abc() {
        return Items.PURPLE_TETE;
    }

    protected Item l() {
        return Items.PURPLE_SEEDS;
    }
    public Item getDropType(IBlockData iblockdata, Random random, int i) {
    	if (random.nextInt(4) == 0){
    	return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() > 6 ? this.abc() : this.l();
    	}
    	else if (random.nextInt(25) == 0) {
    		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() > 6 ? this.n() : this.l();
    	}
    	else {return this.l();}
    }
	

}