package net.minecraft.server;


public enum EnumAcidVariant implements INamable
	{
		NOIR(0, "acid_noir", "noir"),
		ROUGE(1, "acid_rouge","rouge"), 
		BLEU(2, "acid_bleu","bleu"),
		VIOLET(3, "acid_violet","violet"),
		VERT(4, "acid_vert", "vert"),
		ORANGE(5, "acid_orange","orange"),
		CYAN(6, "acid_cyan", "cyan"),
		YELLOW(7, "acid_yellow", "yellow");
		
		private static final EnumAcidVariant[] METADATA = new EnumAcidVariant[values().length];
        private final String name;
        private final String unlocalizedName;
        private final int metadata;
        private EnumAcidVariant(int metadata, String name, String UnlocalizedName)
        {
            this.metadata = metadata;
            this.name = name;
            this.unlocalizedName = UnlocalizedName;
            
        }

        public int getMetadata()
        {
            return this.metadata;
        }
        public String toString()
        {
            return this.unlocalizedName;
        }
       
        public static EnumAcidVariant byMetadata(int metadata)
        {
            if(metadata < 0 || metadata >= METADATA.length)
            {
                metadata = 0;
            }
 
            return METADATA[metadata];
        }
		public String getName() 
		{
			return this.name;
		}
		public String getUnlocalizedName() {
			
			return this.unlocalizedName;
		}
        static
        {
        	for (EnumAcidVariant blockacid$enumtype : values())
            {
                METADATA[blockacid$enumtype.getMetadata()] = blockacid$enumtype;
            }
        }
}