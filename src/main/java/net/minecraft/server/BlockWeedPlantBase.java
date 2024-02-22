package net.minecraft.server;

import java.util.Random;

import org.bukkit.craftbukkit.event.CraftEventFactory;

public class BlockWeedPlantBase extends BlockCrops {
	
	public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 7);
	public Block weedPlant;
	protected BlockWeedPlantBase() 
	{
        float f = 0.5F;
        this.a(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	
	protected boolean c(Block block) 
	{
        return block == Blocks.FARMLAND;
    }
	protected Item n() 
	{
        return Items.WEED_PLANT_ITEM;
    }

    protected Item l() 
    {
        return Items.WEED_PLANT_ITEM;
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
        this.weedPlant = Blocks.WEED_PLANT_TOP;
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
            if (((Integer) iblockdata.get(BlockCrops.AGE)).intValue() >= 7 && world.getType(blockposition.a(0,1,0)) == Blocks.AIR.getBlockData()) {
            	world.setTypeUpdate(blockposition.a(0,1,0), this.weedPlant.getBlockData());
            }
        }
    }
        
	public static float a(Block block, World world, BlockPosition blockposition) {
        float f = 1.0F;
        return f = 2.0F;
    }
}