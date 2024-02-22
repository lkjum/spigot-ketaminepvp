package net.minecraft.server;

public class EnchantmentKhole extends Enchantment {

    private static final String[] E = new String[] { "khole"};
    private final int pt;
    private static final int[] F = new int[] { 1, 5, 5};
    private static final int[] G = new int[] { 11, 8, 8};
    private static final int[] H = new int[] { 20, 20, 20};
    public EnchantmentKhole(int i, MinecraftKey minecraftkey, int j, int k) {
        super(i, minecraftkey, j, EnchantmentSlotType.WEAPON);
        this.pt = k;
        this.name = "khole";
      }

    public int a(int i) {
        return EnchantmentKhole.F[this.pt] + (i - 1) * EnchantmentKhole.G[this.pt];
    }

    public int b(int i) {
        return this.a(i) + EnchantmentKhole.H[this.pt];
    }

    public int getMaxLevel() {
        return 4;
    }

    public float a(int i, EnumMonsterType enummonstertype) {
        return this.pt == 0 ? (float) i * 0.25F : 
        	(this.pt == 0 && enummonstertype == EnumMonsterType.UNDEAD ? (float) i * 3.0F : 
        		(this.pt == 0 && enummonstertype == EnumMonsterType.ARTHROPOD ? (float) i * 3.0F : 0.0F));
    }

    public String a() {
        return "enchantment.damage." + EnchantmentKhole.E[this.pt];
    }

    public boolean a(Enchantment enchantment) {
        return !(enchantment instanceof EnchantmentKhole);
    }

    public boolean canEnchant(ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemAxe ? true : super.canEnchant(itemstack);
    }

}
