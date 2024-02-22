package net.minecraft.server;

import java.util.Random;

public class ItemKetapple extends ItemFood {

	private int meta;
    public ItemKetapple(int meta) {
    	super(0, 0, false);
        this.meta = meta;
        this.maxStackSize = 64;
        c(64);
    }
	int genererInt(int borneInf, int borneSup)
	{
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;

	}
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
    	entityhuman.addEffect(new MobEffect(MobEffectList.INVISIBILITY.id, 620, 3));
    	entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 1000, 1));
    	entityhuman.addEffect(new MobEffect(MobEffectList.ABSORBTION.id, 2000, 0));
    	world.makeSound(entityhuman, "ketamine.payetatrace", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        return itemstack;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.EAT;
    }
   

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
    	int ii = 1;
    	int jj = 5;
    	if (this.genererInt(ii,jj) == 1) 	
    	{  
    		world.makeSound(entityhuman, "ketamine.gummy", 0.5F, world.random.nextFloat() * 0.2F + 0.4F);
    	} 
    	else if (this.genererInt(ii, jj) == 2 || this.genererInt(ii, jj) == 4) 
    	{
    		world.makeSound(entityhuman, "ketamine.eleoulake", 0.5F, world.random.nextFloat() * 0.2F + 0.4F);
    	}
    	entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}
