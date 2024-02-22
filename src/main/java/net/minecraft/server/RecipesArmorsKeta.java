package net.minecraft.server;

public class RecipesArmorsKeta {
	
    private String[][] a = new String[][] { { "XXX", "X X"}, { "X X", "XXX", "XXX"}, { "XXX", "X X", "X X"}, { "X X", "X X"}};
    private Object[][] b;

    public RecipesArmorsKeta() {
    	/** KetaminePVP  */
        this.b = new Object[][] { {Items.MDMA, Items.TIKETA, Items.TICOKE, Items.TIMDMA, Items.TISUP}, 
        		{ Items.MD_HELMET, Items.TIKETA_HELMET, Items.TICOKE_HELMET, Items.TIMDMA_HELMET, Items.TISUP_HELMET}, 
        		{ Items.MD_CHESTPLATE, Items.TIKETA_CHESTPLATE, Items.TICOKE_CHESTPLATE, Items.TIMDMA_CHESTPLATE, Items.TIMDMA_CHESTPLATE}, 
        		{ Items.MD_LEGGINGS, Items.TIKETA_LEGS, Items.TICOKE_LEGS, Items.TIMDMA_LEGS, Items.TISUP_LEGS}, 
        		{ Items.MD_BOOTS, Items.TIKETA_BOOTS, Items.TICOKE_BOOTS, Items.TIMDMA_BOOTS, Items.TISUP_BOOTS}};
    }

    public void a(CraftingManagerKeta craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('X'), object});
            }
        }
    }
}
