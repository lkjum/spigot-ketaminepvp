package net.minecraft.server;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

public class ItemMultiPick extends ItemMFarm 
{
	//private Faction faction = new Faction();
    private static final Set<Block> c = Sets.newHashSet(new Block[] 
    { 
    		Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, 
    		Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, 
    		Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, 
    		Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB,Blocks.BICAR_BLOCK, Blocks.BICARBONATE_ORE, 
    		Blocks.KETA_ORE, Blocks.KETA_BLOCK, Blocks.COKE_ORE, Blocks.COKE_BLOCK, Blocks.BITCOIN_ORE, Blocks.DEALORE,
    });
    
    private Block IDc, IDo, IDb;
    private boolean dropBlock = true;
    
    protected ItemMultiPick(Item.EnumToolMaterial item_enumtoolmaterial) 
    {
        super(2.0F, item_enumtoolmaterial, c);
        this.IDc = Blocks.OBSIDIAN;
        this.IDo = Blocks.CROUTE_TERRESTRE;
        this.IDb = Blocks.BEDROCK;
    }

    public boolean canDestroySpecialBlock(Block block) 
    {
        return block == this.IDc || block == this.IDo ? this.b.d() >= 3 : 
        	(block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE ? (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK ? (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE ? (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE ? (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE ? (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE ? (block.getMaterial() == Material.STONE ? true : 
        		(block.getMaterial() == Material.ORE ? true : 
        			block.getMaterial() == Material.HEAVY)) : 
        				this.b.d() >= 2) : this.b.d() >= 1) : 
        					this.b.d() >= 1) : this.b.d() >= 2) :
        						this.b.d() >= 2) : this.b.d() >= 2);
    }

    public float getDestroySpeed(ItemStack itemstack, Block block) 
    {
        return block.getMaterial() != Material.ORE && block.getMaterial() != Material.HEAVY && block.getMaterial() != Material.STONE ? super.getDestroySpeed(itemstack, block) : this.a;
    }
    
    public boolean a(ItemStack itemstack, World world, Block block, BlockPosition blockposition, EntityLiving entityliving) 
    {
    	
    	/*for (int i = 0; i < 5; i++)
    	{
    		if (world.getType(blockposition.a(i, i, i)).getBlock() == this.IDc || world.getType(blockposition.a(-i, -i, -i)).getBlock() == this.IDc) 
    		{
    			this.dropBlock = false;
    			itemstack.damage(1, entityliving);
    			return false;
    		} 
    		else 
    		{
    			this.dropBlock = true;
    		}
    	}
    	
    	for (int i = 0; i < 4; i++)
    	{
    		if (!(world.getType(blockposition.a(i, i, i)).getBlock() != this.IDc) 
    				|| !(world.getType(blockposition.a(i, i, i)).getBlock() != this.IDo) 
    				|| !(world.getType(blockposition.a(i, i, i)).getBlock() != this.IDb)) 
    		{
    			itemstack.damage(1, entityliving);
    			this.dropBlock = false;
    			return false;
    		}
    		else if (!(world.getType(blockposition.a(-i, -i, -i)).getBlock() != this.IDc) 
    				|| !(world.getType(blockposition.a(-i,-i,-i)).getBlock() != this.IDo) 
    				|| !(world.getType(blockposition.a(-i, -i, -i)).getBlock() != this.IDb)) 
    		{
    			itemstack.damage(1, entityliving);
    			this.dropBlock = false;
    			return false;
    		}
    		
    		/*if ((world.getType(blockposition.a(i, i, i)).getBlock() != this.IDc) 
				|| (world.getType(blockposition.a(i, i, i)).getBlock() != this.IDo) 
				|| (world.getType(blockposition.a(i, i, i)).getBlock() != this.IDb))
    		{
    			this.dropBlock = true;
    		}
    		else if ((world.getType(blockposition.a(-i, -i, -i)).getBlock() != this.IDc) 
				|| (world.getType(blockposition.a(-i, -i, -i)).getBlock() != this.IDo) 
				|| (world.getType(blockposition.a(-i, -i, -i)).getBlock() != this.IDb))
    		{
    			this.dropBlock = true;
    		}
    	}*/
        if ((double) block.g(world, blockposition.north()) != 0.0D && this.dropBlock) 
        {
        	 int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.HAMMER.id, itemstack);
        	if (inf > 0) {
        		 for (int iK = 0; iK < 3; iK++) {
        			 if (world.getType(blockposition.a(iK, 0, 0)).getBlock().getMaterial() != Material.BEDROCK) {
         				world.setAir(blockposition.a(iK, 0, 0), this.dropBlock);
         			}
         			if (world.getType(blockposition.a(0, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, 0, iK), this.dropBlock);
         			}
         		if (world.getType(blockposition.a(-iK, 0, 0)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 0, 0), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(0, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, 0, -iK), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(iK, 1, 0)).getBlock().getMaterial() != Material.BEDROCK) {	
         		world.setAir(blockposition.a(iK, 1, 0), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(0, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, 1, iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-iK, 1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 1, 0), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(0, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, 1, -iK), this.dropBlock);
         		}
         			
         		if (world.getType(blockposition.a(iK, -1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, -1, 0), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(0, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, -1, iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-iK, -1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, -1, 0), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(0, -1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(0, -1, -iK), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(1, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, 0, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(1, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, 0, iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(1, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, 1, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(1, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, 1, iK), this.dropBlock);  
         		}
         		if (world.getType(blockposition.a(1,-1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, -1, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(1, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(1, -1, iK), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(-1, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, 0, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-1, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, 0, iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-1, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, 1, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-1, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, 1, iK), this.dropBlock);  
         		}
         		if (world.getType(blockposition.a(-1, -1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, -1, -iK), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-1, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-1, -1, iK), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(-iK, 0, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 0, -1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, 0, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, 0, -1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-iK, 1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 1, -1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, 1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, 1, -1), this.dropBlock); 
         		}
         		if (world.getType(blockposition.a(-iK, -1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, -1, -1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, -1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, -1, -1), this.dropBlock);
         		}
         		
         		if (world.getType(blockposition.a(-iK, 0, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 0, 1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, 0, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, 0, 1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(-iK, 1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, 1, 1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, 1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, 1, 1), this.dropBlock);  
         		}
         		if (world.getType(blockposition.a(-iK, -1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(-iK, -1, 1), this.dropBlock);
         		}
         		if (world.getType(blockposition.a(iK, -1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
         		world.setAir(blockposition.a(iK, -1, 1), this.dropBlock);
         		}
         	}
         	itemstack.damage(15, entityliving);
         	
        		 
        	} else {
        	 for (int iK = 0; iK < 2; iK++) 
        		{
        			if (world.getType(blockposition.a(iK, 0, 0)).getBlock().getMaterial() != Material.BEDROCK) {
        				world.setAir(blockposition.a(iK, 0, 0), this.dropBlock);
        			}
        			if (world.getType(blockposition.a(0, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, 0, iK), this.dropBlock);
        			}
        		if (world.getType(blockposition.a(-iK, 0, 0)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 0, 0), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(0, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, 0, -iK), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(iK, 1, 0)).getBlock().getMaterial() != Material.BEDROCK) {	
        		world.setAir(blockposition.a(iK, 1, 0), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(0, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, 1, iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-iK, 1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 1, 0), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(0, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, 1, -iK), this.dropBlock);
        		}
        			
        		if (world.getType(blockposition.a(iK, -1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, -1, 0), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(0, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, -1, iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-iK, -1, 0)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, -1, 0), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(0, -1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(0, -1, -iK), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(1, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, 0, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(1, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, 0, iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(1, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, 1, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(1, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, 1, iK), this.dropBlock);  
        		}
        		if (world.getType(blockposition.a(1,-1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, -1, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(1, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(1, -1, iK), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(-1, 0, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, 0, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-1, 0, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, 0, iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-1, 1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, 1, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-1, 1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, 1, iK), this.dropBlock);  
        		}
        		if (world.getType(blockposition.a(-1, -1, -iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, -1, -iK), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-1, -1, iK)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-1, -1, iK), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(-iK, 0, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 0, -1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, 0, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, 0, -1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-iK, 1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 1, -1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, 1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, 1, -1), this.dropBlock); 
        		}
        		if (world.getType(blockposition.a(-iK, -1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, -1, -1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, -1, -1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, -1, -1), this.dropBlock);
        		}
        		
        		if (world.getType(blockposition.a(-iK, 0, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 0, 1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, 0, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, 0, 1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(-iK, 1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, 1, 1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, 1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, 1, 1), this.dropBlock);  
        		}
        		if (world.getType(blockposition.a(-iK, -1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(-iK, -1, 1), this.dropBlock);
        		}
        		if (world.getType(blockposition.a(iK, -1, 1)).getBlock().getMaterial() != Material.BEDROCK) {
        		world.setAir(blockposition.a(iK, -1, 1), this.dropBlock);
        		}
        	}
        	itemstack.damage(3, entityliving);
        	}
        }
        		
        	
       // }
        return true;
    }
}
        		