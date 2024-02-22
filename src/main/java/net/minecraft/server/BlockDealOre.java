package net.minecraft.server;

import java.util.Random;


public class BlockDealOre extends Block 
{
    public BlockDealOre() {
        this(Material.STONE.r());
    }

	public BlockDealOre(MaterialMapColor r) {
	    super(Material.STONE, r);
	    this.a(CreativeModeTab.b);
	}


	int genererInt(int borneInf, int borneSup)
	{
		Random random = new Random();
		int nb;
		nb = borneInf+random.nextInt(borneSup-borneInf);
		return nb;
	
	}
	public Item getDropType(IBlockData iblockdata, Random random, int i) 
	{
	    int FF = 0;
		int II = 1;
		int BB = 4;
		int GG = 8;
		int AA = 12;
		int EE = 16;
		int HH = 32;
			if (genererInt(FF,BB) == 0) 
			{
			   return (this == Blocks.DEALORE ? Items.EXTKETA : Item.getItemOf(this));
		    }
			else if (genererInt(FF,BB) == 1) 
			{
		        return (this == Blocks.DEALORE ? Items.BICARBONATE : Item.getItemOf(this));
			}
			else if (genererInt(FF,GG) == 2) 
			{
			   	return (this == Blocks.DEALORE ? Items.COCAINE : Item.getItemOf(this));
			}
			   	   else if (genererInt(FF,GG) == 3) 
			   	   {
			   		   return (this == Blocks.DEALORE ? Items.KETAMINERAI : Item.getItemOf(this));
			   	   }
				   else if (genererInt(FF,GG) == 4) 
				   {
					   return (this == Blocks.DEALORE ? Items.EXTCRACK : Item.getItemOf(this));
				   }
				   else  if (genererInt(FF,GG) == 5) 
				   {
					   return (this == Blocks.DEALORE ? Items.PAIN2C : Item.getItemOf(this));
				   }
				   else if (genererInt(FF,EE) == 7) 
				   {
					   return (this == Blocks.DEALORE ? Items.BITCOIN : Item.getItemOf(this));
				   } 
				   else if (genererInt(FF,AA) == 6) 
				   {
					   return (this == Blocks.DEALORE ? Items.TITANE_NUGGET : Item.getItemOf(this));
				   }
				   else if (genererInt(II,HH) == genererInt(II,HH)) 
				   {
					   return (this == Blocks.DEALORE ? Items.DARK_BITCOIN : Item.getItemOf(this));
		   }
		   return (this == Blocks.DEALORE ? Items.EXTRAIT_BICAR : Item.getItemOf(this));

	    }

	    public int a(Random random)
	    {
	    	int II = 1;
			int OO = 2;
			int BB = 4;
			int GG = 8;
	    	if (this == Blocks.DEALORE) {
	    		 return this == Blocks.DEALORE ? genererInt(II,BB) :
	 	        	(this == Blocks.DEALORE ? genererInt(II,BB) :
	 	        		(this == Blocks.DEALORE ? genererInt(II,BB) :
	 	        			(this == Blocks.DEALORE ? genererInt(OO,GG) : 1)));
	    	}
			
	       return this == Blocks.DEALORE ? genererInt(II,BB) :
	        	(this == Blocks.DEALORE ? genererInt(II,BB) :
	        		(this == Blocks.DEALORE ? genererInt(II,BB) :
	        			(this == Blocks.DEALORE ? genererInt(OO,GG) : 1)));
	    }
	    
	    public int getDropCount(int fortune, Random random)
	    {
	        if (fortune > 0 && Item.getItemOf(this) != this.getDropType((IBlockData)this.P().a().iterator().next(), random, fortune))
	        {
	            int i = random.nextInt(fortune + 2) - 1;

	            if (i < 0)
	            {
	                i = 0;
	            }

	            return this.a(random) * (i + 1);
	        }
	        else
	        {
	            return this.a(random);
	        }
	    }
	    
	    @Override
	    public int getExpDrop(World world, IBlockData iblockdata, int i) {
	        if (this.getDropType(iblockdata, world.random, i) != Item.getItemOf(this)) {
	            int j = 0;

	            if (this == Blocks.DEALORE) {
	                j = MathHelper.nextInt(world.random, 3, 7);
	            } 

	            return j;
	        }

	        return 0;
	        // CraftBukkit end
	    }

	    public int getDropData(World world, BlockPosition blockposition) {
	        return 0;
	    }
}

       


