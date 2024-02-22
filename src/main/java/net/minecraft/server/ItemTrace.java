package net.minecraft.server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ItemTrace extends ItemFood 
{
	// static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 //static final String DB_URL = "jdbc:mysql://62.210.119.162:3306/Stats";
	// static final String USER = "stats";
	 //static final String PASS = "!w7g!";
	private int meta;

	public EntityPlayer player;
	
    public ItemTrace(int meta) 
	{
    	super(0, 0, false);
        this.meta = meta;
    	//c(32);
        this.maxStackSize = 64;
        h();
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }
        	//this.SqlConn();
        	world.makeSound(entityhuman, "ketamine.trace", 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            entityhuman.addEffect(new MobEffect(MobEffectList.FASTER_MOVEMENT.id, 6000, 2 ));
            entityhuman.addEffect(new MobEffect(MobEffectList.JUMP.id, 3000, 1 ));
            entityhuman.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 300, 0 ));
        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 7;
    }
    
    public EnumAnimation e(ItemStack paramItemStack)
    {
      return EnumAnimation.SNORT;
    }
    

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }
}
    
/*public void SqlConn() 
{
	 Connection conn = null;
	 Statement stmt = null;
	 try
	 { 
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "insert into Blocks (Pseudo,NomBlock,NombreCasser) values ('"+this.player.getName()+"','PipeCrack',1);";
	    stmt.executeUpdate(sql);
	    stmt.close();
	    conn.close();
	 }catch(SQLException se){
	    se.printStackTrace();
	 }catch(Exception e){
	    e.printStackTrace();
	 }finally{
	    try{
	       if(stmt!=null)
	          stmt.close();
	    }catch(SQLException se2){
	    }
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }
	 }
	 System.out.println("Termine!");
	}
}*/