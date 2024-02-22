package net.minecraft.server;

public class RecipesWeapons {

    private String[][] a = new String[][] { { "X", "X", "#"}};
    private Object[][] b;

    public RecipesWeapons() {
    	/** KETAMINEPVP */
        this.b = new Object[][] { { Blocks.PLANKS, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT, Items.KETAMINERAI, Items.PAIN2C, Items.BITCOIN, Items.DARK_BITCOIN, Items.TITANE, Items.DARK_BITCOIN}, 
        		{ Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, Items.KETASWORD, Items.COKE_SWORD, Items.BITCOIN_SWORD, Items.DARK_SWORD, Items.TITANE_SWORD, Items.DARK_SWORD}};
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), object});
            }
        }

        craftingmanager.registerShapedRecipe(new ItemStack(Items.BOW, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Items.STRING, Character.valueOf('#'), Items.STICK});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.AMMO, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.IRON_NUGGET, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.GUNPOWDER});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROW, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROWFORCE, 2), new Object[] { " X ", "F#S", " Y ", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK, Character.valueOf('F'), Items.BLAZE_POWDER, Character.valueOf('S'), Items.SHEITANITE});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROWSPEED, 2), new Object[] { " X ", "F#S", " Y ", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK, Character.valueOf('F'), Items.COCAINE, Character.valueOf('S'), Items.EXTCRACK});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROWPOISON, 2), new Object[] { " X ", "F#S", " Y ", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK, Character.valueOf('F'), Items.SPIDER_EYE, Character.valueOf('S'), Items.EMERALD});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROWLENTEUR, 2), new Object[] { " X ", "F#S", " Y ", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK, Character.valueOf('F'), Items.BEUH, Character.valueOf('S'), Items.IRON_INGOT});
    }
}