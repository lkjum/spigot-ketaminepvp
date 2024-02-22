package net.minecraft.server;

// CraftBukkit end

public class EntityBear extends EntityMonster {

    public EntityBear(World world) {
        super(world);
        this.setSize(1.3F, 1.4F);
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
        this.goalSelector.a(3, new PathfinderGoalTempt(this, 1.25D, Items.CRYSTALMETH, false));
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(2, new EntityBear.PathfinderGoalBearMeleeAttack(this, EntityHuman.class));
        this.targetSelector.a(2, new EntityBear.PathfinderGoalSpiderNearestAttackableTarget(this, EntityHuman.class));
        this.n();
    }
    protected void n() {
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityVillager.class, 1.0D, true)); // Spigot
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityIronGolem.class, 1.0D, true));
        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true, new Class[] { EntityPigZombie.class}));
    }
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(30.0D);
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.25);
        this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(6.0D);
    }

    protected void h() {
        super.h();
        this.getDataWatcher().a(12, Byte.valueOf((byte) 0));
        this.getDataWatcher().a(13, Byte.valueOf((byte) 0));
        this.getDataWatcher().a(14, Byte.valueOf((byte) 0));
    }

    protected float bB() {
        return 0.4F;
    }

    public EnumMonsterType getMonsterType() {
        return EnumMonsterType.UNDEAD;
    }
    protected Item getLoot() {
        return Items.CRYSTALMETH;
    }

    protected void dropDeathLoot(boolean flag, int i) {
        int j = this.random.nextInt(3) + this.random.nextInt(1 + i);

        int k;

        for (k = 0; k < j; ++k) {
            this.a(Items.EXTCRACK, 1);
        }

        j = this.random.nextInt(3) + 1 + this.random.nextInt(1 + i);

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
                this.a(Items.COOKED_BEEF, 1);
            } else {
                this.a(Items.EXTKETA, 1);
            }
        }

    }
    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }
    public float getHeadHeight() {
        return this.length;
    }
    static class PathfinderGoalBearMeleeAttack extends PathfinderGoalMeleeAttack {

        public PathfinderGoalBearMeleeAttack(EntityBear entityspider, Class<? extends Entity> oclass) {
            super(entityspider, oclass, 1.0D, true);
        }

        public boolean b() {
            float f = this.b.c(1.0F);

            if (f >= 0.5F && this.b.bc().nextInt(100) == 0) {
                this.b.setGoalTarget((EntityLiving) null);
                return false;
            } else {
                return super.b();
            }
        }

        protected double a(EntityLiving entityliving) {
            return (double) (4.0F + entityliving.width);
        }
    }
    static class PathfinderGoalSpiderNearestAttackableTarget<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget {

        public PathfinderGoalSpiderNearestAttackableTarget(EntityBear entityspider, Class<T> oclass) {
            super(entityspider, oclass, true);
        }

        public boolean a() {
            float f = this.e.c(1.0F);

            return f >= 0.5F ? false : super.a();
        }
    }

}
