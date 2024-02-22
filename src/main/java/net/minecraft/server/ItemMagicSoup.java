package net.minecraft.server;

public class ItemMagicSoup extends ItemFood {

    public ItemMagicSoup(int i) {
        super(i, false);
        this.c(1);
        
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) 
    {
        super.b(itemstack, world, entityhuman);
        
    	entityhuman.addEffect(new MobEffect(MobEffectList.ABSORBTION.id, 300, 1));
    	entityhuman.addEffect(new MobEffect(MobEffectList.POISON.id, 300, 1));
    	entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 300, 3));
    	entityhuman.addEffect(new MobEffect(MobEffectList.FIRE_RESISTANCE.id, 4000, 1));
	
    	return new ItemStack(Items.BOWL);
    }
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.EAT;
    }
   
}
