package net.minecraft.server;


import org.bukkit.ChatColor;

public class ItemJoint extends ItemFood {

	private int meta;
    public ItemJoint(int meta) {
    	super(0, 0, false);
        this.meta = meta;
    	//c(8);
        this.maxStackSize = 64;
        //this.k();
        this.h();
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
    	//if(meta ==0) {
        	world.makeSound(entityhuman, "ketamine.smoke", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            entityhuman.addEffect(new MobEffect(MobEffectList.WEAKNESS.id, 10000, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT.id, 10000, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.INVISIBILITY.id, 5000, 0));
            entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 4000, 2));
            entityhuman.addEffect(new MobEffect(MobEffectList.HUNGER.id, 600, 0));
            
           
            //}
        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 15;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.SMOKE;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
    	world.makeSound(entityhuman, "ketamine.lighter", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
    	entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
    /*int comp = 0;
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		 comp = comp + 1;
		 while (comp < 100) 
		 {
			 return;
		 }
	     if (comp > 100) 
	     {
	    	 //playerIn.b(AchievementList.beSnoopDog);	
	    	 comp = 0;
	    	 return;

	     }
	 }	  */
    
}