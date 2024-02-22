package net.minecraft.server;

public class EnchantmentTrama extends Enchantment {

    private static final String[] E = new String[] { "trama"};
    private final int pt;
    private static final int[] F = new int[] { 1, 5, 5};
    private static final int[] G = new int[] { 11, 8, 8};
    private static final int[] H = new int[] { 20, 20, 20};
    
    public EnchantmentTrama(int i, MinecraftKey minecraftkey, int j, int k) {
        super(i, minecraftkey, j, EnchantmentSlotType.ARMOR);
        this.pt = k;
        this.name = "trama";
      }

    public int a(int i) {
        return EnchantmentTrama.F[this.pt] + (i - 1) * EnchantmentTrama.G[this.pt];
    }

    public int b(int i) {
        return this.a(i) + EnchantmentTrama.H[this.pt];
    }

    public int getMaxLevel() {
        return 3;
    }

    public int a(int i, DamageSource damagesource) {
        if (damagesource.ignoresInvulnerability()) {
            return 0;
        } else {
            float f = (float) (6 + i * i) / 3.0F;

            return this.pt == 0 ? MathHelper.d(f * 0.25F) : 
            		(this.pt == 0 && damagesource == DamageSource.FALL ? MathHelper.d(f * 3.0F) :
                    	(this.pt == 0 && damagesource.isMagic() ? MathHelper.d(f * 3.5F) : 0));
        }
    }

    public String a() {
        return "enchantment.protect." + EnchantmentTrama.E[this.pt];
    }

    public boolean a(Enchantment enchantment) {
        return !(enchantment instanceof EnchantmentTrama);
    }

}
