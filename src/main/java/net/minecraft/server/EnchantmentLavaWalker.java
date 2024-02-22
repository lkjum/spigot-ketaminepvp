package net.minecraft.server;

public class EnchantmentLavaWalker extends Enchantment {

    public EnchantmentLavaWalker(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.ARMOR_FEET);
        this.c("lavaWalker");
    }

    public int a(int i) {
        return i * 10;
    }

    public int b(int i) {
        return this.a(i) + 15;
    }

    public int getMaxLevel() {
        return 3;
    }
}
