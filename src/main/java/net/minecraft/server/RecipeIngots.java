package net.minecraft.server;

public class RecipeIngots
{
  private Object[][] a = { { Blocks.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9) },
		  { Blocks.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9) }, 
		  { Blocks.DIAMOND_BLOCK, new ItemStack(Items.DIAMOND, 9) }, 
		  { Blocks.EMERALD_BLOCK, new ItemStack(Items.EMERALD, 9) }, 
		  { Blocks.LAPIS_BLOCK, new ItemStack(Items.DYE, 9, EnumColor.BLUE.getInvColorIndex()) }, 
		  { Blocks.REDSTONE_BLOCK, new ItemStack(Items.REDSTONE, 9) }, 
		  { Blocks.COAL_BLOCK, new ItemStack(Items.COAL, 9, 0) }, 
		  { Blocks.HAY_BLOCK, new ItemStack(Items.WHEAT, 9) }, 
		  { Blocks.SLIME, new ItemStack(Items.SLIME, 9) },
  		{ Blocks.COKE_BLOCK, new ItemStack(Items.PAIN2C, 9, 0)}, 
  		{ Blocks.KETA_BLOCK, new ItemStack(Items.KETAMINERAI, 9, 0)},
  		{ Blocks.BICAR_BLOCK, new ItemStack(Items.BICARBONATE, 9, 0)},
  		{ Blocks.SHEITAN_BLOCK, new ItemStack(Items.SHEITANITE, 9, 0)},
  		{ Blocks.TITANE_BLOCK, new ItemStack(Items.TITANE, 9, 0)}};


  public void a(CraftingManager paramCraftingManager)
  {
    for (int i = 0; i < this.a.length; i++) {
      Block localBlock = (Block)this.a[i][0];
      ItemStack localItemStack = (ItemStack)this.a[i][1];
      paramCraftingManager.registerShapedRecipe(new ItemStack(localBlock), new Object[] { "###", "###", "###", Character.valueOf('#'), localItemStack });

      paramCraftingManager.registerShapedRecipe(localItemStack, new Object[] { "#", Character.valueOf('#'), localBlock });
    }

    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.GOLD_INGOT), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.GOLD_NUGGET });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.GOLD_NUGGET, 9), new Object[] { "#", Character.valueOf('#'), Items.GOLD_INGOT });
    //KETAMINE PVP WALRUS LKJUM
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.IRON_INGOT), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.IRON_NUGGET });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.IRON_NUGGET, 9), new Object[] { "#", Character.valueOf('#'), Items.IRON_INGOT });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.EXTRAIT_BICAR, 9), new Object[] { "#", Character.valueOf('#'), Items.BICARBONATE });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.BICARBONATE), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.EXTRAIT_BICAR });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.COCAINE, 9), new Object[] { "#", Character.valueOf('#'), Items.PAIN2C });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.PAIN2C), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.COCAINE }); 
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.EXTKETA, 9), new Object[] { "#", Character.valueOf('#'), Items.KETAMINERAI });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.KETAMINERAI), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.EXTKETA }); 
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.EXTCRACK, 9), new Object[] { "#", Character.valueOf('#'), Items.CRYSTALMETH });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.CRYSTALMETH), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.EXTCRACK });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.COCA_PILED, 9), new Object[] { "#", Character.valueOf('#'), Items.COCA_STACK });
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.COCA_STACK), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.COCA_PILED});
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.CANNABIS), new Object[] {"###", "###", "###", Character.valueOf('#'), Items.BEUH});
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.TITANE), new Object[] {"###", "###", "###", Character.valueOf('#'), Items.TITANE_NUGGET});
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.TITANE_NUGGET, 9), new Object[] { "#", Character.valueOf('#'), Items.TITANE});
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.PAVOT_STACK), new Object[] {"###", "###", "###", '#', Items.PAVOT});
    paramCraftingManager.registerShapedRecipe(new ItemStack(Items.HEROINE_STACK), new Object[] {"###", "###", "###", '#', Items.HEROINE});
    //KETAMINE PVP WALRUS LKJUM
  }
}