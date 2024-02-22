package net.minecraft.server;

public class RecipesToolsKeta {

    private String[][] a = new String[][] { { "XXX", " # ", " # "}, { "X", "#", "#"}, { "XX", "X#", " #"}, { "XX", " #", " #"}};
    private Object[][] b;

    public RecipesToolsKeta() {
        this.b = new Object[][] { {Items.MDMA}, 
        		{ Items.MD_PICKAXE}, 
        		{ Items.MD_SHOVEL}, 
        		{ Items.MD_AXE}, 
        		{ Items.MD_HOE}};
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
