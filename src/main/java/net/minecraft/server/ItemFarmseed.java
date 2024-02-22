package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class ItemFarmseed extends ItemTool {
	
	private Block croped;
    private Item reqSeed;
    private Block soilBlockID, soilBlockID2, IDc, IDo, IDb;
    private static final Set<Block> c = Sets.newHashSet(new Block[] { Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND});
   
    public ItemFarmseed(Item.EnumToolMaterial item_enumtoolmaterial)
    {
    	super(1.0F, item_enumtoolmaterial, c);
    	soilBlockID = Blocks.FARMLAND;
    	soilBlockID2 = Blocks.MYCELIUM;
    	this.IDc = Blocks.OBSIDIAN;
    	this.IDo = Blocks.CROUTE_TERRESTRE;
    	this.IDb = Blocks.BEDROCK;	
        this.a(CreativeModeTab.i);
        this.maxStackSize = 1;   
    }
   
    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition pos, EnumDirection enumdirection, float f, float f1, float f2) {

    	if (world.getType(pos).getBlock() == Blocks.PAVOTS){
    		croped = Blocks.PAVOTS;
    		reqSeed = Items.PAVOT_SEEDS;
    	}
    	else if (world.getType(pos).getBlock() == Blocks.PURPLES){
    		croped = Blocks.PURPLES;
    		reqSeed = Items.PURPLE_SEEDS;
    	}
    	if (enumdirection != EnumDirection.UP) 
    	{
            return false;
        } 
    	else if (!entityhuman.a(pos.shift(enumdirection), enumdirection, itemstack)) 
        {
            return false;
        } 
        else if (world.getType(pos.down()).getBlock() == this.soilBlockID || world.getType(pos.down()).getBlock() == this.soilBlockID2) 
        {
        	for (int i2 = 0; i2 < 3; i2++)
    		{
        		if (world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDc
    					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDo
    					&& world.getType(pos.a(i2, -1, 1)).getBlock() == this.IDo
    					|| world.getType(pos.a(i2, -1, -1)).getBlock() == this.IDo
    					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDc
    					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDc
    					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
    					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
    					&& world.getType(pos.a(i2, -1, 1)).getBlock() == this.IDb
    					|| world.getType(pos.a(i2, -1, -1)).getBlock() == this.IDb
    					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDb
    					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDb)
    			{
    				return false;
    			}
    			else if (world.getType(pos.a(-i2, 0, 0)).getBlock() == this.IDc
					|| world.getType(pos.a(-i2, 0, 0)).getBlock() == this.IDo
					&& world.getType(pos.a(-i2, -1, 1)).getBlock() == this.IDo
					|| world.getType(pos.a(-i2, -1, -1)).getBlock() == this.IDo
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					&& world.getType(pos.a(i2, -1, 1)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, -1, -1)).getBlock() == this.IDb
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDb
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDb)
    			{
    				return false;
    			} 
    			else if (world.getType(pos.a(0, 0, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(0, 0, i2)).getBlock() == this.IDo
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDo
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDo
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					&& world.getType(pos.a(i2, -1, 1)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, -1, -1)).getBlock() == this.IDb
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDb
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDb)
    			{
    				return false;
    			}
    			else if (world.getType(pos.a(0, 0, -i2)).getBlock() == this.IDc
					|| world.getType(pos.a(0, 0, -i2)).getBlock() == this.IDo
					&& world.getType(pos.a(1, -1, -i2)).getBlock() == this.IDo
					|| world.getType(pos.a(-1, -1, -i2)).getBlock() == this.IDo
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDc
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, 0, 0)).getBlock() == this.IDb
					&& world.getType(pos.a(i2, -1, 1)).getBlock() == this.IDb
					|| world.getType(pos.a(i2, -1, -1)).getBlock() == this.IDb
					&& world.getType(pos.a(1, -1, i2)).getBlock() == this.IDb
					|| world.getType(pos.a(-1, -1, i2)).getBlock() == this.IDb)
    			{
    				return false;
    			}
        		if (world.getType(pos.a(-1, -1, -1)).getBlock() != Blocks.MYCELIUM
        				|| world.getType(pos.a(1, -1, -1)).getBlock() != Blocks.MYCELIUM
        				|| world.getType(pos.a(0, -1, -1)).getBlock() != Blocks.MYCELIUM
        				|| world.getType(pos.a(0, -1, 1)).getBlock() != Blocks.MYCELIUM
    					|| world.getType(pos.a(1, -1, 0)).getBlock() != Blocks.MYCELIUM
    					|| world.getType(pos.a(-1, -1, 0)).getBlock() != Blocks.MYCELIUM) 
        		{
        			return false;
        		} 
    		}
        	if (world.getType(pos).getBlock() == Blocks.PAVOTS && entityhuman.inventory.b(reqSeed)
        			|| world.getType(pos).getBlock() == Blocks.PURPLES && entityhuman.inventory.b(reqSeed)) 
        	{
        		world.setAir(pos, true);
        		world.setAir(pos.a(1, 0, 0), true);
        		world.setAir(pos.a(0, 0, 1), true);
        		world.setAir(pos.a(-1, 0, 0), true);
        		world.setAir(pos.a(0, 0, -1), true);
        		world.setTypeUpdate(pos, this.croped.getBlockData());
        		world.setTypeUpdate(pos.a(1, 0, 0), this.croped.getBlockData());
        		world.setTypeUpdate(pos.a(0, 0, 1), this.croped.getBlockData());
        		world.setTypeUpdate(pos.a(-1, 0, 0), this.croped.getBlockData());
        		world.setTypeUpdate(pos.a(0, 0, -1), this.croped.getBlockData());
        		entityhuman.inventory.a(reqSeed);
        		entityhuman.inventory.a(reqSeed);   
        		entityhuman.inventory.a(reqSeed);  
        		entityhuman.inventory.a(reqSeed);  
        		entityhuman.inventory.a(reqSeed); 
        		entityhuman.inventory.pickup(new ItemStack(Items.ACID, 1));
        		itemstack.damage(5, entityhuman);
            	}
        		return true;
        	}
        	else 
        	{
        		return false;
        	}
        } 
    }

