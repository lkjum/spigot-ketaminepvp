package net.minecraft.server;

public class ItemSnort extends Item {

    public final int a;
    private final int b;
    private final float c;
    private final boolean d;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private float o;

    public ItemSnort(int i, float f, boolean flag) {
        this.a = 7;
        this.b = i;
        this.d = flag;
        this.c = f;
        this.a(CreativeModeTab.h);
    }

    public ItemSnort(int i, boolean flag) {
        this(i, 0.6F, flag);
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        --itemstack.count;
        entityhuman.getFoodData().a(this, itemstack);
        world.makeSound(entityhuman, "ketamine.trace", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        this.c(itemstack, world, entityhuman);
        entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
        return itemstack;
    }

    protected void c(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!world.isClientSide && this.l > 0 && world.random.nextFloat() < this.o) {
            entityhuman.addEffect(new MobEffect(this.l, this.m * 20, this.n));
        }

    }

    public int d(ItemStack itemstack) {
        return 7;
    }

    public EnumAnimation e(ItemStack itemstack) {
        return EnumAnimation.SNORT;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.j(this.k)) {
            entityhuman.a(itemstack, this.d(itemstack));
        }

        return itemstack;
    }

    public int getNutrition(ItemStack itemstack) {
        return this.b;
    }

    public float getSaturationModifier(ItemStack itemstack) {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public ItemSnort a(int i, int j, int k, float f) {
        this.l = i;
        this.m = j;
        this.n = k;
        this.o = f;
        return this;
    }

    public ItemSnort h() {
        this.k = true;
        return this;
    }
}
