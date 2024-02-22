package net.minecraft.server;

public class RecipesWeaponsKeta {

    private String[][] a = new String[][] { { "X", "X", "#"}};
    private Object[][] b;

    public RecipesWeaponsKeta() {
    	/** KetaminePvP */
        this.b = new Object[][] { {Items.MDMA, Items.TIKETA, Items.TICOKE, Items.TIMDMA, Items.TISUP}, 
        		{ Items.MD_SWORD, Items.TIKETA_SWORD, Items.TICOKE_SWORD, Items.TIMDMA_SWORD, Items.TISUP_SWORD}};
    }

    public void a(CraftingManagerKeta craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), object});
            }
        }

        
    }
}
