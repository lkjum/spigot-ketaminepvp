package net.minecraft.server;


import org.bukkit.ChatColor;

public class ItemCrack extends ItemSmoke {
	
	private int meta;
    public ItemCrack(int meta) {
    	super(0, 0, false);
    	this.meta = meta;
    	//c(8);
    	this.maxStackSize = 8;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }

        	if(meta == 0 ) {
        		world.makeSound(entityhuman, "ketamine.smoke", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 3000, 1));
            	entityhuman.addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, 3000, 0));
            	entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 4000, 1));
        	}
        	if(meta == 1 ) {
        		world.makeSound(entityhuman, "ketamine.smoke", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        		entityhuman.addEffect(new MobEffect(MobEffectList.INVISIBILITY.id, 1000));
        		entityhuman.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT.id, 1000, 1));
        		entityhuman.addEffect(new MobEffect(MobEffectList.WEAKNESS.id, 250, 2));
        	}
        	if(meta == 2 ) {
        		world.makeSound(entityhuman, "ketamine.smoke", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        		entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 2000, 0));
        		entityhuman.addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, 1000, 0));
        	}
        	if(meta == 3 ) {
        		world.makeSound(entityhuman, "ketamine.smoke", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        		entityhuman.addEffect(new MobEffect(MobEffectList.NIGHT_VISION.id, 10000, 0));
        		entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 500));
        		entityhuman.addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, 1000, 0));
        		entityhuman.addEffect(new MobEffect(MobEffectList.WEAKNESS.id, 1000, 1));
        	}
        
        return itemstack.count <= 0 ? new ItemStack(Items.PIPE) : itemstack;
    
    }

    public int d(ItemStack itemstack) {
        return 20;
    }
    

    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.SMOKE;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    /*int comp = 0;
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		
		if (meta == 0) {
			comp = comp + 1;
			while (comp < 1000) 
			{
				return;
			}
			if (comp > 1000) 
			{
				//playerIn.b(AchievementList.beHeisenberg);	
				comp = 0;
				return;

			}
		}
	}	*/   
}