package net.minecraft.server;

import java.util.List;

import net.minecraft.server.EnumAnimation;
import net.minecraft.server.ItemFood;

public class PotionMilk  extends ItemFood{
    public PotionMilk(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		this.maxStackSize = 2;
	}
    
	public EnumAnimation e(ItemStack stack)
    {
        return EnumAnimation.DRINK;
    }
	public PotionMilk(int integer, float floatant, boolean bool) {
		super(integer, floatant, bool);
		//this.set(2);
		//this.();
		//this.maxStackSize = 2;
	}
	/*protected void onFoodEaten(ItemStack item, World world, EntityPlayer player) {
		if(world.isRemote) {
			player.clearActivePotions();
		}
		return;
	}*/
	
	public ItemStack b(ItemStack stack, World worldIn, EntityHuman playerIn)
    {
        if (!playerIn.abilities.canInstantlyBuild)
        {
            --stack.count;
        }

        	playerIn.removeAllEffects();
        
        return stack.count <= 0 ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 15;
    }
    public ItemStack a(ItemStack par1ItemStack, World par2World, EntityHuman par3EntityPlayer)
    {
        par3EntityPlayer.a(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
}



