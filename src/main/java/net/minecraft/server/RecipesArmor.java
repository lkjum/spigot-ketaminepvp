package net.minecraft.server;

public class RecipesArmor {

    private String[][] a = new String[][] { { "XXX", "X X"}, { "X X", "XXX", "XXX"}, { "XXX", "X X", "X X"}, { "X X", "X X"}};
    private Object[][] b;

    public RecipesArmor() {
    	/** KetaminePVP  */
        this.b = new Object[][] { { Items.LEATHER, Blocks.FIRE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT, Items.KETAMINERAI, Items.PAIN2C, Items.BITCOIN, Items.TITANE, Items.DARK_BITCOIN}, 
        		{ Items.LEATHER_HELMET, Items.CHAINMAIL_HELMET, Items.IRON_HELMET, Items.DIAMOND_HELMET, Items.GOLDEN_HELMET, Items.KETACASQUE, Items.COKE_HELMET, Items.BITCOIN_HELMET, Items.TITANE_HELMET, Items.DARK_HELMET}, 
        		{ Items.LEATHER_CHESTPLATE, Items.CHAINMAIL_CHESTPLATE, Items.IRON_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.GOLDEN_CHESTPLATE, Items.KETAPLAQUE, Items.COKE_CHESTPLATE, Items.BITCOIN_CHESTPLATE, Items.TITANE_CHESTPLATE, Items.DARK_CHESTPLATE}, 
        		{ Items.LEATHER_LEGGINGS, Items.CHAINMAIL_LEGGINGS, Items.IRON_LEGGINGS, Items.DIAMOND_LEGGINGS, Items.GOLDEN_LEGGINGS, Items.KETAPANTS, Items.COKE_LEGS, Items.BITCOIN_LEGGINGS, Items.TITANE_LEGS, Items.DARK_LEGS}, 
        		{ Items.LEATHER_BOOTS, Items.CHAINMAIL_BOOTS, Items.IRON_BOOTS, Items.DIAMOND_BOOTS, Items.GOLDEN_BOOTS, Items.KETABOOTS, Items.COKE_BOOTS, Items.BITCOIN_BOOTS, Items.TITANE_BOOTS, Items.DARK_BOOTS}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('X'), object});
            }
        }
    }
}