package net.minecraft.server;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EntityKetaPearl extends EntityProjectile {

    private EntityLiving c;

    public EntityKetaPearl(World world) {
        super(world);
    }

    public EntityKetaPearl(World world, EntityLiving entityliving) {
        super(world, entityliving);
        this.c = entityliving;
    }
	int genererInt(int borneInf, int borneSup)
	{
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;

	}
    protected void a(MovingObjectPosition movingobjectposition) {
        EntityLiving entityliving = this.getShooter();

        int ii = 1;
        int gg = 5;
        if (movingobjectposition.entity != null) {
            if (movingobjectposition.entity == this.c) {
                return;
            }

            movingobjectposition.entity.damageEntity(DamageSource.projectile(this, entityliving), 0.0F);
        }

        for (int i = 0; i < 32; ++i) {
            this.world.addParticle(EnumParticle.PORTAL, this.locX, this.locY + this.random.nextDouble() * 2.0D, this.locZ, this.random.nextGaussian(), 0.0D, this.random.nextGaussian(), new int[0]);
        }

        if (!this.world.isClientSide) {
            if (entityliving instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityliving;

                if (entityplayer.playerConnection.a().g() && entityplayer.world == this.world && !entityplayer.isSleeping()) {
                    // CraftBukkit start - Fire PlayerTeleportEvent
                    org.bukkit.craftbukkit.entity.CraftPlayer player = entityplayer.getBukkitEntity();
                    org.bukkit.Location location = getBukkitEntity().getLocation().add(-50, 3, 50);
                    org.bukkit.Location location2 = getBukkitEntity().getLocation().add(53, 3, -10);
                    org.bukkit.Location location3 = getBukkitEntity().getLocation().add(-80, 3, 15);
                    org.bukkit.Location location4 = getBukkitEntity().getLocation().add(63, 3, -42);
                    org.bukkit.Location location5 = getBukkitEntity().getLocation().add(-70, 3, 35);
                    location.setPitch(player.getLocation().getPitch());
                    location.setYaw(player.getLocation().getYaw());

                    location2.setPitch(player.getLocation().getPitch());
                    location2.setYaw(player.getLocation().getYaw());
                    
                    location3.setPitch(player.getLocation().getPitch());
                    location3.setYaw(player.getLocation().getYaw());
                    
                    location4.setPitch(player.getLocation().getPitch());
                    location4.setYaw(player.getLocation().getYaw());
                    
                    location5.setPitch(player.getLocation().getPitch());
                    location5.setYaw(player.getLocation().getYaw());
                    
                    PlayerTeleportEvent teleEvent = new PlayerTeleportEvent(player, player.getLocation(), location, PlayerTeleportEvent.TeleportCause.KETA_PEARL);
                    PlayerTeleportEvent teleEvent2 = new PlayerTeleportEvent(player, player.getLocation(), location2, PlayerTeleportEvent.TeleportCause.KETA_PEARL);
                    PlayerTeleportEvent teleEvent3 = new PlayerTeleportEvent(player, player.getLocation(), location3, PlayerTeleportEvent.TeleportCause.KETA_PEARL);
                    PlayerTeleportEvent teleEvent4 = new PlayerTeleportEvent(player, player.getLocation(), location4, PlayerTeleportEvent.TeleportCause.KETA_PEARL);
                    PlayerTeleportEvent teleEvent5 = new PlayerTeleportEvent(player, player.getLocation(), location5, PlayerTeleportEvent.TeleportCause.KETA_PEARL);
                    Bukkit.getPluginManager().callEvent(teleEvent);

                    if (!teleEvent.isCancelled() 
                    		|| !teleEvent2.isCancelled() || !teleEvent3.isCancelled() || !teleEvent4.isCancelled() || !teleEvent5.isCancelled()
                    		&& !entityplayer.playerConnection.isDisconnected()) 
                    {
                        if (entityliving.au()) 
                        {
                            entityliving.mount((Entity) null);
                        }
                        if (this.genererInt(ii, gg) == 1)
                        {
                        	entityplayer.playerConnection.teleport(teleEvent.getTo());
                        	entityliving.fallDistance = 0.0F;
                        	entityliving.damageEntity(DamageSource.FALL, 0.5F);
                            CraftEventFactory.entityDamage = this;
                            CraftEventFactory.entityDamage = null;
                        }
                        else if (this.genererInt(ii, gg) == 2)
                        {
                        	entityplayer.playerConnection.teleport(teleEvent2.getTo());
                        	entityliving.fallDistance = 0.0F;
                        	entityliving.damageEntity(DamageSource.FALL, 0.65F);
                            CraftEventFactory.entityDamage = this;
                            CraftEventFactory.entityDamage = null;
                        }
                        else if (this.genererInt(ii, gg) == 3)
                        {
                        	entityplayer.playerConnection.teleport(teleEvent3.getTo());
                        	entityliving.fallDistance = 0.0F;
                        	entityliving.damageEntity(DamageSource.FALL, 0.55F);
                            CraftEventFactory.entityDamage = this;
                            CraftEventFactory.entityDamage = null;
                        }
                        else if (this.genererInt(ii, gg) == 4)
                        {
                        	entityplayer.playerConnection.teleport(teleEvent4.getTo());
                        	entityliving.fallDistance = 0.0F;
                        	entityliving.damageEntity(DamageSource.FALL, 0.45F);
                            CraftEventFactory.entityDamage = this;
                            CraftEventFactory.entityDamage = null;
                        }
                        else if (this.genererInt(ii, gg) == 5)
                        {
                        	entityplayer.playerConnection.teleport(teleEvent5.getTo());
                        	entityliving.fallDistance = 0.0F;
                        	entityliving.damageEntity(DamageSource.FALL, 0.35F);
                            CraftEventFactory.entityDamage = this;
                            CraftEventFactory.entityDamage = null;
                        }
                        
                    }
                    // CraftBukkit end
                }
            } else if (entityliving != null) 
            {
                if (this.genererInt(ii, gg) == 1)
                {
                	entityliving.enderTeleportTo(this.locX - 50, this.locY + 3, this.locZ + 50);
                	entityliving.fallDistance = 0.0F;
                	entityliving.damageEntity(DamageSource.FALL, 0.5F);
                }
                else if (this.genererInt(ii, gg) == 2)
                {
                	entityliving.enderTeleportTo(this.locX + 53, this.locY + 3, this.locZ - 10);
                	entityliving.fallDistance = 0.0F;
                	entityliving.damageEntity(DamageSource.FALL, 0.65F);
                }
                else if (this.genererInt(ii, gg) == 3)
                {
                	entityliving.enderTeleportTo(this.locX - 80, this.locY + 3, this.locZ + 15);
                	entityliving.fallDistance = 0.0F;
                	entityliving.damageEntity(DamageSource.FALL, 0.55F);
                }
                else if (this.genererInt(ii, gg) == 4)
                {
                	entityliving.enderTeleportTo(this.locX + 63, this.locY + 3, this.locZ - 42);
                	entityliving.fallDistance = 0.0F;
                	entityliving.damageEntity(DamageSource.FALL, 0.45F);
                }
                else if (this.genererInt(ii, gg) == 5)
                {
                	entityliving.enderTeleportTo(this.locX - 70, this.locY + 3, this.locZ + 35);
                	entityliving.fallDistance = 0.0F;
                	entityliving.damageEntity(DamageSource.FALL, 0.35F);
                }
            }

            this.die();
        }

    }

    public void t_() {
        EntityLiving entityliving = this.getShooter();

        if (entityliving != null && entityliving instanceof EntityHuman && !entityliving.isAlive()) {
            this.die();
        } else {
            super.t_();
        }

    }
}
