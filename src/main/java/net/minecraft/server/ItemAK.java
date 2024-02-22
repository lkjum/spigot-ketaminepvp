package net.minecraft.server;

import java.awt.List;


public class ItemAK extends ItemFood
{
    public static final String[] AK47PullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};

    public ItemAK(int integer, float floatant, boolean bool) {
    	
		super(integer, floatant, bool);
        //this.setMaxStackSize(1);
		this.maxStackSize = 1;
        this.setMaxDurability(800);
        this.a(CreativeModeTab.j);
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void a(ItemStack par1ItemStack, World par2World, EntityHuman par3EntityPlayer, int par4)
    {
        boolean var5 = par3EntityPlayer.abilities.canInstantlyBuild || EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, par1ItemStack) > 0;

        //if (var5 || par3EntityPlayer.inventory.b(Items.AMMO))
        //{
            int var6 = this.d(par1ItemStack) - par4;
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
            

            if (var5 || par3EntityPlayer.inventory.b(Items.AMMO))
            {
                int var61 = this.d(par1ItemStack) - par4;
                float var71 = (float)var61 / 20.0F;
                var71 = (var71 * var71 + var71 * 2.0F) / 3.0F;
                if ((double)var71 < 0.1D)
                {
                    return;
                }

                if (var71 > 1.0F)
                {
                    var71 = 1.0F;
                }
        	float var711 = 1.0F;
            
            
            
     

            EntityAmmo var8 = new EntityAmmo(par2World, par3EntityPlayer, 8.0F * 1.5F);
            //var8.damage = 3.1D;
            par2World.makeSound(par3EntityPlayer, "ketamine.shot", 0.5F, par2World.random.nextFloat() * 0.1F + 0.9F);
            if (par3EntityPlayer.abilities.canInstantlyBuild || par3EntityPlayer.inventory.b(Items.AMMO))
            {
            	par3EntityPlayer.a(par1ItemStack, this.d(par1ItemStack));
            }
            if (!par2World.e)
            {
            		par2World.addEntity(var8);
            		par3EntityPlayer.inventory.a(Items.AMMO);
            	
            }
            }
            /*if (var711 == 1.0F)
            {
                var8.setCritical(true);
            }

            int var9 = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, par1ItemStack);

            if (var9 > 0)
            {
                var8.b(var8.j() + (double)var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, par1ItemStack);

            if (var10 > 0)
            {
                var8.setKnockbackStrength(var10);
            }

            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, par1ItemStack) > 0)
            {
                var8.setOnFire(100);
            }

            par1ItemStack.damage(1, par3EntityPlayer);
            par2World.makeSound(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (g.nextFloat() * 0.4F + 1.2F) + var711 * 0.5F);

            if (var5)
            {
                var8.fromPlayer = 2;
            }
            else
            {
                par3EntityPlayer.inventory.a(Items.AMMO);
            }

            
            }*/
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
    	worldIn.makeSound(playerIn, "ketamine.shot", 2.0F, 1.0F);
        if (playerIn.abilities.canInstantlyBuild || playerIn.inventory.b(Items.AMMO))
        {
            playerIn.a(itemStackIn, this.d(itemStackIn));
        }
        if (!worldIn.e)
        {
        		worldIn.addEntity(var8);
        		var8.b(var8.j()+0.01F);
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
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
    	
    }
}
