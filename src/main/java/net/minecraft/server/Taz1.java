package net.minecraft.server;

public class Taz1 extends ItemFood {

	private int meta;
    public Taz1(int meta) {
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
    	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 360, 3));
    	entityhuman.addEffect(new MobEffect(MobEffectList.FALL.id, 1000, 1));
        entityhuman.addEffect(new MobEffect(MobEffectList.FIRE_RESISTANCE.id, 6000, 0));
        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 5;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.GOBE;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}