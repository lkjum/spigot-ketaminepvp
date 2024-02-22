package net.minecraft.server;


import org.bukkit.ChatColor;

public class ItemAcid extends ItemFood {
	
	private int meta;
    public ItemAcid(int meta) {
    	super(0, 0, false);
    	this.meta = meta;
    	c(64);
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }

        entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 120000, 0));
        entityhuman.addEffect(new MobEffect(MobEffectList.NIGHT_VISION.id, 120000, 0));
        
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