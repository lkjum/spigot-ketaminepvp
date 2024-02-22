package net.minecraft.server;

import java.util.Random;

public class BlockPavot extends BlockCrops {
	
	
	protected BlockPavot() {}
	
	protected boolean c(Block block) 
	{
        return block == Blocks.MYCELIUM;
    }
	protected Item n() 
	{
        return Items.PAVOT;
    }

    protected Item l() 
    {
        return Items.PAVOT_SEEDS;
    }
    public Item getDropType(IBlockData iblockdata, Random random, int i) 
    {
    	if (random.nextInt(4) == 0)
    	{
    	return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() > 6 ? this.n() : this.l();
    	}
    	else if (random.nextInt(6) == 0) {
    		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() > 6 ? this.n() : this.l();
    	}
    	else {return this.l();}
    }
	
	public boolean a(World world, BlockPosition blockposition, IBlockData iblockdata, boolean flag) /*correspond a la fonction du client canGrow() 
    																								et world.i(blockPos) correspond à world.canSeeSky(blockPos)*/
    {
    	if	(world.i(blockposition) == true) {
    		return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() < 7;
    	}
    	else {return false;
    	}
    }
	/*Correspond a la fonction canBlockStay() du client*/
	public boolean f(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return world.i(blockposition) && this.c(world.getType(blockposition.down()).getBlock());
    }
    /*Correspond a la fonction canUseBoneMeal()*/
	public boolean a(World world, Random random, BlockPosition blockposition, IBlockData iblockdata) {
		if	(world.i(blockposition) == true) {
			return true;
		}
		else {
			return false;
		}
		
    }
	/*Correspond a la fonction getGrowthChance (ca pousse donc pas de probleme)*/
	public static float a(Block block, World world, BlockPosition blockposition) {
        float f = 1.0F;
        return f = 2.0F;
    }
}
