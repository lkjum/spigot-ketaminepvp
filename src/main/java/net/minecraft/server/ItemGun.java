package net.minecraft.server;

import java.awt.List;

public class ItemGun extends ItemFood
{
    public ItemGun(int integer, float floatant, boolean bool) 
    {
		super(integer, floatant, bool);
		this.maxStackSize = 1;
        this.setMaxDurability(800);
        this.a(CreativeModeTab.j);
    }
    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack b(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int d(ItemStack stack)
    {
        return 4000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAnimation e(ItemStack stack)
    {
        return EnumAnimation.SHOT;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack a(ItemStack itemStackIn, World worldIn, EntityHuman playerIn)
    {
        if (playerIn.inventory.b(Items.AMMO))
        {
            int var61 = this.d(itemStackIn);
            float var71 = (float)var61 / 20.0F;
            var71 = (var71 * var71 + var71 * 2.0F) / 3.0F;
            if ((double)var71 < 0.1D)
            {
                return itemStackIn;
            }

            if (var71 > 1.0F)
            {
                var71 = 1.0F;
            }  	
    	float var7 = 1.0F;

    	EntityAmmo var8 = new EntityAmmo(worldIn, playerIn, 8.0F * 1.5F);
    	worldIn.makeSound(playerIn, "ketamine.shotgun", 2.0F, 1.0F);
    	//worldIn.addParticle(EnumParticle.FIREWORKS_SPARK, 0, 0, 0, 0, 0, 0, new int[0]);
        if (playerIn.abilities.canInstantlyBuild || playerIn.inventory.b(Items.AMMO))
        {
            playerIn.a(itemStackIn, this.d(itemStackIn));
        }
        if (!worldIn.e)
        {
        		worldIn.addEntity(var8);
        		playerIn.inventory.a(Items.AMMO);
        	
        }
        }
        return itemStackIn;
    }
		
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 2;
    }
}