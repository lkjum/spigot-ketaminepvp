package net.minecraft.server;

import java.util.Random;

import org.bukkit.craftbukkit.event.CraftEventFactory;

public class BlockWeedPlant extends BlockCrops {
	
	public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 7);
	protected BlockWeedPlant() 
	{
        float f = 0.5F;
        this.a(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	
	protected boolean c(Block block) 
	{
        return block == Blocks.WEED_PLANT_BASE;
    }
	protected Item n() 
	{
		int ff = 1;
		int gg = 8;
		if (this.genererInt(ff, gg) == 8) {
			return Items.WEED_PLANT_ITEM;
		}else {
			return null;
		}
        
    }
	protected Item l() 
	{
		int ff = 1;
		int gg = 3;
		if (this.genererInt(ff, gg) == 2) {
			return Items.WEED_PLANT_ITEM;
		}else {
			return null;
		}
        
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) 
    {
    	return ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 ? this.n() : this.l();
    }
    public boolean a(World world, Random random, BlockPosition blockposition, IBlockData iblockdata) {
        return false;
    }
	
    public void b(World world, BlockPosition blockposition, IBlockData iblockdata, Random random) {
        super.b(world, blockposition, iblockdata, random);
        if (world.getLightLevel(blockposition.up()) >= 9) {
            int i = ((Integer) iblockdata.get(BlockCrops.AGE)).intValue();

            if (i < 7) {
                float f = a((Block) this, world, blockposition);

                if (random.nextInt((int) (world.growthOdds / world.spigotConfig.wheatModifier * (25.0F / f)) + 1) == 0) { // Spigot                    // CraftBukkit start
                    IBlockData data = iblockdata.set(AGE, Integer.valueOf(i + 1));
                    CraftEventFactory.handleBlockGrowEvent(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), this, toLegacyData(data));
                    // CraftBukkit end
                }
            }
        }
    }
    
	int genererInt(int borneInf, int borneSup)
	{
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;

	}

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) 
    {
    	int ii = 1;
    	int ff = 3;
    	int gg = 16;
        
    	if ((Integer)iblockdata.get(BlockCrops.AGE).intValue() >= 7) 
    	{
    		if (this.genererInt(ii, ff) == 1) 
        	{
    			InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.BEUH, 2));
        	} 
        	else if (this.genererInt(ii, ff) == 2) 
        	{
        		InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.BEUH, 3));
        	} 
        	else if (this.genererInt(ii, ff) == 3) 
        	{
        		InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.BEUH, 2));
        	}
        	if (this.genererInt(ii, gg) == 0) 
        	{
        		InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.CANNABIS, 1));
        	} 
        	else 
        	{
        		InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.BEUH, 1));
        	}
    		//InventoryUtils.dropItem(world, blockposition.getX(), blockposition.getY(), blockposition.getZ(), new ItemStack(Items.CANNABIS, 1));
    		world.setTypeUpdate(blockposition, this.blockStateList.getBlockData().set(AGE, Integer.valueOf(5)));
    	}
    	return true;
    }
	public static float a(Block block, World world, BlockPosition blockposition) {
        float f = 1.0F;
        return f = 2.0F;
    }
}