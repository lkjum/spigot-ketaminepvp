package net.minecraft.server;

public class Item5l extends Item {

    public Item5l() {
        this.a(true);
        this.setMaxDurability(0);
        c(64);
       
    }
    
    private static final String[] fioleType = new String[] {"clean", "crack", "coca", "hero", "titane"};
    
    public String e_(ItemStack stack) {

    		int i = stack.getData();

            if (i < 0 || i >= fioleType.length)
            {
                i = 0;
            }

            return super.getName() + "." + fioleType[i];
        }
    }