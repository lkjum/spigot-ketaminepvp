package net.minecraft.server;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

public class ItemFarming extends ItemFarm {
	
	private Block croped;
    private Item reqSeed;
    private Block soilBlockID, soilBlockID2;
    private Random random = new Random();
    public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 7);
    private BlockStateList blockStateList;
    private static final Set<Block> c = Sets.newHashSet(new Block[] { Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND});
   
    public ItemFarming(Item.EnumToolMaterial item_enumtoolmaterial)
    {
    	super(1.0F, item_enumtoolmaterial, c);
    	soilBlockID = Blocks.FARMLAND;
    	soilBlockID2 = Blocks.MYCELIUM;
        this.a(CreativeModeTab.i);
        this.maxStackSize = 1;
        
    }
	int genererInt(int borneInf, int borneSup)
	{
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;

	}
	
    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition pos, EnumDirection enumdirection, float f, float f1, float f2) {
    	if (world.getType(pos).getBlock() == Blocks.WHEAT){
    		croped = Blocks.WHEAT;
    		reqSeed = Items.WHEAT_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.CARROTS){
    		croped = Blocks.CARROTS;
    		reqSeed = Items.CARROT;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.POTATOES){
    		croped = Blocks.POTATOES;
    		reqSeed = Items.POTATO;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.WEED){
    		croped = Blocks.WEED;
    		reqSeed = Items.WEED_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.COCA){
    		croped = Blocks.COCA;
    		reqSeed = Items.COCA_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.PAVOTS){
    		croped = Blocks.PAVOTS;
    		reqSeed = Items.PAVOT_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.PURPLES){
    		croped = Blocks.PURPLES;
    		reqSeed = Items.PURPLE_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.IBOGAS){
    		croped = Blocks.IBOGAS;
    		reqSeed = Items.IBOGA_ROOT;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.SALVIAS){
    		croped = Blocks.SALVIAS;
    		reqSeed = Items.SALVIA_SEEDS;
    	}
    	if (enumdirection != EnumDirection.UP) 
    	{
            return false;
        } 
    	else if (!entityhuman.a(pos.shift(enumdirection), enumdirection, itemstack)) 
    	{
            return false;
        } 
    	else if (world.getType(pos.down()).getBlock() == this.soilBlockID || world.getType(pos.down()).getBlock() == this.soilBlockID2 && world.isEmpty(pos.up())) 
    	{
        	if (world.getType(pos).getBlock() == Blocks.WHEAT && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.CARROTS && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.POTATOES && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.WEED && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.COCA && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.PAVOTS && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.PURPLES && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.IBOGAS && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.SALVIAS && entityhuman.inventory.b(reqSeed)) 
        	{
	            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.FARM_TOOL.id, itemstack);
	            int fort = EnchantmentManager.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS.id, itemstack);
	           // IBlockData data = iblockdata.get(AGE);
	            //int data =  ((Integer)iblockdata.get(AGE).intValue());
	            //this.blockStateList = (BlockStateList) world.getType(pos).get(AGE);
	            
	            //Block a = Blocks.WEED;   
	            if (inf > 0 && fort > 2)
	            {
	            	//if (data == 7) 
	            	//if (world.getType(pos).getBlock().get(.AGE).intValue() == 7)
	            	//world.getType(pos).getBlock() == this.croped && 
	            	//if (world.getType(pos).get(AGE).intValue() >= 7) 
	            	//{
	            	//if (data >= 7)
	            	world.setAir(pos, true);
	            	world.setTypeUpdate(pos, this.croped.getBlockData());
	            	entityhuman.inventory.a(reqSeed);
	            	entityhuman.inventory.a(reqSeed);
	            	entityhuman.inventory.a(reqSeed);
	            	entityhuman.inventory.a(reqSeed);
	            	entityhuman.inventory.a(reqSeed);
	            	itemstack.damage(5, entityhuman);	
	            		//InventoryUtils.dropItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BEUH, 1));     

	            		//if (world.getType(pos).getBlock().get(AGE).intValue() == 7)
	            		if (random.nextInt(15) == 0) 
	            		{
	            			entityhuman.inventory.pickup(new ItemStack(this.reqSeed, 1));
	            			if (world.getType(pos).getBlock() == Blocks.WHEAT && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Blocks.WHEAT, 1));
	            			}else if (world.getType(pos).getBlock() == Blocks.CARROTS && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.GOLDEN_CARROT, 2));
	            			}else if (world.getType(pos).getBlock() == Blocks.POTATOES && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.BAKED_POTATO, 2));
	            			}else if (world.getType(pos).getBlock() == Blocks.WEED && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.JOINT, 1));
	            				
	            				
	            			}else if (world.getType(pos).getBlock() == Blocks.COCA && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.TRACE2C, 1));
	            			}else if (world.getType(pos).getBlock() == Blocks.PAVOTS && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.HEROINE, 1));
	            			}else if (world.getType(pos).getBlock() == Blocks.PURPLES && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.JOINT, 1));
	            			}else if (world.getType(pos).getBlock() == Blocks.IBOGAS && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.ITEM_IBOGA_POTION, 1));
	            			}else if (world.getType(pos).getBlock() == Blocks.SALVIAS && entityhuman.inventory.b(reqSeed)) {
	            				entityhuman.inventory.pickup(new ItemStack(Items.SALVIAX40, 1));
	            			}
	            		}
	            }
	            else 
	            {
	            	world.setAir(pos, true);
	            	world.setTypeUpdate(pos, this.croped.getBlockData());
	            	entityhuman.inventory.a(reqSeed);
	            	itemstack.damage(1, entityhuman);
	            }
            	//InventoryUtils.dropItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BEUH, 1));
            	//entityhuman.inventory.pickup(new ItemStack(Items.ACID, 1));
            }
            	return true;
        	}
        	else 
        	{
        		return false;
        	}
        }	
}
