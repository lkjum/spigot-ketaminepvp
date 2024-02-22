package net.minecraft.server;

import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;

public class ItemTaz extends ItemFood {

    public ItemTaz() {
    	super(0, 0.0F, false);
        this.a(true);
        this.setMaxDurability(0);
        c(64);
        
       
    }
    public int d(ItemStack stack)
    {
        return 5;
    }  
    private static final String[] tazType = new String[] {"gold", "superman", "domino", "mitsu"};
    
    public String e_(ItemStack stack) {

    		int i = stack.getData();

            if (i < 0 || i >= tazType.length)
            {
                i = 0;
            }

            return super.getName() + "." + tazType[i];
        }
    
    public ItemStack b(ItemStack stack, World world, EntityHuman entityhuman) {
    	int meta = stack.getData();
    	
        if (!entityhuman.abilities.canInstantlyBuild) {
            --stack.count;
        }
        if (!world.isClientSide)
        {
        	entityhuman.addEffect(new MobEffect(MobEffectList.ABSORBTION.id, 2400, 0));
        }
    	if (meta == 0)
        {
            if (!world.isClientSide)
            {
            	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 360, 3));
            	entityhuman.addEffect(new MobEffect(MobEffectList.FALL.id, 1000, 1));
                entityhuman.addEffect(new MobEffect(MobEffectList.FIRE_RESISTANCE.id, 6000, 0));
            }
        }
        if (meta == 1)
        {
            if (!world.isClientSide)
            {
            	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 720, 2));
            	entityhuman.addEffect(new MobEffect(MobEffectList.JUMP.id, 1000, 1));
            	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_DIG.id, 6000, 0));
            }
        }
        if (meta == 2)
        {
            if (!world.isClientSide)
            {
            	entityhuman.addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, 360, 1));
            	entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 300, 0));
            	entityhuman.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 3000, 0));
            }
        }
        if (meta == 3)
        {
            if (!world.isClientSide)
            {
            	entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 360, 3));
            	entityhuman.addEffect(new MobEffect(MobEffectList.WATER_BREATHING.id, 1000, 1));
            	entityhuman.addEffect(new MobEffect(MobEffectList.RESISTANCE.id, 2000, 0));
            }
        }
        else
        {
            super.b(stack, world, entityhuman);
        }
		return stack;
        }
    
    }
    