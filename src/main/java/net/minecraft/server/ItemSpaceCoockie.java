package net.minecraft.server;

public class ItemSpaceCoockie extends ItemFood {
	
	public ItemSpaceCoockie() {
    	super(5, 0.1F, false);
        this.a(true);
        this.setMaxDurability(0);
        c(64);   
    }
    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
    	entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 200, 2));
    	entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 500, 1));
        return itemstack;
    }
    public int d(ItemStack itemstack) {
        return 15;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.EAT;
    }
    
    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
}
