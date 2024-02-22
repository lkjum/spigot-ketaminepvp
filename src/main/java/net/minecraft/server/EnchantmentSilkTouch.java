package net.minecraft.server;

public class EnchantmentSilkTouch extends Enchantment {

    protected EnchantmentSilkTouch(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.SILK);
        this.c("untouching");
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

    public boolean a(Enchantment enchantment) {
        return super.a(enchantment) && enchantment.id != EnchantmentSilkTouch.LOOT_BONUS_BLOCKS.id;
    }

    public boolean canEnchant(ItemStack itemstack) {
        //return itemstack.getItem() == Items.SHEARS ? true : super.canEnchant(itemstack);
    	return itemstack.getItem() instanceof ItemTool ? true : 
    		itemstack.getItem() instanceof ItemFarm ? true : 
    		super.canEnchant(itemstack);
    }
}