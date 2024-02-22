package net.minecraft.server;

import org.bukkit.ChatColor;

public class ItemMilk extends ItemFood {

	private int meta;
    public ItemMilk(int meta) {
    	super(0, 0, false);
    	this.meta = meta;
    	c(2);
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
        if(meta ==0) {
        	entityhuman.removeAllEffects();
        return itemstack.count <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : itemstack;
        }
		return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 20;
    }

    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.DRINK;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
    
}