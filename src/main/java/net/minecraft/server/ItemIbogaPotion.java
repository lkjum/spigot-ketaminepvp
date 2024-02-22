package net.minecraft.server;

public class ItemIbogaPotion extends ItemFood 
{
    public ItemIbogaPotion() 
    {
    	super(0, 0, false);
    	this.maxStackSize = 2;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) 
    {
        if (!entityhuman.abilities.canInstantlyBuild) 
        {
            --itemstack.count;
        	entityhuman.removeEffect(MobEffectList.CONFUSION.id);
        	entityhuman.removeEffect(MobEffectList.WEAKNESS.id);
        	entityhuman.removeEffect(MobEffectList.SLOWER_MOVEMENT.id);
        }
        	
        return itemstack.count <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : itemstack;
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