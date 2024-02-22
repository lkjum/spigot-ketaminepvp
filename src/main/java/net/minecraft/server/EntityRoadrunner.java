package net.minecraft.server;

public class EntityRoadrunner extends EntityAnimal {

    public float bm;
    public float bo;
    public float bp;
    public float bq;
    public float br = 1.0F;
    public int bs;
    public boolean bt;

    public EntityRoadrunner(World world) {
        super(world);
        this.setSize(0.9F, 1.87F);
        this.bs = this.random.nextInt(6000) + 6000;
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 1.4D));
        this.goalSelector.a(2, new PathfinderGoalBreed(this, 1.0D));
        this.goalSelector.a(3, new PathfinderGoalTempt(this, 1.0D, Items.ACID, false));
        this.goalSelector.a(4, new PathfinderGoalFollowParent(this, 1.1D));
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    public float getHeadHeight() {
        return this.length;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(16.0D);
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.10D);
    }



    public void e(float f, float f1) {}


    protected void dropDeathLoot(boolean flag, int i) {
        int j = this.random.nextInt(3) + this.random.nextInt(1 + i);

        for (int k = 0; k < j; ++k) {
            this.a(Items.APPLE, 1);
        }

        if (this.isBurning()) {
            this.a(Items.GHAST_TEAR, 1);
        } else {
            this.a(Items.IBOGA_FRUIT, 1);
        }

    }

    public EntityRoadrunner b(EntityAgeable entityageable) {
        return new EntityRoadrunner(this.world);
    }

    public boolean d(ItemStack itemstack) {
        return itemstack != null && itemstack.getItem() == Items.COCA_SEEDS;
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.bt = nbttagcompound.getBoolean("IsChickenJockey");
        if (nbttagcompound.hasKey("EggLayTime")) {
            this.bs = nbttagcompound.getInt("EggLayTime");
        }

    }

    protected int getExpValue(EntityHuman entityhuman) {
        return this.isChickenJockey() ? 10 : super.getExpValue(entityhuman);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setBoolean("IsChickenJockey", this.bt);
        nbttagcompound.setInt("EggLayTime", this.bs);
    }

    protected boolean isTypeNotPersistent() {
        return this.isChickenJockey() && this.passenger == null;
    }

    public boolean isChickenJockey() {
        return this.bt;
    }

    public void l(boolean flag) {
        this.bt = flag;
    }

    public EntityAgeable createChild(EntityAgeable entityageable) {
        return this.b(entityageable);
    }
}