package net.minecraft.server;

import com.google.common.collect.Multimap;

public class ItemDagueDiable extends ItemSword {

    private float a;
    private final Item.EnumToolMaterial b;

    public ItemDagueDiable(Item.EnumToolMaterial item_enumtoolmaterial) {
        super(item_enumtoolmaterial);
        this.b = item_enumtoolmaterial;
        this.maxStackSize = 1;
        this.setMaxDurability(item_enumtoolmaterial.a());
        this.a(CreativeModeTab.j);
        this.a = 4.0F + item_enumtoolmaterial.c();
    }


    public boolean a(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1) {
        
    	entityliving.addEffect(new MobEffect(MobEffectList.POISON.id, 20, 1));
    	entityliving.addEffect(new MobEffect(MobEffectList.BLINDNESS.id, 15, 0));
    	itemstack.damage(1, entityliving1);
        return true;
    }
}
