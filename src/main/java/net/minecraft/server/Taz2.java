package net.minecraft.server;

public class Taz2 extends ItemFood {

	private int meta;
    public Taz2(int meta) {
    	super(0, 0, false);
        this.meta = meta;
        this.maxStackSize = 64;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
    	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 720, 2));
    	entityhuman.addEffect(new MobEffect(MobEffectList.JUMP.id, 1000, 1));
    	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 6000, 0));
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
