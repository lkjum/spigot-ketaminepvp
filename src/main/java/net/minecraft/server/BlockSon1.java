package net.minecraft.server;

import net.minecraft.server.EnumDirection.EnumDirectionLimit;

public class BlockSon1 extends Block {
	public static final BlockStateDirection FACE = BlockStateDirection.of("face", EnumDirectionLimit.HORIZONTAL);
	protected BlockSon1(Material material) {
		super(material);
		this.j(this.blockStateList.getBlockData().set(BlockSon.FACE, EnumDirection.NORTH));
	}
	public IBlockData getPlacedState(World worldIn, BlockPosition pos, EnumDirection facing, float hitX, float hitY, float hitZ, int meta, EntityLiving placer)
    {
    	return getBlockData().set(FACE, placer.getDirection().opposite());
    }

	public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);

        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }

        return this.getBlockData().set(BlockSon.FACE, enumdirection);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection) iblockdata.get(BlockSon.FACE)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] {BlockSon.FACE});
    }
    public int b() {
        return 3;
    }
    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
    	
    	 //world.set(blockposition, iblockdata.set(FACE, entityliving.getDirection().opposite()), 2);
         //if (genererInt(II,BB) == 1) {
     	 world.makeSound(entityliving, "ketamine.harcode", 5.0F, 1.0F);	
    }
}