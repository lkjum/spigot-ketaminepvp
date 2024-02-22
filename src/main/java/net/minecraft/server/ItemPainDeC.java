package net.minecraft.server;

public class ItemPainDeC extends Item {
	public ItemPainDeC(  )
	{
		super();
        this.maxStackSize = 64;
	}
	int comp = 0;
	public void onCreated(ItemStack stack, World worldIn, EntityHuman playerIn)
	{
		 comp = comp + 1;
		 while (comp < 500) 
		 {
			 return;
		 }
	     if (comp > 500) 
	     {
	    	// playerIn.b(AchievementList.beEscobar);	
	    	 comp = 0;
	    	 return;

	     }
	 }
}
