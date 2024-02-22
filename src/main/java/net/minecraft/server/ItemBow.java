package net.minecraft.server;

import org.bukkit.event.entity.EntityCombustEvent; // CraftBukkit

public class ItemBow extends Item {

    public static final String[] a = new String[] { "pulling_0", "pulling_1", "pulling_2"};

    public ItemBow() {
        this.maxStackSize = 1;
        this.setMaxDurability(384);
        this.a(CreativeModeTab.j);
    }

    public void a(ItemStack itemstack, World world, EntityHuman entityhuman, int i) 
    {
        
    	boolean flag = entityhuman.abilities.canInstantlyBuild;/* || EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack) > 0*/

    	if (flag || entityhuman.inventory.b(Items.ARROW)) {
			if (!(entityhuman.inventory.b(Items.ARROWFORCE))) {
				if (!(entityhuman.inventory.b(Items.ARROWLENTEUR))) {
					if (!(entityhuman.inventory.b(Items.ARROWPOISON))) {
						if (!(entityhuman.inventory.b(Items.ARROWSPEED))) 
						{
							int j = this.d(itemstack) - i;
				            float f = (float) j / 20.0F;

				            f = (f * f + f * 2.0F) / 3.0F;
				            if ((double) f < 0.1D) {
				                return;
				            }

				            if (f > 1.0F) {
				                f = 1.0F;
				            }

				            EntityArrow entityarrow = new EntityArrow(world, entityhuman, f * 2.0F);

				            if (f == 1.0F) {
				                entityarrow.setCritical(true);
				            }

				            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

				            if (k > 0) {
				                entityarrow.b(entityarrow.j() + (double) k * 0.5D + 0.5D);
				            }

				            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

				            if (l > 0) {
				                entityarrow.setKnockbackStrength(l);
				            }

				            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
				                // CraftBukkit start - call EntityCombustEvent
				                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
				                entityarrow.world.getServer().getPluginManager().callEvent(event);

				                if (!event.isCancelled()) {
				                    entityarrow.setOnFire(event.getDuration());
				                }
				                // CraftBukkit end
				            }

				            // CraftBukkit start
				            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEvent(entityhuman, itemstack, entityarrow, f);
				            if (event.isCancelled()) {
				                event.getProjectile().remove();
				                return;
				            }

				            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
				                world.addEntity(entityarrow);
				            }
				            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack);

				            if (inf > 0) 
				            {
				            	entityarrow.fromPlayer = 2;
				            } 
				            else
				            {
				            	entityhuman.inventory.a(Items.ARROW);
				            }
				            
				            // CraftBukkit end

				            itemstack.damage(1, entityhuman);
				            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (ItemBow.g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				            if (flag) {
				                entityarrow.fromPlayer = 2;
				            }


				            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
				            if (!world.isClientSide) {
				                // world.addEntity(entityarrow); // CraftBukkit - moved up
				            }    
						}
					}
				}
			}
    	} 
		if (flag || entityhuman.inventory.b(Items.ARROWPOISON)) {
			if (!(entityhuman.inventory.b(Items.ARROWFORCE))) {
				if (!(entityhuman.inventory.b(Items.ARROWLENTEUR))) {
					if (!(entityhuman.inventory.b(Items.ARROW))) {
						if (!(entityhuman.inventory.b(Items.ARROWSPEED))) 
						{
							int j = this.d(itemstack) - i;
				            float f = (float) j / 20.0F;

				            f = (f * f + f * 2.0F) / 3.0F;
				            if ((double) f < 0.1D) {
				                return;
				            }

				            if (f > 1.0F) {
				                f = 1.0F;
				            }

				            EntityArrowPoison entityarrow = new EntityArrowPoison(world, entityhuman, f * 2.0F);

				            if (f == 1.0F) {
				                entityarrow.setCritical(true);
				            }

				            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

				            if (k > 0) {
				                entityarrow.b(entityarrow.j() + (double) k * 0.5D + 0.5D);
				            }

				            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

				            if (l > 0) {
				                entityarrow.setKnockbackStrength(l);
				            }

				            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
				                // CraftBukkit start - call EntityCombustEvent
				                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
				                entityarrow.world.getServer().getPluginManager().callEvent(event);

				                if (!event.isCancelled()) {
				                    entityarrow.setOnFire(event.getDuration());
				                }
				                // CraftBukkit end
				            }

				            // CraftBukkit start
				            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEventPOISON(entityhuman, itemstack, entityarrow, f);
				            if (event.isCancelled()) {
				                event.getProjectile().remove();
				                return;
				            }

				            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
				                world.addEntity(entityarrow);
				            }
				            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack);

				            if (inf > 0) 
				            {
				            	entityarrow.fromPlayer = 2;
				            } 
				            else
				            {
				            	entityhuman.inventory.a(Items.ARROWPOISON);
				            }
				            
				            // CraftBukkit end

				            itemstack.damage(1, entityhuman);
				            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (ItemBow.g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				            if (flag) {
				                entityarrow.fromPlayer = 2;
				            }

				            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
				            if (!world.isClientSide) {
				                // world.addEntity(entityarrow); // CraftBukkit - moved up
				            }    
						}
					}
				}
			}
		}
		if (flag || entityhuman.inventory.b(Items.ARROWFORCE)) {
			if (!(entityhuman.inventory.b(Items.ARROWPOISON))) {
				if (!(entityhuman.inventory.b(Items.ARROWLENTEUR))) {
					if (!(entityhuman.inventory.b(Items.ARROW))) {
						if (!(entityhuman.inventory.b(Items.ARROWSPEED))) 
						{
							int j = this.d(itemstack) - i;
				            float f = (float) j / 20.0F;

				            f = (f * f + f * 2.0F) / 3.0F;
				            if ((double) f < 0.1D) {
				                return;
				            }

				            if (f > 1.0F) {
				                f = 1.0F;
				            }

				            EntityArrowForce entityarrow = new EntityArrowForce(world, entityhuman, f * 2.0F);

				            if (f == 1.0F) {
				                entityarrow.setCritical(true);
				            }

				            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

				            if (k > 0) {
				                entityarrow.b(entityarrow.j() + (double) k * 0.5D + 0.5D);
				            }

				            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

				            if (l > 0) {
				                entityarrow.setKnockbackStrength(l);
				            }

				            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
				                // CraftBukkit start - call EntityCombustEvent
				                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
				                entityarrow.world.getServer().getPluginManager().callEvent(event);

				                if (!event.isCancelled()) {
				                    entityarrow.setOnFire(event.getDuration());
				                }
				                // CraftBukkit end
				            }

				            // CraftBukkit start
				            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEventFORCE(entityhuman, itemstack, entityarrow, f);
				            if (event.isCancelled()) {
				                event.getProjectile().remove();
				                return;
				            }

				            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
				                world.addEntity(entityarrow);
				            }
				            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack);

				            if (inf > 0) 
				            {
				            	entityarrow.fromPlayer = 2;
				            } 
				            else
				            {
				            	entityhuman.inventory.a(Items.ARROWFORCE);
				            }
				            
				            // CraftBukkit end

				            itemstack.damage(1, entityhuman);
				            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (ItemBow.g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				            if (flag) {
				                entityarrow.fromPlayer = 2;
				            }

				            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
				            if (!world.isClientSide) {
				                // world.addEntity(entityarrow); // CraftBukkit - moved up
				            }    
						}
					}
				}
			}
		}
		if (flag || entityhuman.inventory.b(Items.ARROWSPEED)) {
			if (!(entityhuman.inventory.b(Items.ARROWPOISON))) {
				if (!(entityhuman.inventory.b(Items.ARROWFORCE))) {
					if (!(entityhuman.inventory.b(Items.ARROW))) {
						if (!(entityhuman.inventory.b(Items.ARROWLENTEUR))) 
						{
							int j = this.d(itemstack) - i;
				            float f = (float) j / 20.0F;

				            f = (f * f + f * 2.0F) / 3.0F;
				            if ((double) f < 0.1D) {
				                return;
				            }

				            if (f > 1.0F) {
				                f = 1.0F;
				            }

				            EntityArrowSpeed entityarrow = new EntityArrowSpeed(world, entityhuman, f * 2.0F);

				            if (f == 1.0F) {
				                entityarrow.setCritical(true);
				            }

				            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

				            if (k > 0) {
				                entityarrow.b(entityarrow.j() + (double) k * 0.5D + 0.5D);
				            }

				            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

				            if (l > 0) {
				                entityarrow.setKnockbackStrength(l);
				            }

				            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
				                // CraftBukkit start - call EntityCombustEvent
				                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
				                entityarrow.world.getServer().getPluginManager().callEvent(event);

				                if (!event.isCancelled()) {
				                    entityarrow.setOnFire(event.getDuration());
				                }
				                // CraftBukkit end
				            }

				            // CraftBukkit start
				            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEventSPEED(entityhuman, itemstack, entityarrow, f);
				            if (event.isCancelled()) {
				                event.getProjectile().remove();
				                return;
				            }

				            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
				                world.addEntity(entityarrow);
				            }
				            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack);

				            if (inf > 0) 
				            {
				            	entityarrow.fromPlayer = 2;
				            } 
				            else
				            {
				            	entityhuman.inventory.a(Items.ARROWSPEED);
				            }

				            itemstack.damage(1, entityhuman);
				            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (ItemBow.g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				            if (flag) {
				                entityarrow.fromPlayer = 2;
				            }

				            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
				            if (!world.isClientSide) {
				                // world.addEntity(entityarrow); // CraftBukkit - moved up
				            }    
						}
					}
				}
			}
		}
		if (flag || entityhuman.inventory.b(Items.ARROWLENTEUR)) {
			if (!(entityhuman.inventory.b(Items.ARROWPOISON))) {
				if (!(entityhuman.inventory.b(Items.ARROWFORCE))) {
					if (!(entityhuman.inventory.b(Items.ARROW))) {
						if (!(entityhuman.inventory.b(Items.ARROWSPEED))) 
						{
							int j = this.d(itemstack) - i;
				            float f = (float) j / 20.0F;

				            f = (f * f + f * 2.0F) / 3.0F;
				            if ((double) f < 0.1D) {
				                return;
				            }

				            if (f > 1.0F) {
				                f = 1.0F;
				            }

				            EntityArrowLenteur entityarrow = new EntityArrowLenteur(world, entityhuman, f * 2.0F);

				            if (f == 1.0F) {
				                entityarrow.setCritical(true);
				            }

				            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

				            if (k > 0) {
				                entityarrow.b(entityarrow.j() + (double) k * 0.5D + 0.5D);
				            }

				            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

				            if (l > 0) {
				                entityarrow.setKnockbackStrength(l);
				            }

				            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
				                // CraftBukkit start - call EntityCombustEvent
				                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
				                entityarrow.world.getServer().getPluginManager().callEvent(event);

				                if (!event.isCancelled()) {
				                    entityarrow.setOnFire(event.getDuration());
				                }
				                // CraftBukkit end
				            }

				            // CraftBukkit start
				            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEventLENTEUR(entityhuman, itemstack, entityarrow, f);
				            if (event.isCancelled()) {
				                event.getProjectile().remove();
				                return;
				            }

				            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
				                world.addEntity(entityarrow);
				            }
				            int inf = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack);

				            if (inf > 0) 
				            {
				            	entityarrow.fromPlayer = 2;
				            } 
				            else
				            {
				            	entityhuman.inventory.a(Items.ARROWLENTEUR);
				            }
				            
				            // CraftBukkit end

				            itemstack.damage(1, entityhuman);
				            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (ItemBow.g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				            if (flag) {
				                entityarrow.fromPlayer = 2;
				            }
				            //} else {
				            //    entityhuman.inventory.a(Items.ARROW);
				            //}

				            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
				            if (!world.isClientSide) {
				                // world.addEntity(entityarrow); // CraftBukkit - moved up
				            }    
						}
					}
				}
			}
		}
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 72000;
    }

    public EnumAnimation e(ItemStack itemstack) {
        return EnumAnimation.BOW;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
       
    	if (entityhuman.abilities.canInstantlyBuild 
        		|| entityhuman.inventory.b(Items.ARROW)
        		|| entityhuman.inventory.b(Items.ARROWFORCE)
        		|| entityhuman.inventory.b(Items.ARROWSPEED)
        		|| entityhuman.inventory.b(Items.ARROWPOISON)
        		|| entityhuman.inventory.b(Items.ARROWLENTEUR)) 
            
        	entityhuman.a(itemstack, this.d(itemstack));

        return itemstack;
    }

    public int b() {
        return 1;
    }
}
