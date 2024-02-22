package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.craftbukkit.event.CraftEventFactory; // CraftBukkit

@SuppressWarnings("unchecked")
public class CraftingManagerKeta {

    private static final CraftingManagerKeta a = new CraftingManagerKeta();
    public List<IRecipe> recipes = Lists.newArrayList();
    // CraftBukkit start
    public IRecipe lastRecipe;
    public org.bukkit.inventory.InventoryView lastCraftView;
    // CraftBukkit end

    public static CraftingManagerKeta getInstance() {
        return CraftingManagerKeta.a;
    }

    public CraftingManagerKeta() {
    	 (new RecipesToolsKeta()).a(this);
         (new RecipesWeaponsKeta()).a(this);
         (new RecipesArmorsKeta()).a(this);
         
         this.registerShapedRecipe(new ItemStack(Items.MD_POUDRE , 9), new Object[] {"#", '#', Items.MDMA});
         this.registerShapedRecipe(new ItemStack(Items.SUP_NUGGET , 9), new Object[] {"#", '#', Items.TISUP});
         this.registerShapedRecipe(new ItemStack(Items.MDMA), new Object[] {"###", "###", "###", '#', Items.MD_POUDRE});
         this.registerShapedRecipe(new ItemStack(Items.MD_POUDRE, 1), new Object[] {"#I#", "#I#", "ABC", '#', Items.BICARBONATE, 'I', Items.CRYSTALMETH, 'A', Items.LAVA_BUCKET, 'B', Items.PLAQUE, 'C', Items.WATER_BUCKET});
         this.registerShapedRecipe(new ItemStack(Items.PLAQUE), new Object[] {"###", '#', Items.TITANE_NUGGET});
         this.registerShapedRecipe(new ItemStack(Items.TISUP), new Object[] {"###", "###", "###", '#', Items.SUP_NUGGET});
         this.registerShapedRecipe(new ItemStack(Items.TAZ_GOLD, 1), new Object[] {"# #", "#E#", "# #",  'E', new ItemStack(Items.DYE, 4, EnumColor.YELLOW.getColorIndex()), '#', Items.MD_POUDRE});
         this.registerShapedRecipe(new ItemStack(Items.TAZ_SUPERMAN, 1), new Object[] {"# #", "#E#", "# #",  'E', new ItemStack(Items.DYE, 14, EnumColor.RED.getColorIndex()), '#', Items.MD_POUDRE});
         this.registerShapedRecipe(new ItemStack(Items.TAZ_DOMINO, 1), new Object[] {"# #", "#E#", "# #",  'E', new ItemStack(Items.DYE, 0, EnumColor.WHITE.getColorIndex()), '#', Items.MD_POUDRE});
         this.registerShapedRecipe(new ItemStack(Items.TAZ_MITSU, 1), new Object[] {"# #", "#E#", "# #",  'E', new ItemStack(Items.DYE, 11, EnumColor.LIGHT_BLUE.getColorIndex()), '#', Items.MD_POUDRE});
         this.registerShapedRecipe(new ItemStack(Items.TIKETA, 1), new Object[] {"###","#T#","###", '#', Items.KETAMINERAI, 'T', new ItemStack(Items.FIOLE5L, 1, 4)});
         this.registerShapedRecipe(new ItemStack(Items.TICOKE, 1), new Object[] {"###","#T#","###", '#', Items.PAIN2C, 'T', new ItemStack(Items.FIOLE5L, 1, 4)});
         this.registerShapedRecipe(new ItemStack(Items.TIMDMA, 1), new Object[] {"###","#T#","###", '#', Items.MDMA, 'T', new ItemStack(Items.FIOLE5L, 1, 4)});
         //this.registerShapedRecipe(new ItemStack(Blocks.ANVILOP), new Object[] {"#I#", " # ", "###", 'I', Blocks.TITANE_BLOCK, '#', Blocks.BICAR_BLOCK});
         this.registerShapedRecipe(new ItemStack(Items.TISUP, 1), new Object[] {"K C","#T#", "M M", '#', new ItemStack(Blocks.TITANE_BLOCK, 1, 0), 'T', new ItemStack(Items.FIOLE5L, 1, 4), 'C', Items.TICOKE, 'K', Items.TIKETA, 'M', Items.TIMDMA});
         this.registerShapedRecipe(new ItemStack(Items.FIOLE5L, 1, 4), new Object[] {"HHH", "BFB", " B ", 'H', Items.TITANE, 'B', Items.BICARBONATE, 'F', new ItemStack(Items.FIOLE5L, 1, 0)});
         this.registerShapedRecipe(new ItemStack(Items.ITEM_MULTI, 1), new Object [] {"###", "#S ", " S ", '#' , Items.TITANE, 'S', Items.TITANE_STICK});
         //this.registerShapedRecipe(new ItemStack(Items.ITEM_MULTI, 1), new Object [] {"###", " S#", " S ", '#' , Items.TITANE, 'S', Items.TITANE_STICK});
         this.registerShapedRecipe(new ItemStack(Items.ITEM_FARMING, 1), new Object [] {"#S#", "#S ", " S ", '#', Items.BITCOIN, 'S', Items.TITANE_STICK});
         this.registerShapedRecipe(new ItemStack(Items.ITEM_FARMOUZ, 1), new Object [] {"#S#", "#S ", " S ", '#', Blocks.EMERALD_BLOCK, 'S', Items.TITANE_STICK});
         this.registerShapedRecipe(new ItemStack(Items.ITEM_FARMSEED, 1), new Object [] {"#S#", "#S ", " S ", '#', Items.MDMA, 'S', Items.TITANE_STICK});
         this.registerShapedRecipe(new ItemStack(Items.ITEM_MULTIPICK, 1), new Object [] {"###", "NSN", " S ", '#', Blocks.SHEITAN_BLOCK, 'S', Items.TITANE_STICK, 'N', Items.TITANE_NUGGET});
         this.registerShapedRecipe(new ItemStack(Items.DAGUE_DIABLE, 1), new Object [] {" # ", " # ", " S ", '#', Items.SHEITANITE, 'S', Items.TITANE_STICK});
         sort();
    }
    public void sort() {
        Collections.sort(this.recipes, new Comparator() {
             public int a(IRecipe irecipe, IRecipe irecipe1) {
                 return irecipe instanceof ShapelessRecipes && irecipe1 instanceof ShapedRecipes ? 1 : (irecipe1 instanceof ShapelessRecipes && irecipe instanceof ShapedRecipes ? -1 : (irecipe1.a() < irecipe.a() ? -1 : (irecipe1.a() > irecipe.a() ? 1 : 0)));
             }

             public int compare(Object object, Object object1) {
                 return this.a((IRecipe) object, (IRecipe) object1);
             }
         });
     }

     public ShapedRecipes registerShapedRecipe(ItemStack itemstack, Object... aobject) {
         String s = "";
         int i = 0;
         int j = 0;
         int k = 0;

         if (aobject[i] instanceof String[]) {
             String[] astring = (String[]) ((String[]) aobject[i++]);

             for (int l = 0; l < astring.length; ++l) {
                 String s1 = astring[l];

                 ++k;
                 j = s1.length();
                 s = s + s1;
             }
         } else {
             while (aobject[i] instanceof String) {
                 String s2 = (String) aobject[i++];

                 ++k;
                 j = s2.length();
                 s = s + s2;
             }
         }

         HashMap hashmap;

         for (hashmap = Maps.newHashMap(); i < aobject.length; i += 2) {
             Character character = (Character) aobject[i];
             ItemStack itemstack1 = null;

             if (aobject[i + 1] instanceof Item) {
                 itemstack1 = new ItemStack((Item) aobject[i + 1]);
             } else if (aobject[i + 1] instanceof Block) {
                 itemstack1 = new ItemStack((Block) aobject[i + 1], 1, 32767);
             } else if (aobject[i + 1] instanceof ItemStack) {
                 itemstack1 = (ItemStack) aobject[i + 1];
             }

             hashmap.put(character, itemstack1);
         }

         ItemStack[] aitemstack = new ItemStack[j * k];

         for (int i1 = 0; i1 < j * k; ++i1) {
             char c0 = s.charAt(i1);

             if (hashmap.containsKey(Character.valueOf(c0))) {
                 aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).cloneItemStack();
             } else {
                 aitemstack[i1] = null;
             }
         }

         ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, itemstack);

         this.recipes.add(shapedrecipes);
         return shapedrecipes;
     }

     public void registerShapelessRecipe(ItemStack itemstack, Object... aobject) {
         ArrayList arraylist = Lists.newArrayList();
         Object[] aobject1 = aobject;
         int i = aobject.length;

         for (int j = 0; j < i; ++j) {
             Object object = aobject1[j];

             if (object instanceof ItemStack) {
                 arraylist.add(((ItemStack) object).cloneItemStack());
             } else if (object instanceof Item) {
                 arraylist.add(new ItemStack((Item) object));
             } else {
                 if (!(object instanceof Block)) {
                     throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                 }

                 arraylist.add(new ItemStack((Block) object));
             }
         }

         this.recipes.add(new ShapelessRecipes(itemstack, arraylist));
     }

     public void a(IRecipe irecipe) {
         this.recipes.add(irecipe);
     }

     public ItemStack craft(InventoryCrafting inventorycrafting, World world) {
         Iterator iterator = this.recipes.iterator();

         IRecipe irecipe;

         do {
             if (!iterator.hasNext()) {
                 inventorycrafting.currentRecipe = null; // CraftBukkit - Clear recipe when no recipe is found
                 return null;
             }

             irecipe = (IRecipe) iterator.next();
         } while (!irecipe.a(inventorycrafting, world));

         // CraftBukkit start - INVENTORY_PRE_CRAFT event
         inventorycrafting.currentRecipe = irecipe;
         ItemStack result = irecipe.craftItem(inventorycrafting);
         return CraftEventFactory.callPreCraftEvent(inventorycrafting, result, lastCraftView, false);
         // CraftBukkit end
     }

     public ItemStack[] b(InventoryCrafting inventorycrafting, World world) {
         Iterator iterator = this.recipes.iterator();

         while (iterator.hasNext()) {
             IRecipe irecipe = (IRecipe) iterator.next();

             if (irecipe.a(inventorycrafting, world)) {
                 return irecipe.b(inventorycrafting);
             }
         }

         ItemStack[] aitemstack = new ItemStack[inventorycrafting.getSize()];

         for (int i = 0; i < aitemstack.length; ++i) {
             aitemstack[i] = inventorycrafting.getItem(i);
         }

         return aitemstack;
     }

     public List<IRecipe> getRecipes() {
         return this.recipes;
     }
 }

    