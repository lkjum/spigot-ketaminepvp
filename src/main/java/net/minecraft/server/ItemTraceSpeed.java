package net.minecraft.server;


import org.bukkit.ChatColor;

public class ItemTraceSpeed extends ItemFood {

	private int meta;
    public ItemTraceSpeed(int meta) {
    	super(0, 0, false);
        this.meta = meta;
    	//c(32);
        this.maxStackSize = 64;
        h();
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
    	//if(meta ==1) {
        	world.makeSound(entityhuman, "ketamine.trace", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 620, 3 ));
            entityhuman.addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, 1000, 0 ));
            //entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 1000, 0 ));
        	
    	//if(meta ==2) {
            //entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 2400, 1));
            //entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 2400, 1));
        //	}
        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 7;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.SNORT;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}