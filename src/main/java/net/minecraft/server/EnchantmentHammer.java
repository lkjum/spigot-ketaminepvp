package net.minecraft.server;


public class EnchantmentHammer extends Enchantment {

    protected EnchantmentHammer(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.HAMMER);
        this.c("farm_loot");
    }

    public int a(int i) {
        return 15;
    }

    public int b(int i) {
        return super.a(i) + 50;
    }

    public int getMaxLevel() {
        return 1;
    }
    public boolean canEnchant(ItemStack itemstack) {
        return itemstack.getItem() == Items.ITEM_MULTIPICK ? true : super.canEnchant(itemstack);
    }
}
