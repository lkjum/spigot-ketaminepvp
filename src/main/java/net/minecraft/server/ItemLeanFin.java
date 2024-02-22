package net.minecraft.server;

public class ItemLeanFin extends ItemFood 
{
    public ItemLeanFin() 
    {
    	super(0, 0, false);
    	this.maxStackSize = 1;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) 
    {
        if (!entityhuman.abilities.canInstantlyBuild) 
        {
            --itemstack.count;
            entityhuman.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT.id, 1000, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.WEAKNESS.id, 1000, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 500, 1));

        }
        	
        return itemstack.count <= 0 ? new ItemStack(Items.LEANVIDE) : itemstack;
    }

    public int d(ItemStack itemstack) 
    {
        return 15;
    }
    
    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) 
    {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}