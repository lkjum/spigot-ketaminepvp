package net.minecraft.server;

public class ItemLeanDemi extends ItemFood 
{
    public ItemLeanDemi() 
    {
    	super(0, 0, false);
    	this.maxStackSize = 1;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) 
    {
        if (!entityhuman.abilities.canInstantlyBuild) 
        {
            --itemstack.count;
            entityhuman.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT.id, 2500, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.WEAKNESS.id, 2500, 1));
            entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 1000, 1));

        }
        	
        return itemstack.count <= 0 ? new ItemStack(Items.FIN2LEAN) : itemstack;
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