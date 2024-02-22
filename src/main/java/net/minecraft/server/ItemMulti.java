package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class ItemMulti extends ItemTool {

    protected Item.EnumToolMaterial a;
    private static final Set<Block> EffectiveOn = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB});

    public ItemMulti(Item.EnumToolMaterial item_enumtoolmaterial) {
    	super(2.5F, item_enumtoolmaterial, ItemMulti.EffectiveOn);
        this.a = item_enumtoolmaterial;
        this.maxStackSize = 1;
        this.setMaxDurability(item_enumtoolmaterial.a());
        this.a(CreativeModeTab.i);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (!entityhuman.a(blockposition.shift(enumdirection), enumdirection, itemstack)) {
            return false;
        } else {
            IBlockData iblockdata = world.getType(blockposition);
            Block block = iblockdata.getBlock();

            if (enumdirection != EnumDirection.DOWN && world.getType(blockposition.up()).getBlock().getMaterial() == Material.AIR) {
                if (block == Blocks.GRASS) {
                    return this.a(itemstack, entityhuman, world, blockposition, Blocks.FARMLAND.getBlockData());
                }

                if (block == Blocks.DIRT) {
                    switch (ItemMulti.SyntheticClass_1.a[((BlockDirt.EnumDirtVariant) iblockdata.get(BlockDirt.VARIANT)).ordinal()]) {
                    case 1:
                        return this.a(itemstack, entityhuman, world, blockposition, Blocks.FARMLAND.getBlockData());

                    case 2:
                        return this.a(itemstack, entityhuman, world, blockposition, Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT));
                    }
                }
            }

            return false;
        }
    }

    protected boolean a(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, IBlockData iblockdata) {
        world.makeSound((double) ((float) blockposition.getX() + 0.5F), (double) ((float) blockposition.getY() + 0.5F), (double) ((float) blockposition.getZ() + 0.5F), iblockdata.getBlock().stepSound.getStepSound(), (iblockdata.getBlock().stepSound.getVolume1() + 1.0F) / 2.0F, iblockdata.getBlock().stepSound.getVolume2() * 0.8F);
        if (world.isClientSide) {
            return true;
        } else {
            world.setTypeUpdate(blockposition, iblockdata);
            itemstack.damage(1, entityhuman);
            return true;
        }
    }


    static class SyntheticClass_1 {

        static final int[] a = new int[BlockDirt.EnumDirtVariant.values().length];

        static {
            try {
            	ItemMulti.SyntheticClass_1.a[BlockDirt.EnumDirtVariant.DIRT.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
            	ItemMulti.SyntheticClass_1.a[BlockDirt.EnumDirtVariant.COARSE_DIRT.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

        }
    }
    public boolean canDestroySpecialBlock(Block block) {
        return block == Blocks.OBSIDIAN ? this.b.d() >= 3 :
        	(block == Blocks.SNOW_LAYER || block == Blocks.SNOW ? this.b.d() >= 0 :
        	(block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE ? 
        			(block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK ?
        					(block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE ?
        							(block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE ?
        									(block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE ? 
        											(block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE ? 
        													(block.getMaterial() == Material.STONE ? true :
        														(block.getMaterial() == Material.ORE ? true
        															 : block.getMaterial() == Material.HEAVY)) :
        																 
        										this.b.d() >= 2) :
        											this.b.d() >= 1) :
        												this.b.d() >= 1) :
        													this.b.d() >= 2) :
        														this.b.d() >= 2) : 
        															this.b.d() >= 2));
    }

    public float getDestroySpeed(ItemStack itemstack, Block block) {
        return block.getMaterial() != Material.ORE && block.getMaterial() != Material.HEAVY && block.getMaterial() != Material.STONE && block.getMaterial() != Material.WOOD && block.getMaterial() != Material.PLANT && block.getMaterial() != Material.REPLACEABLE_PLANT ? super.getDestroySpeed(itemstack, block) : 10.0F;
    }
}