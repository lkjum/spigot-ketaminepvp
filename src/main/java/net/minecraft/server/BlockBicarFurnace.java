package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockBicarFurnace extends BlockContainer {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);
    private final boolean b;
    private static boolean N;

    public BlockBicarFurnace(boolean flag) {
        super(Material.STONE);
        this.j(this.blockStateList.getBlockData().set(BlockBicarFurnace.FACING, EnumDirection.NORTH));
        this.b = flag;
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.BICAR_FURNACE);
    }

    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        this.e(world, blockposition, iblockdata);
    }

    private void e(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.isClientSide) {
            Block block = world.getType(blockposition.north()).getBlock();
            Block block1 = world.getType(blockposition.south()).getBlock();
            Block block2 = world.getType(blockposition.west()).getBlock();
            Block block3 = world.getType(blockposition.east()).getBlock();
            EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockBicarFurnace.FACING);

            if (enumdirection == EnumDirection.NORTH && block.o() && !block1.o()) {
                enumdirection = EnumDirection.SOUTH;
            } else if (enumdirection == EnumDirection.SOUTH && block1.o() && !block.o()) {
                enumdirection = EnumDirection.NORTH;
            } else if (enumdirection == EnumDirection.WEST && block2.o() && !block3.o()) {
                enumdirection = EnumDirection.EAST;
            } else if (enumdirection == EnumDirection.EAST && block3.o() && !block2.o()) {
                enumdirection = EnumDirection.WEST;
            }

            world.setTypeAndData(blockposition, iblockdata.set(BlockBicarFurnace.FACING, enumdirection), 2);
        }
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityBicarFurnace) {
                entityhuman.openContainer((TileEntityBicarFurnace) tileentity);
                //entityhuman.a(AchievementList.buildBicarFurnace);
            }

            return true;
        }
    }

    public static void a(boolean flag, World world, BlockPosition blockposition) {
        IBlockData iblockdata = world.getType(blockposition);
        TileEntity tileentity = world.getTileEntity(blockposition);

        BlockBicarFurnace.N = true;
        if (flag) {
            world.setTypeAndData(blockposition, Blocks.BICAR_FURNACE.getBlockData().set(BlockBicarFurnace.FACING, iblockdata.get(BlockBicarFurnace.FACING)), 3);
            world.setTypeAndData(blockposition, Blocks.LIT_BICAR_FURNACE.getBlockData().set(BlockFurnace.FACING, iblockdata.get(BlockBicarFurnace.FACING)), 3);
        } else {
            world.setTypeAndData(blockposition, Blocks.BICAR_FURNACE.getBlockData().set(BlockBicarFurnace.FACING, iblockdata.get(BlockBicarFurnace.FACING)), 3);
            world.setTypeAndData(blockposition, Blocks.BICAR_FURNACE.getBlockData().set(BlockBicarFurnace.FACING, iblockdata.get(BlockBicarFurnace.FACING)), 3);
        }

        BlockBicarFurnace.N = false;
        if (tileentity != null) {
            tileentity.D();
            world.setTileEntity(blockposition, tileentity);
        }

    }

    public TileEntity a(World world, int i) {
        return new TileEntityBicarFurnace();
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockBicarFurnace.FACING, entityliving.getDirection().opposite());
    }

    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
        world.setTypeAndData(blockposition, iblockdata.set(BlockBicarFurnace.FACING, entityliving.getDirection().opposite()), 2);
        if (itemstack.hasName()) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityBicarFurnace) {
                ((TileEntityBicarFurnace) tileentity).a(itemstack.getName());
            }
        }

    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!BlockBicarFurnace.N) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityBicarFurnace) {
                InventoryUtils.dropInventory(world, blockposition, (TileEntityBicarFurnace) tileentity);
                world.updateAdjacentComparators(blockposition, this);
            }
        }

        super.remove(world, blockposition, iblockdata);
    }

    public boolean isComplexRedstone() {
        return true;
    }

    public int l(World world, BlockPosition blockposition) {
        return Container.a(world.getTileEntity(blockposition));
    }

    public int b() {
        return 3;
    }

    public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);

        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }

        return this.getBlockData().set(BlockBicarFurnace.FACING, enumdirection);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection) iblockdata.get(BlockBicarFurnace.FACING)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockBicarFurnace.FACING});
    }
}