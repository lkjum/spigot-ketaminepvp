package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Dauphin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import net.minecraft.server.EntityDofin;

public class CraftDauphin extends CraftWaterMob implements Dauphin {

    public CraftDauphin(CraftServer server, EntityDofin entity) {
        super(server, entity);
    }

    @Override
    public EntityDofin getHandle() {
        return (EntityDofin) entity;
    }

    @Override
    public String toString() {
        return "CraftDauphin";
    }

    public EntityType getType() {
        return EntityType.DAUPHIN;
    }

	@Override
	public boolean canBreed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAgeLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdult() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdult() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAge(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAgeLock(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBaby() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBreed(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LivingEntity getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTarget(LivingEntity arg0) {
		// TODO Auto-generated method stub
		
	}
}
