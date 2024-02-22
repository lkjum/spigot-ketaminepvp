package net.minecraft.server;

import org.bukkit.event.player.PlayerFishEvent; // CraftBukkit

public class ItemGrappin extends Item {

    public ItemGrappin() {
        this.setMaxDurability(8000);
        this.c(1);
        this.a(CreativeModeTab.i);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.grappened != null) {
            int i = entityhuman.grappened.l();

            itemstack.damage(i, entityhuman);
            entityhuman.bw();
        } else {
            // CraftBukkit start
        	EntityGrappin hook = new EntityGrappin(world, entityhuman);

            // CraftBukkit end
            world.makeSound(entityhuman, "random.bow", 0.5F, 0.4F / (ItemFishingRod.g.nextFloat() * 0.4F + 0.8F));
            if (!world.isClientSide) {
                world.addEntity(hook); // CraftBukkit - moved creation up
            }

            entityhuman.bw();
            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
        }

        return itemstack;
    }

    public boolean f_(ItemStack itemstack) {
        return super.f_(itemstack);
    }

    public int b() {
        return 1;
    }
}
