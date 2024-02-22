package net.minecraft.server;

import com.google.common.collect.Maps;

import net.minecraft.server.ItemFish.EnumFish;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RecipesFurnace {

    private static final RecipesFurnace a = new RecipesFurnace();
    public Map recipes = Maps.newHashMap();
    private Map c = Maps.newHashMap();
    public Map customRecipes = Maps.newHashMap(); // CraftBukkit - add field

    public static RecipesFurnace getInstance() {
        return RecipesFurnace.a;
    }

    public RecipesFurnace() {
        this.registerRecipe(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.3F);
        this.registerRecipe(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0F);
        this.registerRecipe(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0F);
        this.registerRecipe(Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1F);
        this.a(Items.PORKCHOP, new ItemStack(Items.COOKED_PORKCHOP), 0.35F);
        this.a(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.35F);
        this.a(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.35F);
        this.a(Items.RABBIT, new ItemStack(Items.COOKED_RABBIT), 0.35F);
        this.a(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.35F);
        this.registerRecipe(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1F);
        this.a(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.b), new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.N), 0.1F);
        this.a(Items.CLAY_BALL, new ItemStack(Items.BRICK), 0.2F);
        this.registerRecipe(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35F);
        this.registerRecipe(Blocks.CACTUS, new ItemStack(Items.DYE, 1, EnumColor.GREEN.getInvColorIndex()), 0.2F);
        this.registerRecipe(Blocks.LOG, new ItemStack(Items.COAL, 1, 1), 0.15F);
        this.registerRecipe(Blocks.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15F);
        this.registerRecipe(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD), 1.0F);
        this.a(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.35F);
        this.registerRecipe(Blocks.NETHERRACK, new ItemStack(Items.NETHERBRICK), 0.1F);
        this.a(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15F);
        this.a(new ItemStack(Blocks.LAVA_SPONGE, 1, 1), new ItemStack(Blocks.LAVA_SPONGE, 1, 0), 0.15F);
        this.a(Items.PAIN2C, new ItemStack(Items.PAIN2C_COOKED), 1.35F);
        this.registerRecipe(Blocks.KETA_ORE, new ItemStack(Items.KETAMINERAI), 1.0F);
        this.a(Items.FIOLEMETH, new ItemStack(Items.CRYSTALMETH), 0.35F);
        this.a(Items.FIOLE_COCA, new ItemStack(Items.PAIN2C), 0.35F);
        this.registerRecipe(Blocks.BICARBONATE_ORE, new ItemStack(Items.BICARBONATE), 1.0F);
        this.registerRecipe(Blocks.BITCOIN_ORE, new ItemStack(Items.BITCOIN_HALF), 7.0F);
        this.registerRecipe(Blocks.TITANE_ORE, new ItemStack(Items.TITANE), 7.0F);
        
        this.a(new ItemStack(Items.FIOLE5L, 1, 1), new ItemStack(Items.CRYSTALMETH, 3), 5.0F);
        this.a(new ItemStack(Items.FIOLE5L, 1, 2), new ItemStack(Items.COCAINE, 2), 5.0F);
        this.a(new ItemStack(Items.FIOLE5L, 1, 3), new ItemStack(Items.HEROINE, 3), 5.0F);  
        EnumFish[] aenumfish = EnumFish.values();
        int i = aenumfish.length;

        for (int j = 0; j < i; ++j) {
            EnumFish enumfish = aenumfish[j];

            if (enumfish.g()) {
                this.a(new ItemStack(Items.FISH, 1, enumfish.a()), new ItemStack(Items.COOKED_FISH, 1, enumfish.a()), 0.35F);
            }
        }

        this.registerRecipe(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.1F);
        this.registerRecipe(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE), 0.4F);
        this.registerRecipe(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), 0.2F);
        this.registerRecipe(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ), 0.2F);
    }
 
    // CraftBukkit start - add method
    public void registerRecipe(ItemStack itemstack, ItemStack itemstack1) {
        this.customRecipes.put(itemstack, itemstack1);
    }
    // CraftBukkit end

    public void registerRecipe(Block block, ItemStack itemstack, float f) {
        this.a(Item.getItemOf(block), itemstack, f);
    }

    public void a(Item item, ItemStack itemstack, float f) {
        this.a(new ItemStack(item, 1, 32767), itemstack, f);
    }

    public void a(ItemStack itemstack, ItemStack itemstack1, float f) {
        this.recipes.put(itemstack, itemstack1);
        this.c.put(itemstack1, Float.valueOf(f));
    }

    public ItemStack getResult(ItemStack itemstack) {
        // CraftBukkit start - initialize to customRecipes
        boolean vanilla = false;
        Iterator iterator = this.customRecipes.entrySet().iterator();
        // CraftBukkit end

        Entry entry;

        do {
            if (!iterator.hasNext()) {
                // CraftBukkit start - fall back to vanilla recipes
                if (!vanilla && !recipes.isEmpty()) {
                    iterator = this.recipes.entrySet().iterator();
                    vanilla = true;
                } else {
                    return null;
                }
                // CraftBukkit end
            }

            entry = (Entry) iterator.next();
        } while (!this.a(itemstack, (ItemStack) entry.getKey()));

        return (ItemStack) entry.getValue();
    }

    private boolean a(ItemStack itemstack, ItemStack itemstack1) {
        return itemstack1.getItem() == itemstack.getItem() && (itemstack1.getData() == 32767 || itemstack1.getData() == itemstack.getData());
    }

    public Map getRecipes() {
        return this.recipes;
    }

    public float b(ItemStack itemstack) {
        Iterator iterator = this.c.entrySet().iterator();

        Entry entry;

        do {
            if (!iterator.hasNext()) {
                return 0.0F;
            }

            entry = (Entry) iterator.next();
        } while (!this.a(itemstack, (ItemStack) entry.getKey()));

        return ((Float) entry.getValue()).floatValue();
    }
}
