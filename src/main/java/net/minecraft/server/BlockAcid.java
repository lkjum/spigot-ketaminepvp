package net.minecraft.server;

public class BlockAcid extends Block {

    public static final BlockStateEnum COULEUR = BlockStateEnum.of("couleur", EnumAcidVariant.class);

    public BlockAcid() {
        super(Material.CLAY);
        this.j(this.blockStateList.getBlockData().set(BlockAcid.COULEUR, EnumAcidVariant.NOIR));
        this.a(CreativeModeTab.b);
    }

    public int getDropData(IBlockData iblockdata) {
        return ((EnumAcidVariant) iblockdata.get(BlockAcid.COULEUR)).getMetadata();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockAcid.COULEUR, EnumAcidVariant.byMetadata(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumAcidVariant) iblockdata.get(BlockAcid.COULEUR)).getMetadata();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] {BlockAcid.COULEUR});
    }
}