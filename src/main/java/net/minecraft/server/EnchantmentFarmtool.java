package net.minecraft.server;

public class EnchantmentFarmtool extends Enchantment {

    protected EnchantmentFarmtool(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.FARMTOOL);
        this.c("farm_loot");
    }

    public int a(int i) {
        return 10;
    }

    public int b(int i) {
        return super.a(i) + 50;
    }

    public int getMaxLevel() {
        return 1;
    }
    public boolean canEnchant(ItemStack itemstack) {
        return itemstack.getItem() == Items.ITEM_FARMING ? true : super.canEnchant(itemstack);
    }
}
