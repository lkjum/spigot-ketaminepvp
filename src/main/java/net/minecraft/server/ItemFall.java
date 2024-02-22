package net.minecraft.server;


public class ItemFall extends ItemFood {

    public ItemFall() {
    	super(0, 0, false);
    	this.maxStackSize = 2;
    }
    int meta = 0;

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
        	entityhuman.addEffect(new MobEffect(MobEffectList.FALL.id, 4800, 1));

        return itemstack.count <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : itemstack;
    }

    public int d(ItemStack itemstack) {
        return 15;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}