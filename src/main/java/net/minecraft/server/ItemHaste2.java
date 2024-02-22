package net.minecraft.server;

public class ItemHaste2 extends ItemFood {

	private int meta;
    public ItemHaste2(int meta) {
    	super(0, 0, false);
        //this.meta = meta;
    	//c(2);
    	this.maxStackSize = 2;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
        	//if(meta ==0) {
        		entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 4800, 1));
        	//}
        	//else if(meta ==1) {
            	//entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 2400, 1));
        	//}
        	

        return itemstack.count <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : itemstack;
    }

    public int d(ItemStack itemstack) {
        return 15;
    }
    
    /*public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.DRINK;
    }*/
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}