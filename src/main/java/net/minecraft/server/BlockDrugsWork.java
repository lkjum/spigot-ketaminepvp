package net.minecraft.server;

public class BlockDrugsWork extends Block {

    protected BlockDrugsWork() {
        super(Material.ORE);
        this.a(CreativeModeTab.c);
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            entityhuman.openTileEntity(new BlockDrugsWork.TileEntityContainerWorkbench2(world, blockposition));
            return true;
        }
    }

    public static class TileEntityContainerWorkbench2 implements ITileEntityContainer {

        private final World a;
        private final BlockPosition b;

        public TileEntityContainerWorkbench2(World world, BlockPosition blockposition) {
            this.a = world;
            this.b = blockposition;
        }

        public String getName() {
            return null;
        }

        public boolean hasCustomName() {
            return false;
        }

        public IChatBaseComponent getScoreboardDisplayName() {
            return new ChatMessage(Blocks.DRUGS_WORK.a() + ".name", new Object[0]);
        }

        public Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman) {
            return new ContainerDrugsWork(playerinventory, this.a, this.b);
        }

        public String getContainerName() {
            return "minecraft:drugs_work";
        }
    }
}