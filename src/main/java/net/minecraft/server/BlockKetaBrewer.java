package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockKetaBrewer extends BlockContainer {

    public static final BlockStateBoolean[] HAS_BOTTLE = new BlockStateBoolean[] { BlockStateBoolean.of("has_bottle_0"), BlockStateBoolean.of("has_bottle_1"), BlockStateBoolean.of("has_bottle_2")};

    public BlockKetaBrewer() {
        super(Material.ORE);
        this.j(this.blockStateList.getBlockData().set(BlockKetaBrewer.HAS_BOTTLE[0], Boolean.valueOf(false)).set(BlockKetaBrewer.HAS_BOTTLE[1], Boolean.valueOf(false)).set(BlockKetaBrewer.HAS_BOTTLE[2], Boolean.valueOf(false)));
        this.durability = 0; 
        c(64);
    }

    public String getName() {
        return LocaleI18n.get("item.keta_brewer.name");
    }

    public boolean c() {
        return false;
    }

    public int b() {
        return 3;
    }

    public TileEntity a(World world, int i) {
        return new TileEntityKetaBrewer();
    }

    public boolean d() {
        return false;
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.j();
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
    }

    public void j() {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityKetaBrewer) {
                entityhuman.openContainer((TileEntityKetaBrewer) tileentity);
                entityhuman.b(StatisticList.M);
            }

            return true;
        }
    }

    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
        if (itemstack.hasName()) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityKetaBrewer) {
                ((TileEntityKetaBrewer) tileentity).a(itemstack.getName());
            }
        }

    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        TileEntity tileentity = world.getTileEntity(blockposition);

        if (tileentity instanceof TileEntityKetaBrewer) {
            InventoryUtils.dropInventory(world, blockposition, (TileEntityKetaBrewer) tileentity);
        }

        super.remove(world, blockposition, iblockdata);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.KETA_BREWER_ITEM;
    }

    public boolean isComplexRedstone() {
        return true;
    }

    public int l(World world, BlockPosition blockposition) {
        return Container.a(world.getTileEntity(blockposition));
    }

    public IBlockData fromLegacyData(int i) {
        IBlockData iblockdata = this.getBlockData();

        for (int j = 0; j < 3; ++j) {
            iblockdata = iblockdata.set(BlockKetaBrewer.HAS_BOTTLE[j], Boolean.valueOf((i & 1 << j) > 0));
        }

        return iblockdata;
    }

    public int toLegacyData(IBlockData iblockdata) {
        int i = 0;

        for (int j = 0; j < 3; ++j) {
            if (((Boolean) iblockdata.get(BlockKetaBrewer.HAS_BOTTLE[j])).booleanValue()) {
                i |= 1 << j;
            }
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockKetaBrewer.HAS_BOTTLE[0], BlockKetaBrewer.HAS_BOTTLE[1], BlockKetaBrewer.HAS_BOTTLE[2]});
    }
}
