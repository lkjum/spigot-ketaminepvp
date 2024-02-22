package net.minecraft.server;

import java.util.List;

import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;

public class InventoryIronChest extends InventorySubcontainer {

    private TileEntityIronChest a;
    public ITileInventory left;
    public ITileInventory right;

    // CraftBukkit start - add fields and methods
    public List<HumanEntity> transaction = new java.util.ArrayList<HumanEntity>();
    public org.bukkit.entity.Player player;
    private int maxStack = MAX_STACK;

    public ItemStack[] getContents() {
        return this.items;
    }

    public void onOpen(CraftHumanEntity who) {
    	this.left.onOpen(who);
        this.right.onOpen(who);
        transaction.add(who);
    }

    public void onClose(CraftHumanEntity who) {
    	this.left.onClose(who);
        this.right.onClose(who);
        transaction.remove(who);
    }

    public List<HumanEntity> getViewers() {
        return transaction;
    }

    public org.bukkit.inventory.InventoryHolder getOwner() {
        return this.player;
    }

    public void setMaxStackSize(int size) {
        maxStack = size;
    }

    public int getMaxStackSize() {
        return maxStack;
    }
    // CraftBukkit end

    public InventoryIronChest(String s, ITileInventory itileinventory, ITileInventory itileinventory1) {
        super("container.iron_chest", false, 54);
        if (itileinventory == null) {
            itileinventory = itileinventory1;
        }

        if (itileinventory1 == null) {
            itileinventory1 = itileinventory;
        }

        this.left = itileinventory;
        this.right = itileinventory1;
        if (itileinventory.r_()) {
            itileinventory1.a(itileinventory.i());
        } else if (itileinventory1.r_()) {
            itileinventory.a(itileinventory1.i());
        }

    }

    public void a(TileEntityIronChest tileentityenderchest) {
        this.a = tileentityenderchest;
    }

    public void a(NBTTagList nbttaglist) {
        int i;

        for (i = 0; i < this.getSize(); ++i) {
            this.setItem(i, (ItemStack) null);
        }

        for (i = 0; i < nbttaglist.size(); ++i) {
            NBTTagCompound nbttagcompound = nbttaglist.get(i);
            int j = nbttagcompound.getByte("Slot") & 255;

            if (j >= 0 && j < this.getSize()) {
                this.setItem(j, ItemStack.createStack(nbttagcompound));
            }
        }

    }

    public NBTTagList h() {
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.getSize(); ++i) {
            ItemStack itemstack = this.getItem(i);

            if (itemstack != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();

                nbttagcompound.setByte("Slot", (byte) i);
                itemstack.save(nbttagcompound);
                nbttaglist.add(nbttagcompound);
            }
        }

        return nbttaglist;
    }
    public boolean leftOrRight(IInventory iinventory) {
        return this.left == iinventory || this.right == iinventory;
    }
    public boolean a(EntityHuman entityhuman) {
        return this.a != null && !this.a.a(entityhuman) ? false : super.a(entityhuman);
    }

    public void startOpen(EntityHuman entityhuman) {
        
            this.left.startOpen(entityhuman);
            this.right.startOpen(entityhuman);

        super.startOpen(entityhuman);
    }

    public void closeContainer(EntityHuman entityhuman) {
    	this.left.closeContainer(entityhuman);
        this.right.closeContainer(entityhuman);
        super.closeContainer(entityhuman);
        this.a = null;
    }
}
