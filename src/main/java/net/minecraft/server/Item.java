package net.minecraft.server;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import net.minecraft.server.EntityMinecartAbstract.EnumMinecartType;
import net.minecraft.server.ItemArmor.EnumArmorMaterial;

public class Item
{
  public static final RegistryMaterials REGISTRY = new RegistryMaterials();
  private static final Map a = Maps.newHashMap();

  protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
  private CreativeModeTab b;
  protected static Random g = new Random();

  protected int maxStackSize = 64;
  private int durability;
  protected boolean i;
  protected boolean j;
  private Item craftingResult;
  private String k;
  private String name;
  protected int maxDamage;

  public static int getId(Item paramItem)
  {
    return paramItem == null ? 0 : REGISTRY.b(paramItem);
  }

  public static Item getById(int paramInt) {
    return (Item)REGISTRY.a(paramInt);
  }

  public static Item getItemOf(Block paramBlock) {
    return (Item)a.get(paramBlock);
  }

  public static Item d(String paramString) {
    Item localItem = (Item)REGISTRY.get(new MinecraftKey(paramString));
    if (localItem == null)
      try {
        return getById(Integer.parseInt(paramString));
      }
      catch (NumberFormatException localNumberFormatException) {
      }
    return localItem;
  }

  public boolean a(NBTTagCompound paramNBTTagCompound) {
    return false;
  }

  public Item c(int paramInt)
  {
    this.maxStackSize = paramInt;
    return this;
  }

  public boolean interactWith(ItemStack paramItemStack, EntityHuman paramEntityHuman, World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3) {
    return false;
  }
  public boolean interactWith(ItemStack paramItemStack, EntityHuman paramEntityHuman, World paramWorld, BlockPosition paramBlockPosition, IBlockData iblockdata, EnumDirection paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3) {
	    return false;
	  }

  public float getDestroySpeed(ItemStack paramItemStack, Block paramBlock) {
    return 1.0F;
  }

  public ItemStack a(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman) {
    return paramItemStack;
  }

  public ItemStack b(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman) {
    return paramItemStack;
  }

  public int getMaxStackSize() {
    return this.maxStackSize;
  }

  public int filterData(int paramInt) {
    return 0;
  }

  public boolean k() {
    return this.j;
  }

  protected Item a(boolean paramBoolean) {
    this.j = paramBoolean;
    return this;
  }

  public int getMaxDurability() {
    return this.durability;
  }

  protected Item setMaxDurability(int paramInt) {
    this.durability = paramInt;
    return this;
  }
 
 protected Item setMaxDamage(int maxDamageIn)
 {
     this.maxDamage = maxDamageIn;
     return this;
 }
  public boolean usesDurability() {
    return (this.durability > 0) && (!this.j);
  }

  public boolean a(ItemStack paramItemStack, EntityLiving paramEntityLiving1, EntityLiving paramEntityLiving2)
  {
    return false;
  }

  public boolean a(ItemStack paramItemStack, World paramWorld, Block paramBlock, BlockPosition paramBlockPosition, EntityLiving paramEntityLiving)
  {
    return false;
  }

  public boolean canDestroySpecialBlock(Block paramBlock) {
    return false;
  }

  public boolean a(ItemStack paramItemStack, EntityHuman paramEntityHuman, EntityLiving paramEntityLiving) {
    return false;
  }

  public Item n() {
    this.i = true;
    return this;
  }

  public Item c(String paramString)
  {
    this.name = paramString;
    return this;
  }

  public String k(ItemStack paramItemStack)
  {
    String str = e_(paramItemStack);
    if (str == null) {
      return "";
    }
    return LocaleI18n.get(str);
  }

  public String getName()
  {
    return "item." + this.name;
  }

  public String e_(ItemStack paramItemStack) {
    return "item." + this.name;
  }

  public Item c(Item paramItem) {
    this.craftingResult = paramItem;
    return this;
  }

  public boolean p() {
    return true;
  }

  public Item q() {
    return this.craftingResult;
  }

  public boolean r() {
    return this.craftingResult != null;
  }

  public void a(ItemStack paramItemStack, World paramWorld, Entity paramEntity, int paramInt, boolean paramBoolean)
  {
  }

  public void d(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman)
  {
  }

  public boolean f()
  {
    return false;
  }

  public EnumAnimation e(ItemStack paramItemStack) {
    return EnumAnimation.NONE;
  }

  public int d(ItemStack paramItemStack) {
    return 0;
  }

  public void a(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman, int paramInt) {
  }

  protected Item e(String paramString) {
    this.k = paramString;
    return this;
  }

  public String j(ItemStack paramItemStack) {
    return this.k;
  }

  public boolean l(ItemStack paramItemStack) {
    return j(paramItemStack) != null;
  }

  public String a(ItemStack paramItemStack)
  {
    return ("" + LocaleI18n.get(new StringBuilder().append(k(paramItemStack)).append(".name").toString())).trim();
  }

  public EnumItemRarity g(ItemStack paramItemStack)
  {
    if (paramItemStack.hasEnchantments()) {
      return EnumItemRarity.RARE;
    }
    return EnumItemRarity.COMMON;
  }

  public boolean f_(ItemStack paramItemStack) {
    return (getMaxStackSize() == 1) && (usesDurability());
  }

  protected MovingObjectPosition a(World paramWorld, EntityHuman paramEntityHuman, boolean paramBoolean) {
    float f1 = paramEntityHuman.lastPitch + (paramEntityHuman.pitch - paramEntityHuman.lastPitch);
    float f2 = paramEntityHuman.lastYaw + (paramEntityHuman.yaw - paramEntityHuman.lastYaw);

    double d1 = paramEntityHuman.lastX + (paramEntityHuman.locX - paramEntityHuman.lastX);
    double d2 = paramEntityHuman.lastY + (paramEntityHuman.locY - paramEntityHuman.lastY) + paramEntityHuman.getHeadHeight();
    double d3 = paramEntityHuman.lastZ + (paramEntityHuman.locZ - paramEntityHuman.lastZ);

    Vec3D localVec3D1 = new Vec3D(d1, d2, d3);

    float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
    float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
    float f5 = -MathHelper.cos(-f1 * 0.01745329F);
    float f6 = MathHelper.sin(-f1 * 0.01745329F);

    float f7 = f4 * f5;
    float f8 = f6;
    float f9 = f3 * f5;

    double d4 = 5.0D;
    Vec3D localVec3D2 = localVec3D1.add(f7 * d4, f8 * d4, f9 * d4);

    return paramWorld.rayTrace(localVec3D1, localVec3D2, paramBoolean, !paramBoolean, false);
  }

  public int b() {
    return 0;
  }

  public Item a(CreativeModeTab paramCreativeModeTab)
  {
    this.b = paramCreativeModeTab;
    return this;
  }

  public boolean s() {
    return false;
  }

  public boolean a(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    return false;
  }

  public Multimap i() {
    return HashMultimap.create();
  }

  public static void t()
  {
    a(Blocks.STONE, new ItemMultiTexture(Blocks.STONE, Blocks.STONE, new DisplayStateFunctionStoneVariant()).b("stone"));

    a(Blocks.GRASS, new ItemWithAuxData(Blocks.GRASS, false));
    a(Blocks.DIRT, new ItemMultiTexture(Blocks.DIRT, Blocks.DIRT, new DisplayStateFunctionDirtVariant()).b("dirt"));

    c(Blocks.COBBLESTONE);
    a(Blocks.PLANKS, new ItemMultiTexture(Blocks.PLANKS, Blocks.PLANKS, new DisplayStateFunctionLogVariant()).b("wood"));

    a(Blocks.SAPLING, new ItemMultiTexture(Blocks.SAPLING, Blocks.SAPLING, new DisplayStateFunctionLogVariant2()).b("sapling"));

    c(Blocks.BEDROCK);
    a(Blocks.SAND, new ItemMultiTexture(Blocks.SAND, Blocks.SAND, new DisplayStateFunctionSandVariant()).b("sand"));

    c(Blocks.GRAVEL);
    c(Blocks.GOLD_ORE);
    c(Blocks.IRON_ORE);
    c(Blocks.COAL_ORE);
    a(Blocks.LOG, new ItemMultiTexture(Blocks.LOG, Blocks.LOG, new DisplayStateFunctionLogVariant3()).b("log"));

    a(Blocks.LOG2, new ItemMultiTexture(Blocks.LOG2, Blocks.LOG2, new DisplayStateFunction4()).b("log"));

    a(Blocks.LEAVES, new ItemLeaves(Blocks.LEAVES).b("leaves"));
    a(Blocks.LEAVES2, new ItemLeaves(Blocks.LEAVES2).b("leaves"));
    a(Blocks.SPONGE, new ItemMultiTexture(Blocks.SPONGE, Blocks.SPONGE, new DisplayStateFunctionSponge()).b("sponge"));

    c(Blocks.GLASS);
    c(Blocks.LAPIS_ORE);
    c(Blocks.LAPIS_BLOCK);
    c(Blocks.DISPENSER);
    a(Blocks.SANDSTONE, new ItemMultiTexture(Blocks.SANDSTONE, Blocks.SANDSTONE, new DisplayStateFunctionSandstoneVariant()).b("sandStone"));

    c(Blocks.NOTEBLOCK);
    c(Blocks.GOLDEN_RAIL);
    c(Blocks.DETECTOR_RAIL);
    a(Blocks.STICKY_PISTON, new ItemPiston(Blocks.STICKY_PISTON));
    c(Blocks.WEB);
    a(Blocks.TALLGRASS, new ItemWithAuxData(Blocks.TALLGRASS, true).a(new String[] { "shrub", "grass", "fern" }));
    c(Blocks.DEADBUSH);
    a(Blocks.PISTON, new ItemPiston(Blocks.PISTON));
    a(Blocks.WOOL, new ItemCloth(Blocks.WOOL).b("cloth"));
    a(Blocks.YELLOW_FLOWER, new ItemMultiTexture(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new DisplayStateFunctionYellowFlower()).b("flower"));

    a(Blocks.RED_FLOWER, new ItemMultiTexture(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new DisplayStateFunctionRedFlower()).b("rose"));

    c(Blocks.BROWN_MUSHROOM);
    c(Blocks.RED_MUSHROOM);
    //
    c(Blocks.FLYING_MUSHROOM);
    //
    c(Blocks.GOLD_BLOCK);
    c(Blocks.IRON_BLOCK);
    a(Blocks.STONE_SLAB, new ItemStep(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB).b("stoneSlab"));
    c(Blocks.BRICK_BLOCK);
    c(Blocks.TNT);
    c(Blocks.AQUATNT);
    c(Blocks.BOOKSHELF);
    c(Blocks.MOSSY_COBBLESTONE);
    c(Blocks.OBSIDIAN);
    c(Blocks.TORCH);
    c(Blocks.MOB_SPAWNER);
    c(Blocks.OAK_STAIRS);
    c(Blocks.CHEST);
    c(Blocks.DIAMOND_ORE);
    c(Blocks.DIAMOND_BLOCK);
    c(Blocks.CRAFTING_TABLE);
    c(Blocks.FARMLAND);
    c(Blocks.FURNACE);
    c(Blocks.LIT_FURNACE);
    c(Blocks.LADDER);
    c(Blocks.COKE_LADDER);
    c(Blocks.RAIL);
    c(Blocks.STONE_STAIRS);
    c(Blocks.LEVER);
    c(Blocks.STONE_PRESSURE_PLATE);
    c(Blocks.WOODEN_PRESSURE_PLATE);
    c(Blocks.REDSTONE_ORE);
    c(Blocks.REDSTONE_TORCH);
    c(Blocks.STONE_BUTTON);
    a(Blocks.SNOW_LAYER, new ItemSnow(Blocks.SNOW_LAYER));
    c(Blocks.ICE);
    c(Blocks.SNOW);
    c(Blocks.CACTUS);
    c(Blocks.CLAY);
    c(Blocks.JUKEBOX);
    c(Blocks.FENCE);
    c(Blocks.SPRUCE_FENCE);
    c(Blocks.BIRCH_FENCE);
    c(Blocks.JUNGLE_FENCE);
    c(Blocks.DARK_OAK_FENCE);
    c(Blocks.ACACIA_FENCE);
    c(Blocks.PUMPKIN);
    c(Blocks.NETHERRACK);
    c(Blocks.SOUL_SAND);
    c(Blocks.GLOWSTONE);
    c(Blocks.LIT_PUMPKIN);
    c(Blocks.TRAPDOOR);
   // a(Blocks.MONSTER_EGG, new ItemMultiTexture(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new DisplayStateFunctionMonsterEggVarient()).b("monsterStoneEgg"));

    a(Blocks.STONEBRICK, new ItemMultiTexture(Blocks.STONEBRICK, Blocks.STONEBRICK, new DisplayStateFunctionStonebrickType()).b("stonebricksmooth"));

    c(Blocks.BROWN_MUSHROOM_BLOCK);
    c(Blocks.RED_MUSHROOM_BLOCK);
    //
    c(Blocks.FLYING_MUSHROOM_BLOCK);
    //
    c(Blocks.IRON_BARS);
    c(Blocks.GLASS_PANE);
    c(Blocks.MELON_BLOCK);
    a(Blocks.VINE, new ItemWithAuxData(Blocks.VINE, false));
    c(Blocks.FENCE_GATE);
    c(Blocks.SPRUCE_FENCE_GATE);
    c(Blocks.BIRCH_FENCE_GATE);
    c(Blocks.JUNGLE_FENCE_GATE);
    c(Blocks.DARK_OAK_FENCE_GATE);
    c(Blocks.ACACIA_FENCE_GATE);
    c(Blocks.BRICK_STAIRS);
    c(Blocks.STONE_BRICK_STAIRS);
    c(Blocks.MYCELIUM);
    a(Blocks.WATERLILY, new ItemWaterLily(Blocks.WATERLILY));
    c(Blocks.NETHER_BRICK);
    c(Blocks.NETHER_BRICK_FENCE);
    c(Blocks.NETHER_BRICK_STAIRS);
    c(Blocks.ENCHANTING_TABLE);
    c(Blocks.END_PORTAL_FRAME);
    c(Blocks.END_STONE);
    c(Blocks.DRAGON_EGG);
    c(Blocks.REDSTONE_LAMP);
    a(Blocks.WOODEN_SLAB, new ItemStep(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB).b("woodSlab"));
    c(Blocks.SANDSTONE_STAIRS);
    c(Blocks.EMERALD_ORE);
    c(Blocks.ENDER_CHEST);
    c(Blocks.TRIPWIRE_HOOK);
    c(Blocks.EMERALD_BLOCK);
    c(Blocks.SPRUCE_STAIRS);
    c(Blocks.BIRCH_STAIRS);
    c(Blocks.JUNGLE_STAIRS);
    c(Blocks.COMMAND_BLOCK);
    c(Blocks.BEACON);
    a(Blocks.COBBLESTONE_WALL, new ItemMultiTexture(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new DisplayStateFunctionCobbleVariant()).b("cobbleWall"));

    c(Blocks.WOODEN_BUTTON);
    a(Blocks.ANVIL, new ItemAnvil(Blocks.ANVIL).b("anvil"));
    c(Blocks.TRAPPED_CHEST);
    c(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
    c(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    c(Blocks.DAYLIGHT_DETECTOR);
    c(Blocks.REDSTONE_BLOCK);
    c(Blocks.QUARTZ_ORE);
    c(Blocks.HOPPER);
    a(Blocks.QUARTZ_BLOCK, new ItemMultiTexture(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[] { "default", "chiseled", "lines" }).b("quartzBlock"));
    c(Blocks.QUARTZ_STAIRS);
    c(Blocks.ACTIVATOR_RAIL);
    c(Blocks.DROPPER);
    a(Blocks.STAINED_HARDENED_CLAY, new ItemCloth(Blocks.STAINED_HARDENED_CLAY).b("clayHardenedStained"));
    c(Blocks.BARRIER);
    c(Blocks.IRON_TRAPDOOR);
    //c(Blocks.CROUTE_DOOR_BLOCK);
    c(Blocks.HAY_BLOCK);
    a(Blocks.CARPET, new ItemCloth(Blocks.CARPET).b("woolCarpet"));
    c(Blocks.HARDENED_CLAY);
    c(Blocks.COAL_BLOCK);
    c(Blocks.PACKED_ICE);
    c(Blocks.ACACIA_STAIRS);
    c(Blocks.DARK_OAK_STAIRS);
    c(Blocks.SLIME);
    a(Blocks.DOUBLE_PLANT, new ItemTallPlant(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new DisplayStateFunctionTallFlowerVariants()).b("doublePlant"));

    a(Blocks.STAINED_GLASS, new ItemCloth(Blocks.STAINED_GLASS).b("stainedGlass"));
    a(Blocks.STAINED_GLASS_PANE, new ItemCloth(Blocks.STAINED_GLASS_PANE).b("stainedGlassPane"));
    a(Blocks.PRISMARINE, new ItemMultiTexture(Blocks.PRISMARINE, Blocks.PRISMARINE, new DisplayStateFunctionPrismarineVariant()).b("prismarine"));

    c(Blocks.SEA_LANTERN);
    a(Blocks.RED_SANDSTONE, new ItemMultiTexture(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new DisplayStateFunctionRedSandstoneVariant()).b("redSandStone"));

    c(Blocks.RED_SANDSTONE_STAIRS);
    a(Blocks.STONE_SLAB2, new ItemStep(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2).b("stoneSlab2"));
    c(Blocks.SON);
    // KetaminePVP - add blocks
    c(Blocks.COKE_ORE);
    c(Blocks.KETA_ORE);
    c(Blocks.BITCOIN_ORE);
    c(Blocks.BICARBONATE_ORE);
    c(Blocks.KETA_BLOCK);
    c(Blocks.COKE_BLOCK);
    c(Blocks.BICAR_BLOCK);
    a(Blocks.BLOCKACID, new ItemMultiTexture(Blocks.BLOCKACID, Blocks.BLOCKACID, new DisplayStateFunctionAcidVariant()).b("blockAcid"));
    c(Blocks.INVISIBLE);
    c(Blocks.IRON_CHEST);
    c(Blocks.TITANE_BLOCK);
    c(Blocks.TITANE_ORE);
    c(Blocks.DEALORE);
    c(Blocks.BICAR_FURNACE);
    c(Blocks.LIT_BICAR_FURNACE);
    c(Blocks.COKE_BURNER);
    c(Blocks.LIT_COKE_BURNER);
    c(Blocks.TITANE_CHEST);
    c(Blocks.KETA_BREWING);
    c(Blocks.HEROINE_BLOCK);
    c(Blocks.CROUTE_TERRESTRE);
    a(Blocks.LAVA_SPONGE, new ItemMultiTexture(Blocks.LAVA_SPONGE, Blocks.LAVA_SPONGE, new DisplayStateFunctionSponge()).b("lava_sponge"));
    c(Blocks.DRUGS_WORK);
    c(Blocks.SPACE_CAKE);
    c(Blocks.CYBOULETTES);
    c(Blocks.SON_1);
    c(Blocks.SON_2);
    c(Blocks.SON_3);// KetaminePVP - add blocks
    c(Blocks.MAGMA);
    c(Blocks.END_BRICKS);
    c(Blocks.PURPUR_BLOCK);
    c(Blocks.HEAL_BLOCK);
    c(Blocks.DISENCHANT_BLOCK);
    c(Blocks.SHEITAN_BLOCK);
    c(Blocks.SHEITAN_ORE);
    c(Blocks.OBSIRED);
    a(256, "iron_shovel", new ItemSpade(EnumToolMaterial.IRON).c("shovelIron"));
    a(257, "iron_pickaxe", new ItemPickaxe(EnumToolMaterial.IRON).c("pickaxeIron"));
    a(258, "iron_axe", new ItemAxe(EnumToolMaterial.IRON).c("hatchetIron"));
    a(259, "flint_and_steel", new ItemFlintAndSteel().c("flintAndSteel"));
    a(260, "apple", new ItemFood(4, 0.3F, false).c("apple"));
    a(261, "bow", new ItemBow().c("bow"));
    a(262, "arrow", new Item().c("arrow").a(CreativeModeTab.j));
    a(263, "coal", new ItemCoal().c("coal"));
    a(264, "diamond", new Item().c("diamond").a(CreativeModeTab.l));
    a(265, "iron_ingot", new Item().c("ingotIron").a(CreativeModeTab.l));
    a(266, "gold_ingot", new Item().c("ingotGold").a(CreativeModeTab.l));
    a(267, "iron_sword", new ItemSword(EnumToolMaterial.IRON).c("swordIron"));
    a(268, "wooden_sword", new ItemSword(EnumToolMaterial.WOOD).c("swordWood"));
    a(269, "wooden_shovel", new ItemSpade(EnumToolMaterial.WOOD).c("shovelWood"));
    a(270, "wooden_pickaxe", new ItemPickaxe(EnumToolMaterial.WOOD).c("pickaxeWood"));
    a(271, "wooden_axe", new ItemAxe(EnumToolMaterial.WOOD).c("hatchetWood"));
    a(272, "stone_sword", new ItemSword(EnumToolMaterial.STONE).c("swordStone"));
    a(273, "stone_shovel", new ItemSpade(EnumToolMaterial.STONE).c("shovelStone"));
    a(274, "stone_pickaxe", new ItemPickaxe(EnumToolMaterial.STONE).c("pickaxeStone"));
    a(275, "stone_axe", new ItemAxe(EnumToolMaterial.STONE).c("hatchetStone"));
    a(276, "diamond_sword", new ItemSword(EnumToolMaterial.EMERALD).c("swordDiamond"));
    a(277, "diamond_shovel", new ItemSpade(EnumToolMaterial.EMERALD).c("shovelDiamond"));
    a(278, "diamond_pickaxe", new ItemPickaxe(EnumToolMaterial.EMERALD).c("pickaxeDiamond"));
    a(279, "diamond_axe", new ItemAxe(EnumToolMaterial.EMERALD).c("hatchetDiamond"));
    a(280, "stick", new Item().n().c("stick").a(CreativeModeTab.l));
    a(281, "bowl", new Item().c("bowl").a(CreativeModeTab.l));
    a(282, "mushroom_stew", new ItemSoup(6).c("mushroomStew"));
    a(283, "golden_sword", new ItemSword(EnumToolMaterial.GOLD).c("swordGold"));
    a(284, "golden_shovel", new ItemSpade(EnumToolMaterial.GOLD).c("shovelGold"));
    a(285, "golden_pickaxe", new ItemPickaxe(EnumToolMaterial.GOLD).c("pickaxeGold"));
    a(286, "golden_axe", new ItemAxe(EnumToolMaterial.GOLD).c("hatchetGold"));
    a(287, "string", new ItemReed(Blocks.TRIPWIRE).c("string").a(CreativeModeTab.l));
    a(288, "feather", new Item().c("feather").a(CreativeModeTab.l));
    a(289, "gunpowder", new Item().c("sulphur").e(PotionBrewer.k).a(CreativeModeTab.l));
    a(290, "wooden_hoe", new ItemHoe(EnumToolMaterial.WOOD).c("hoeWood"));
    a(291, "stone_hoe", new ItemHoe(EnumToolMaterial.STONE).c("hoeStone"));
    a(292, "iron_hoe", new ItemHoe(EnumToolMaterial.IRON).c("hoeIron"));
    a(293, "diamond_hoe", new ItemHoe(EnumToolMaterial.EMERALD).c("hoeDiamond"));
    a(294, "golden_hoe", new ItemHoe(EnumToolMaterial.GOLD).c("hoeGold"));
    a(295, "wheat_seeds", new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND).c("seeds"));
    a(296, "wheat", new Item().c("wheat").a(CreativeModeTab.l));
    a(297, "bread", new ItemFood(5, 0.6F, false).c("bread"));
    a(298, "leather_helmet", new ItemArmor(EnumArmorMaterial.LEATHER, 0, 0).c("helmetCloth"));
    a(299, "leather_chestplate", new ItemArmor(EnumArmorMaterial.LEATHER, 0, 1).c("chestplateCloth"));
    a(300, "leather_leggings", new ItemArmor(EnumArmorMaterial.LEATHER, 0, 2).c("leggingsCloth"));
    a(301, "leather_boots", new ItemArmor(EnumArmorMaterial.LEATHER, 0, 3).c("bootsCloth"));
    a(302, "chainmail_helmet", new ItemArmor(EnumArmorMaterial.CHAIN, 1, 0).c("helmetChain"));
    a(303, "chainmail_chestplate", new ItemArmor(EnumArmorMaterial.CHAIN, 1, 1).c("chestplateChain"));
    a(304, "chainmail_leggings", new ItemArmor(EnumArmorMaterial.CHAIN, 1, 2).c("leggingsChain"));
    a(305, "chainmail_boots", new ItemArmor(EnumArmorMaterial.CHAIN, 1, 3).c("bootsChain"));
    a(306, "iron_helmet", new ItemArmor(EnumArmorMaterial.IRON, 2, 0).c("helmetIron"));
    a(307, "iron_chestplate", new ItemArmor(EnumArmorMaterial.IRON, 2, 1).c("chestplateIron"));
    a(308, "iron_leggings", new ItemArmor(EnumArmorMaterial.IRON, 2, 2).c("leggingsIron"));
    a(309, "iron_boots", new ItemArmor(EnumArmorMaterial.IRON, 2, 3).c("bootsIron"));
    a(310, "diamond_helmet", new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 0).c("helmetDiamond"));
    a(311, "diamond_chestplate", new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 1).c("chestplateDiamond"));
    a(312, "diamond_leggings", new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 2).c("leggingsDiamond"));
    a(313, "diamond_boots", new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 3).c("bootsDiamond"));
    a(314, "golden_helmet", new ItemArmor(EnumArmorMaterial.GOLD, 4, 0).c("helmetGold"));
    a(315, "golden_chestplate", new ItemArmor(EnumArmorMaterial.GOLD, 4, 1).c("chestplateGold"));
    a(316, "golden_leggings", new ItemArmor(EnumArmorMaterial.GOLD, 4, 2).c("leggingsGold"));
    a(317, "golden_boots", new ItemArmor(EnumArmorMaterial.GOLD, 4, 3).c("bootsGold"));
    a(318, "flint", new Item().c("flint").a(CreativeModeTab.l));
    a(319, "porkchop", new ItemFood(3, 0.3F, true).c("porkchopRaw"));
    a(320, "cooked_porkchop", new ItemFood(8, 0.8F, true).c("porkchopCooked"));
    a(321, "painting", new ItemHanging(EntityPainting.class).c("painting"));
    a(322, "golden_apple", new ItemGoldenApple(4, 1.2F, false).h().a(MobEffectList.REGENERATION.id, 5, 1, 1.0F).c("appleGold"));
    a(323, "sign", new ItemSign().c("sign"));
    a(324, "wooden_door", new ItemDoor(Blocks.WOODEN_DOOR).c("doorOak"));
    Item localItem = new ItemBucket(Blocks.AIR).c("bucket").c(16);
    a(325, "bucket", localItem);
    a(326, "water_bucket", new ItemBucket(Blocks.FLOWING_WATER).c("bucketWater").c(localItem));
    a(327, "lava_bucket", new ItemBucket(Blocks.FLOWING_LAVA).c("bucketLava").c(localItem));
    a(328, "minecart", new ItemMinecart(EnumMinecartType.RIDEABLE).c("minecart"));
    a(329, "saddle", new ItemSaddle().c("saddle"));
    a(330, "iron_door", new ItemDoor(Blocks.IRON_DOOR).c("doorIron"));
    a(331, "redstone", new ItemRedstone().c("redstone").e(PotionBrewer.i));
    a(332, "snowball", new ItemSnowball().c("snowball"));
    a(333, "boat", new ItemBoat().c("boat"));
    a(334, "leather", new Item().c("leather").a(CreativeModeTab.l));
    a(335, "milk_bucket", new ItemMilkBucket().c("milk").c(localItem));
    a(336, "brick", new Item().c("brick").a(CreativeModeTab.l));
    a(337, "clay_ball", new Item().c("clay").a(CreativeModeTab.l));
    a(338, "reeds", new ItemReed(Blocks.REEDS).c("reeds").a(CreativeModeTab.l));
    a(339, "paper", new Item().c("paper").a(CreativeModeTab.f));
    a(340, "book", new ItemBook().c("book").a(CreativeModeTab.f));
    a(341, "slime_ball", new Item().c("slimeball").a(CreativeModeTab.f));
    a(342, "chest_minecart", new ItemMinecart(EnumMinecartType.CHEST).c("minecartChest"));
    a(343, "furnace_minecart", new ItemMinecart(EnumMinecartType.FURNACE).c("minecartFurnace"));
    a(344, "egg", new ItemEgg().c("egg"));
    a(345, "compass", new Item().c("compass").a(CreativeModeTab.i));
    a(346, "fishing_rod", new ItemFishingRod().c("fishingRod"));
    a(347, "clock", new Item().c("clock").a(CreativeModeTab.i));
    a(348, "glowstone_dust", new Item().c("yellowDust").e(PotionBrewer.j).a(CreativeModeTab.l));
    a(349, "fish", new ItemFish(false).c("fish").a(true));
    a(350, "cooked_fish", new ItemFish(true).c("fish").a(true));
    a(351, "dye", new ItemDye().c("dyePowder"));
    a(352, "bone", new Item().c("bone").n().a(CreativeModeTab.f));
    a(353, "sugar", new Item().c("sugar").e(PotionBrewer.b).a(CreativeModeTab.l));
    a(354, "cake", new ItemReed(Blocks.CAKE).c(1).c("cake").a(CreativeModeTab.h));
    a(355, "bed", new ItemBed().c(1).c("bed"));
    a(356, "repeater", new ItemReed(Blocks.UNPOWERED_REPEATER).c("diode").a(CreativeModeTab.d));
    a(357, "cookie", new ItemFood(2, 0.1F, false).c("cookie"));
    a(358, "filled_map", new ItemWorldMap().c("map"));
    a(359, "shears", new ItemShears().c("shears"));
    a(360, "melon", new ItemFood(2, 0.3F, false).c("melon"));
    a(361, "pumpkin_seeds", new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND).c("seeds_pumpkin"));
    a(362, "melon_seeds", new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND).c("seeds_melon"));
    a(363, "beef", new ItemFood(3, 0.3F, true).c("beefRaw"));
    a(364, "cooked_beef", new ItemFood(8, 0.8F, true).c("beefCooked"));
    a(365, "chicken", new ItemFood(2, 0.3F, true).a(MobEffectList.HUNGER.id, 30, 0, 0.3F).c("chickenRaw"));
    a(366, "cooked_chicken", new ItemFood(6, 0.6F, true).c("chickenCooked"));
    a(367, "rotten_flesh", new ItemFood(4, 0.1F, true).a(MobEffectList.HUNGER.id, 30, 0, 0.8F).c("rottenFlesh"));
    a(368, "ender_pearl", new ItemEnderPearl().c("enderPearl"));
    a(369, "blaze_rod", new Item().c("blazeRod").a(CreativeModeTab.l).n());
    a(370, "ghast_tear", new Item().c("ghastTear").e(PotionBrewer.c).a(CreativeModeTab.k));
    a(371, "gold_nugget", new Item().c("goldNugget").a(CreativeModeTab.l));
    a(372, "nether_wart", new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND).c("netherStalkSeeds").e("+4"));
    a(373, "potion", new ItemPotion().c("potion"));
    a(374, "glass_bottle", new ItemGlassBottle().c("glassBottle"));
    a(375, "spider_eye", new ItemFood(2, 0.8F, false).a(MobEffectList.POISON.id, 5, 0, 1.0F).c("spiderEye").e(PotionBrewer.d));
    a(376, "fermented_spider_eye", new Item().c("fermentedSpiderEye").e(PotionBrewer.e).a(CreativeModeTab.k));
    a(377, "blaze_powder", new Item().c("blazePowder").a(CreativeModeTab.k));
    a(378, "magma_cream", new Item().c("magmaCream").e(PotionBrewer.h).a(CreativeModeTab.k));
    a(379, "brewing_stand", new ItemReed(Blocks.BREWING_STAND).c("brewingStand").a(CreativeModeTab.k));
    a(380, "cauldron", new ItemReed(Blocks.cauldron).c("cauldron").a(CreativeModeTab.k));
    a(381, "ender_eye", new ItemEnderEye().c("eyeOfEnder"));
    a(382, "speckled_melon", new Item().c("speckledMelon").e(PotionBrewer.f).a(CreativeModeTab.k));
    a(383, "spawn_egg", new ItemMonsterEgg().c("monsterPlacer"));
    a(384, "experience_bottle", new ItemExpBottle().c("expBottle"));
    a(385, "fire_charge", new ItemFireball().c("fireball"));
    a(386, "writable_book", new ItemBookAndQuill().c("writingBook").a(CreativeModeTab.f));
    a(387, "written_book", new ItemWrittenBook().c("writtenBook").c(16));
    a(388, "emerald", new Item().c("emerald").a(CreativeModeTab.l));
    a(389, "item_frame", new ItemHanging(EntityItemFrame.class).c("frame"));
    a(390, "flower_pot", new ItemReed(Blocks.FLOWER_POT).c("flowerPot").a(CreativeModeTab.c));
    a(391, "carrot", new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND).c("carrots"));
    a(392, "potato", new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND).c("potato"));
    a(393, "baked_potato", new ItemFood(5, 0.6F, false).c("potatoBaked"));
    a(394, "poisonous_potato", new ItemFood(2, 0.3F, false).a(MobEffectList.POISON.id, 5, 0, 0.6F).c("potatoPoisonous"));
    a(395, "map", new ItemMapEmpty().c("emptyMap"));
    a(396, "golden_carrot", new ItemFood(6, 1.2F, false).c("carrotGolden").e(PotionBrewer.l).a(CreativeModeTab.k));
    a(397, "skull", new ItemSkull().c("skull"));
    a(398, "carrot_on_a_stick", new ItemCarrotStick().c("carrotOnAStick"));
    a(399, "nether_star", new ItemNetherStar().c("netherStar").a(CreativeModeTab.l));
    a(400, "pumpkin_pie", new ItemFood(8, 0.3F, false).c("pumpkinPie").a(CreativeModeTab.h));
    a(401, "fireworks", new ItemFireworks().c("fireworks"));
    a(402, "firework_charge", new ItemFireworksCharge().c("fireworksCharge").a(CreativeModeTab.f));
    a(403, "enchanted_book", new ItemEnchantedBook().c(1).c("enchantedBook"));
    a(404, "comparator", new ItemReed(Blocks.UNPOWERED_COMPARATOR).c("comparator").a(CreativeModeTab.d));
    a(405, "netherbrick", new Item().c("netherbrick").a(CreativeModeTab.l));
    a(406, "quartz", new Item().c("netherquartz").a(CreativeModeTab.l));
    a(407, "tnt_minecart", new ItemMinecart(EnumMinecartType.TNT).c("minecartTnt"));
    a(408, "hopper_minecart", new ItemMinecart(EnumMinecartType.HOPPER).c("minecartHopper"));
    a(409, "prismarine_shard", new Item().c("prismarineShard").a(CreativeModeTab.l));
    a(410, "prismarine_crystals", new Item().c("prismarineCrystals").a(CreativeModeTab.l));
    a(411, "rabbit", new ItemFood(3, 0.3F, true).c("rabbitRaw"));
    a(412, "cooked_rabbit", new ItemFood(5, 0.6F, true).c("rabbitCooked"));
    a(413, "rabbit_stew", new ItemSoup(10).c("rabbitStew"));
    a(414, "rabbit_foot", new Item().c("rabbitFoot").e(PotionBrewer.n).a(CreativeModeTab.k));
    a(415, "rabbit_hide", new Item().c("rabbitHide").a(CreativeModeTab.l));
    a(416, "armor_stand", new ItemArmorStand().c("armorStand").c(16));
    a(417, "iron_horse_armor", new Item().c("horsearmormetal").c(1).a(CreativeModeTab.f));
    a(418, "golden_horse_armor", new Item().c("horsearmorgold").c(1).a(CreativeModeTab.f));
    a(419, "diamond_horse_armor", new Item().c("horsearmordiamond").c(1).a(CreativeModeTab.f));
    a(420, "lead", new ItemLeash().c("leash"));
    a(421, "name_tag", new ItemNameTag().c("nameTag"));
    a(422, "command_block_minecart", new ItemMinecart(EnumMinecartType.COMMAND_BLOCK).c("minecartCommandBlock"));
    a(423, "mutton", new ItemFood(2, 0.3F, true).c("muttonRaw"));
    a(424, "cooked_mutton", new ItemFood(6, 0.8F, true).c("muttonCooked"));
    a(425, "banner", new ItemBanner().b("banner"));
    a(427, "spruce_door", new ItemDoor(Blocks.SPRUCE_DOOR).c("doorSpruce"));
    a(428, "birch_door", new ItemDoor(Blocks.BIRCH_DOOR).c("doorBirch"));
    a(429, "jungle_door", new ItemDoor(Blocks.JUNGLE_DOOR).c("doorJungle"));
    a(430, "acacia_door", new ItemDoor(Blocks.ACACIA_DOOR).c("doorAcacia"));
    a(431, "dark_oak_door", new ItemDoor(Blocks.DARK_OAK_DOOR).c("doorDarkOak"));
    
    // KETAMINE  - add item
    a(600, "pain2c", (new ItemPainDeC()).c("pain2c").a(CreativeModeTab.l));
    a(601, "pain2c_cooked", (new Item()).c("pain2c_cooked").a(CreativeModeTab.l));
    a(602, "bicarbonate", (new Item()).c("bicarbonate").a(CreativeModeTab.l));
    a(603, "extrait_bicar", (new Item()).c("extrait_bicar").a(CreativeModeTab.l));
    a(604, "cocaine", (new Item()).c("cocaine").a(CreativeModeTab.l));
    a(605, "ketaminerai", (new Item()).c("ketaminerai").a(CreativeModeTab.l));
    //a(606, "fioleMeth", (new Item()).c("fioleMeth").a(CreativeModeTab.l));
    a(634, "bitcoin", (new Item()).c("bitcoin").a(CreativeModeTab.l));
    
    a(607, "ketaCasque", (new ItemArmor(EnumArmorMaterial.KETAMINERAI, 5, 0)).c("ketaCasque"));
    a(608, "ketaPlaque", (new ItemArmor(EnumArmorMaterial.KETAMINERAI, 5, 1)).c("ketaPlaque"));
    a(609, "ketaPants", (new ItemArmor(EnumArmorMaterial.KETAMINERAI, 5, 2)).c("ketaPants"));
    a(610, "ketaBoots", (new ItemArmor(EnumArmorMaterial.KETAMINERAI, 5, 3)).c("ketaBoots"));
    a(611, "crystalMeth", (new Item()).c("crystalMeth").a(CreativeModeTab.l));
    a(612, "trace2c", new ItemTraceCoke(0).c("trace2c"));
    a(618, "coke_helmet", (new ItemArmor(EnumArmorMaterial.COKE, 6, 0)).c("coke_helmet"));
    a(619, "coke_chestplate", (new ItemArmor(EnumArmorMaterial.COKE, 6, 1)).c("coke_chestplate"));
    a(620, "coke_legs", (new ItemArmor(EnumArmorMaterial.COKE, 6, 2)).c("coke_legs"));
    a(621, "coke_boots", (new ItemArmor(EnumArmorMaterial.COKE, 6, 3)).c("coke_boots"));
    
    a(627, "pipe", new Item().c("pipe"));
    a(628, "pipeCrack", new ItemCrack(0).c("pipeCrack"));
    a(629, "iron_nugget", new Item().c("iron_nugget"));
    a(630, "bitcoin_helmet", (new ItemArmor(EnumArmorMaterial.BITCOIN, 7, 0)).c("bitcoin_helmet"));
    a(631, "bitcoin_chestplate", (new ItemArmor(EnumArmorMaterial.BITCOIN, 7, 1)).c("bitcoin_chestplate"));
    a(632, "bitcoin_leggings", (new ItemArmor(EnumArmorMaterial.BITCOIN, 7, 2)).c("bitcoin_legs"));
    a(633, "bitcoin_boots", (new ItemArmor(EnumArmorMaterial.BITCOIN, 7, 3)).c("bitcoin_boots"));
    
    
    a(613, "ketaPioche", (new ItemPickaxe(EnumToolMaterial.KETAMATIERE)).c("ketaPioche"));
    a(614, "ketaPelle", (new ItemSpade(EnumToolMaterial.KETAMATIERE)).c("ketaPelle"));
    a(615, "ketAxe", (new ItemAxe(EnumToolMaterial.KETAMATIERE)).c("ketAxe"));
    a(616, "ketaSword", (new ItemSword(EnumToolMaterial.KETAMATIERE)).c("ketaSword"));
    a(617, "ketaFaux", (new ItemHoe(EnumToolMaterial.KETAMATIERE)).c("ketaFaux"));
    
    a(622, "coke_pickaxe", (new ItemPickaxe(EnumToolMaterial.COKE)).c("coke_pickaxe"));
    a(623, "coke_shovel", (new ItemSpade(EnumToolMaterial.COKE)).c("coke_shovel"));
    a(624, "coke_axe", (new ItemAxe(EnumToolMaterial.COKE)).c("coke_axe"));
    a(625, "coke_sword", (new ItemSword(EnumToolMaterial.COKE)).c("coke_sword"));
    a(626, "coke_hoe", (new ItemHoe(EnumToolMaterial.COKE)).c("coke_hoe"));
    
    a(638, "bitcoin_sword", (new ItemSword(EnumToolMaterial.BITCOIN)).c("bitcoin_sword"));
    a(636, "bitcoin_shovel", (new ItemSpade(EnumToolMaterial.BITCOIN)).c("bitcoin_shovel"));
    a(635, "bitcoin_pickaxe", (new ItemPickaxe(EnumToolMaterial.BITCOIN)).c("bitcoin_pickaxe"));
    a(637, "bitcoin_axe", (new ItemAxe(EnumToolMaterial.BITCOIN)).c("bitcoin_axe"));
    a(639, "bitcoin_hoe", (new ItemHoe(EnumToolMaterial.BITCOIN)).c("bitcoin_hoe"));
    
    a(640, "dark_bitcoin", (new Item()).c("dark_bitcoin").a(CreativeModeTab.l));
    a(641, "dark_chestplate", (new ItemArmor(EnumArmorMaterial.DARK_BITCOIN, 8, 1)).c("dark_chestplate"));
    a(642, "dark_sword", (new ItemSword(EnumToolMaterial.DARK_BITCOIN)).c("dark_sword"));
    a(643, "joint", (new ItemJoint(0).c("joint")));
    a(644, "potionHaste", (new ItemHaste(0).c("potionHaste")));
    a(645, "botMilk", (new PotionMilk(0, false).c("botMilk")));
    a(646, "potionHaste2", (new ItemHaste2(0).c("potionHaste2")));
    a(647, "acid", (new ItemAcid(0).c("acid")));
    a(648, "sunshine", (new ItemAcid(1).c("sunshine")));
    a(649, "goblin", (new ItemAcid(2).c("goblin")));
    a(650, "trace2k", (new ItemTrace(1).c("trace2k")));
    a(651, "trace2speed", (new ItemTraceSpeed(2).c("trace2speed")));
    a(652, "pipeBeuh", (new ItemCrack(1)).c("pipeBeuh"));
    a(653, "pipeTabac", (new ItemCrack(2)).c("pipeTabac"));
    a(654, "pipeDMT", (new ItemCrack(3)).c("pipeDMT"));
    a(655, "beuh", (new Item().c("beuh")));
    a(656, "tabac", (new Item().c("tabac")));
    a(657, "DMT", (new Item().c("DMT")));
    a(658, "extKeta", (new Item().c("extKeta").e(PotionBrewer.extKetaEffect)));
    a(659, "extCrack", (new Item().c("extCrack").e(PotionBrewer.extBicarEffect)));
    a(660, "weed_seeds", (new ItemSeeds(Blocks.WEED, Blocks.FARMLAND).c("weed_seeds").a(CreativeModeTab.l)));
    a(661, "coca_seeds", (new ItemSeeds(Blocks.COCA, Blocks.FARMLAND).c("coca_seeds").a(CreativeModeTab.l)));
    a(662, "coca_feuilles", (new Item().c("coca_feuilles").a(CreativeModeTab.l)));
    a(663, "coca_piled", (new Item().c("coca_piled")));
    a(664, "fiole_coca", (new Item().c("fiole_coca")));
    a(665, "coca_stack", (new Item().c("coca_stack")));
    a(666, "cannabis", (new Item().c("cannabis")));
    a(667, "massa", (new Item().c("massa")));
    a(668, "tonk", (new Item().c("tonk")));
    a(669, "banane_turfu", (new ItemBanane().c("banane_turfu")));
    a(670, "potionResistance", (new ItemResistance(0).c("potionResistance")));
    a(671, "potionFall", (new ItemFall().c("potionFall")));
    a(672, "petrole", (new Item().c("petrole")));
    a(673, "ammo", (new ItemAmmo().c("ammo")));
    a(674, "AK", (new ItemAK(0, 0.0F, false).c("AK")));
    a(676, "titane", (new Item().c("titane")));
    a(677, "titane_helmet", (new ItemArmor(EnumArmorMaterial.TITANE, 9, 0).c("titane_helmet")));
    a(678, "titane_chestplate", (new ItemArmor(EnumArmorMaterial.TITANE, 9, 1).c("titane_chestplate")));
    a(679, "titane_legs", (new ItemArmor(EnumArmorMaterial.TITANE, 9, 2).c("titane_legs")));
    a(680, "titane_boots", (new ItemArmor(EnumArmorMaterial.TITANE, 9, 3).c("titane_boots")));
    a(681, "titane_pickaxe", (new ItemPickaxe(EnumToolMaterial.TITANE).c("titane_pickaxe")));
    a(682, "titane_shovel", (new ItemSpade(EnumToolMaterial.TITANE).c("titane_shovel")));
    a(683, "titane_axe", (new ItemAxe(EnumToolMaterial.TITANE).c("titane_axe")));
    a(684, "titane_sword", (new ItemSword(EnumToolMaterial.TITANE).c("titane_sword")));
    a(685, "titane_hoe", (new ItemHoe(EnumToolMaterial.TITANE).c("titane_hoe")));
    a(686, "titane_nugget", (new Item().c("titane_nugget")));
    
    a(687, "fiole5l", (new Item5l()).c("fiole5l"));
    a(688, "pavot_seeds", (new ItemSeeds(Blocks.PAVOTS, Blocks.MYCELIUM)).c("pavot_seeds").a(CreativeModeTab.l));
    a(689, "pavot", (new Item()).c("pavot").a(CreativeModeTab.l));
    a(690, "pavot_stack", (new Item()).c("pavot_stack").a(CreativeModeTab.l));
    a(691, "heroine", (new Item()).c("heroine").a(CreativeModeTab.l).e(PotionBrewer.mdcEffect));
    a(692, "heroine_stack", (new Item()).c("heroine_stack").a(CreativeModeTab.l));    
    a(693, "keta_brewer", new ItemReed(Blocks.KETA_BREWING).c("keta_brewer"));
    a(207, "weed", new Item().c("weed").a(CreativeModeTab.l));
    a(208, "coca", new Item().c("coca").a(CreativeModeTab.l));
    a(224, "pavots", new Item().c("pavot").a(CreativeModeTab.l));
    a(694, "keta_chest_minecart", new ItemMinecart(EnumMinecartType.KETA_CHEST).c("minecartKetaChest"));
    a(695, "bitcoin_half", (new Item()).c("bitcoin_half").a(CreativeModeTab.l));
    
    a(700, "dark_helmet",(new ItemArmor(ItemArmor.EnumArmorMaterial.DARK_BITCOIN, 7, 0)).c("dark_helmet"));
	a(701, "dark_leggings",(new ItemArmor(ItemArmor.EnumArmorMaterial.DARK_BITCOIN, 7, 2)).c("dark_leggings"));
	a(702, "dark_boots",(new ItemArmor(ItemArmor.EnumArmorMaterial.DARK_BITCOIN, 7, 3)).c("dark_boots"));
	a(703, "dark_pickaxe",(new ItemPickaxe(EnumToolMaterial.DARK_BITCOIN)).c("dark_pickaxe"));
	a(704, "dark_shovel", (new ItemSpade(EnumToolMaterial.DARK_BITCOIN)).c("dark_shovel"));
	a(705, "dark_axe", (new ItemAxe(EnumToolMaterial.DARK_BITCOIN)).c("dark_axe"));
	a(706, "dark_hoe", (new ItemHoe(EnumToolMaterial.DARK_BITCOIN)).c("dark_hoe"));
	a(707, "mdma",(new Item()).c("mdma").a(CreativeModeTab.l));
	a(708, "md_helmet",(new ItemArmor(ItemArmor.EnumArmorMaterial.MDMA, 8, 0)).c("md_helmet"));
	a(709, "md_chestplate",(new ItemArmor(ItemArmor.EnumArmorMaterial.MDMA, 8, 1)).c("md_chestplate"));
	a(710, "md_leggings",(new ItemArmor(ItemArmor.EnumArmorMaterial.MDMA, 8, 2)).c("md_leggings"));
	a(711, "md_boots",(new ItemArmor(ItemArmor.EnumArmorMaterial.MDMA, 8, 3)).c("md_boots"));
	a(712, "md_pickaxe", (new ItemPickaxe(EnumToolMaterial.MDMA)).c("md_pickaxe"));
	a(713, "md_axe", (new ItemAxe(EnumToolMaterial.MDMA)).c("md_axe"));
	a(714, "md_shovel", (new ItemSpade(EnumToolMaterial.MDMA)).c("md_shovel"));
	a(715, "md_sword", (new ItemSword(EnumToolMaterial.MDMA)).c("md_sword"));
	a(716, "md_hoe", (new ItemHoe(EnumToolMaterial.MDMA)).c("md_hoe"));
	a(717, "md_poudre",(new Item()).c("md_poudre").a(CreativeModeTab.l));
	a(718, "plaque", (new Item()).c("plaque").a(CreativeModeTab.l));
	
	a(719, "space_cake_item", (new ItemReed(Blocks.SPACE_CAKE)).c(1).c("space_cake_item"));
	a(720, "titane_stick", (new Item().c("titane_stick")));
	a(721, "tiKeta", (new Item().c("tiKeta")));
	a(722, "tiCoke", (new Item().c("tiCoke")));
	a(723, "tiMdma", (new Item().c("tiMdma")));
	a(724, "tiSup", (new Item().c("tiSup")));
	
	a(725, "tiKeta_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_KETA, 10, 0)).c("tiKeta_helmet"));
	a(726, "tiKeta_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_KETA, 10, 1)).c("tiKeta_chestplate"));
	a(727, "tiKeta_legs", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_KETA, 10, 2)).c("tiKeta_legs"));
	a(728, "tiKeta_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_KETA, 10, 3)).c("tiKeta_boots"));
	
	a(729, "tiCoke_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_COKE, 11, 0)).c("tiCoke_helmet"));
	a(730, "tiCoke_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_COKE, 11, 1)).c("tiCoke_chestplate"));
	a(731, "tiCoke_legs", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_COKE, 11, 2)).c("tiCoke_legs"));
	a(732, "tiCoke_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_COKE, 11, 3)).c("tiCoke_boots"));
	
	a(733, "tiMdma_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_MDMA, 12, 0)).c("tiMdma_helmet"));
	a(734, "tiMdma_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_MDMA, 12, 1)).c("tiMdma_chestplate"));
	a(735, "tiMdma_legs", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_MDMA, 12, 2)).c("tiMdma_legs"));
	a(736, "tiMdma_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.RENFO_MDMA, 12, 3)).c("tiMdma_boots"));
	
	a(737, "tiSup_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.TITANE_SUP, 13, 0)).c("tiSup_helmet"));
	a(738, "tiSup_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.TITANE_SUP, 13, 1)).c("tiSup_chestplate"));
	a(739, "tiSup_legs", (new ItemArmor(ItemArmor.EnumArmorMaterial.TITANE_SUP, 13, 2)).c("tiSup_legs"));
	a(740, "tiSup_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.TITANE_SUP, 13, 3)).c("tiSup_boots"));
	
	a(741, "tiSup_pickaxe", (new ItemPickaxe(EnumToolMaterial.TITANE_RENFO)).c("tiSup_pickaxe"));
	a(742, "tiSup_axe", (new ItemAxe(EnumToolMaterial.TITANE_RENFO)).c("tiSup_axe"));
	a(743, "tiSup_shovel", (new ItemSpade(EnumToolMaterial.TITANE_RENFO)).c("tiSup_shovel"));
	
	a(744, "tiSup_sword", (new ItemSword(EnumToolMaterial.TITANE_RENFO)).c("tiSup_sword"));
	a(745, "tiKeta_sword", (new ItemSword(EnumToolMaterial.TITANE_KETA)).c("tiKeta_sword"));
	a(746, "tiCoke_sword", (new ItemSword(EnumToolMaterial.TITANE_COKE)).c("tiCoke_sword"));
	a(747, "tiMdma_sword", (new ItemSword(EnumToolMaterial.TITANE_MDMA)).c("tiMdma_sword"));
	
	a(748, "sup_nugget", (new Item().c("sup_nugget").a(CreativeModeTab.l)));
    
	a(749, "taz_gold", (new Taz1(1).c("taz_gold")));
	a(750, "taz_superman", (new Taz2(1).c("taz_superman")));
	a(751, "taz_domino", (new Taz3(1).c("taz_domino")));
	a(752, "taz_mitsu", (new Taz4(1).c("taz_mitsu")));
	a(753, "space_coockie", (new ItemSpaceCoockie().c("space_coockie")));
	a(754, "beurre_marrakech", (new Item().c("beurre_marrakech").a(CreativeModeTab.l)));
	a(755, "item_multi", (new ItemMulti(EnumToolMaterial.TITANE)).c("item_multi"));
	a(756, "item_farming", (new ItemFarming(EnumToolMaterial.FARM).c("item_farming")));
	a(757, "item_farmouz", (new ItemFarmouz(EnumToolMaterial.FARM).c("item_farmouz")));
	a(758, "ketapple", new ItemKetapple(1).c("ketapple"));
	a(759, "cyboulette", new ItemCyboul(Blocks.CYBOULETTES).c("cyboulette").a(CreativeModeTab.l));
	a(760, "purple", (new Item()).c("purple").a(CreativeModeTab.l));
	a(761, "purple_seeds", (new ItemSeeds(Blocks.PURPLES, Blocks.MYCELIUM)).c("purple_seeds").a(CreativeModeTab.l));
    a(240, "purples", (new Item()).c("purple").a(CreativeModeTab.l));
    a(762, "purple_tete", (new Item()).c("purple_tete").a(CreativeModeTab.l));	
	a(763, "item_farmseed", (new ItemFarmseed(EnumToolMaterial.FARM).c("item_farmseed")));
	a(764, "gun", (new ItemGun(0, 0.0F, false).c("gun")));
	a(765, "item_multipick", (new ItemMultiPick(EnumToolMaterial.MULTIFARM)).c("item_multipick"));
	a(766, "keta_pearl", new ItemKetaPearl().c("keta_pearl"));
	a(767, "flying_mushroom_stew", new ItemMagicSoup(8).c("FlyingmushroomStew"));
    a(241, "ibogas", (new Item()).c("iboga").a(CreativeModeTab.l));	
    a(768, "ibogaine", (new Item()).c("ibogaine").a(CreativeModeTab.l));
	a(769, "iboga_root", (new ItemSeeds(Blocks.IBOGAS, Blocks.FARMLAND)).c("iboga_root").a(CreativeModeTab.l));
    a(770, "iboga_fruit", (new Item()).c("iboga_fruit").a(CreativeModeTab.l));	
    a(771, "ItemIbogaPotion", (new ItemIbogaPotion().c("ItemIbogaPotion")));
    a(242, "salvias", (new Item()).c("salvia").a(CreativeModeTab.l));	
    a(772, "salviaX40", (new Item()).c("salviaX40").a(CreativeModeTab.l));
	a(773, "salvia_seeds", (new ItemSeeds(Blocks.SALVIAS, Blocks.FARMLAND)).c("salvia_seeds").a(CreativeModeTab.l));
    a(774, "salvia_flower", (new Item()).c("salvia_flower").a(CreativeModeTab.l));	
    a(775, "croute_door", new ItemDoor(Blocks.CROUTE_DOOR_BLOCK).c("doorCroute"));
    a(246, "croute_door_block", (new Item()).c("doorCroute").a(CreativeModeTab.l));	
    a(776, "obsi_door", new ItemDoor(Blocks.OBSI_DOOR_BLOCK).c("doorObsi"));
    a(247, "obsi_door_block", (new Item()).c("doorObsi").a(CreativeModeTab.l));
    a(250, "weed_plant_base", (new Item()).c("weed_plant_base").a(CreativeModeTab.l));
    a(251, "weed_plant_top", (new Item()).c("weed_plant_top").a(CreativeModeTab.l));
    a(777, "weed_plant_item", (new ItemSeeds(Blocks.WEED_PLANT_BASE, Blocks.FARMLAND)).c("weed_plant_item").a(CreativeModeTab.l));
    a(778, "sheitanite", (new Item().c("sheitanite").a(CreativeModeTab.l)));
    
    a(779, "dague_diable", (new ItemDagueDiable(EnumToolMaterial.SHEITANITE)).c("dague_diable"));
    a(780, "douille", (new Item().c("douille")));
    a(781, "feather_phoenix", (new Item().c("feather_phoenix")));
    a(784, "arrowForce", new Item().c("arrowForce").a(CreativeModeTab.j));
    a(785, "arrowSpeed", new Item().c("arrowSpeed").a(CreativeModeTab.j));
    a(786, "arrowPoison", new Item().c("arrowPoison").a(CreativeModeTab.j));
    a(787, "arrowLenteur", new Item().c("arrowLenteur").a(CreativeModeTab.j));
    
    a(782, "leanpleine", (new ItemLean()).c("leanpleine").a(CreativeModeTab.l));
	a(783, "leandemi", (new ItemLeanDemi()).c("leandemi").a(CreativeModeTab.l));
	a(788, "leanvide", (new Item()).c("leanvide").a(CreativeModeTab.l));
	a(789, "fin2lean", (new ItemLeanFin()).c("fin2lean").a(CreativeModeTab.l));
	a(790, "phenergan_pills", (new Item()).c("phenergan_pills").a(CreativeModeTab.l));
	a(791, "tussipax_pills", (new Item()).c("tussipax_pills").a(CreativeModeTab.l));
	a(792, "sprite", (new Item()).c("sprite").a(CreativeModeTab.l));
	a(793, "acetone", (new Item()).c("acetone").a(CreativeModeTab.l));
	a(794, "grappin", (new ItemGrappin()).c("grappin")); 
    
    a(2256, "record_13", new ItemRecord("13").c("record"));
    a(2257, "record_cat", new ItemRecord("cat").c("record"));
    a(2258, "record_blocks", new ItemRecord("blocks").c("record"));
    a(2259, "record_chirp", new ItemRecord("chirp").c("record"));
    a(2260, "record_far", new ItemRecord("far").c("record"));
    a(2261, "record_mall", new ItemRecord("mall").c("record"));
    a(2262, "record_mellohi", new ItemRecord("mellohi").c("record"));
    a(2263, "record_stal", new ItemRecord("stal").c("record"));
    a(2264, "record_strad", new ItemRecord("strad").c("record"));
    a(2265, "record_ward", new ItemRecord("ward").c("record"));
    a(2266, "record_11", new ItemRecord("11").c("record"));
    a(2267, "record_wait", new ItemRecord("wait").c("record"));
    
  }

  private static void c(Block paramBlock) {
    a(paramBlock, new ItemBlock(paramBlock));
  }

  protected static void a(Block paramBlock, Item paramItem) {
    a(Block.getId(paramBlock), (MinecraftKey)Block.REGISTRY.c(paramBlock), paramItem);
    a.put(paramBlock, paramItem);
  }

  private static void a(int paramInt, String paramString, Item paramItem) {
    a(paramInt, new MinecraftKey(paramString), paramItem);
  }

  private static void a(int paramInt, MinecraftKey paramMinecraftKey, Item paramItem) {
    REGISTRY.a(paramInt, paramMinecraftKey, paramItem);
  }

public Multimap<String, AttributeModifier> getItemAttributeModifiers() {
	// TODO Auto-generated method stub
	return null;
}
public enum EnumToolMaterial {
	
	
    WOOD("WOOD", 0, 0, 59, 2.0F, 0.0F, 15), 
    STONE("STONE", 1, 1, 131, 4.0F, 1.0F, 5), 
    IRON("IRON", 2, 2, 250, 6.0F, 2.0F, 14),
    EMERALD("EMERALD", 3, 3, 1561, 5.0F, 2.5F, 10),
    GOLD("GOLD", 0, 0, 32, 12.0F, 0.0F, 22),
    /** KETAMINE */
    
    FARM("EMERALD", 3, 3, 10000, 7.0F, 2.5F, 10),
    MULTIFARM("SHEITANITE", 3, 3, 25000, 7.0F, 2.5F, 15),
    SHEITANITE("DAGUE", 4, 4, 8000, 10.0F, 6.0F, 10),
    
    KETAMATIERE("KETAMATIERE", 4, 3, 2048, 6.5F, 3.0F, 10),
    COKE("COKE", 5, 5, 3000, 7.25F, 4.0F, 10),
    BITCOIN("BITCOIN", 5, 6, 5000, 9.5F, 5.0F, 10),
    DARK_BITCOIN("DARK", 5, 7, 8000, 10.0F, 6.0F, 10),
    TITANE("TITANE", 5, 8, 10000, 11.0F, 6.5F, 10),
	MDMA("MDMA",5, 8,  11500, 11.5F, 7.0F, 10),
	
	TITANE_KETA("TITANE_KETA",6,8, 12000, 12.5F, 7.0F, 10),
	TITANE_COKE("TITANE_COKE",6,8, 13000, 13.5F, 7.5F, 10),
	TITANE_MDMA("TITANE_MDMA",6,8, 15000, 15.0F, 8.25F, 10),
	TITANE_RENFO("TITANE_RENFO",7,8, 17000, 16.0F, 8.75F, 15);
    private final int f;
    private final int g;
    private final float h;
    private final float i;
    private final int j;
    private static final EnumToolMaterial[] k = new EnumToolMaterial[] { WOOD, STONE, IRON, EMERALD, GOLD, KETAMATIERE, COKE, BITCOIN, DARK_BITCOIN, MDMA, TITANE_KETA, TITANE_COKE, TITANE_MDMA, TITANE_RENFO}; 

    private EnumToolMaterial(String s, int i, int j, int k, float f, float f1, int l) {
        this.f = j;
        this.g = k;
        this.h = f;
        this.i = f1;
        this.j = l;
    }

    public int a() {
        return this.g;
    }

    public float b() {
        return this.h;
    }

    public float c() {
        return this.i;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.j;
    }

    public Item f() {
        return this == WOOD ? Item.getItemOf(Blocks.PLANKS) : 
        	(this == STONE ? Item.getItemOf(Blocks.COBBLESTONE) : 
        		(this == GOLD ? Items.GOLD_INGOT : 
        			(this == IRON ? Items.IRON_INGOT : 
        				(this == EMERALD ? Items.DIAMOND : 
        					(this == KETAMATIERE ? Items.KETAMINERAI :
        						(this == FARM ? Items.EMERALD : 
        							(this == MULTIFARM ? Items.SHEITANITE : 
        								(this == SHEITANITE ? Items.SHEITANITE : 
        						(this == COKE ? Items.PAIN2C :
        							(this == BITCOIN ? Items.BITCOIN :
        								(this == DARK_BITCOIN ? Items.DARK_BITCOIN :
        									(this == TITANE ? Items.TITANE :
        										(this == MDMA ? Items.MDMA :
        											(this == TITANE_KETA ? Items.TIKETA :
        												(this == TITANE_COKE ? Items.TICOKE :
        													(this == TITANE_MDMA ? Items.TIMDMA :
        														(this == TITANE_RENFO ? Items.TISUP :
        					null)))))))))))))))));
	
}}}


