package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class PacketPlayOutExplosion implements Packet<PacketListenerPlayOut> {
	  private double a;
	  
	  private double b;
	  
	  private double c;
	  
	  private float d;
	  
	  private List<BlockPosition> e;
	  
	  private float f;
	  
	  private float g;
	  
	  private float h;
	  
	  public PacketPlayOutExplosion() {}
	  
	  public PacketPlayOutExplosion(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, List<BlockPosition> paramList, Vec3D paramVec3D) {
	    this.a = paramDouble1;
	    this.b = paramDouble2;
	    this.c = paramDouble3;
	    this.d = paramFloat;
	    this.e = Lists.newArrayList(paramList);
	    if (paramVec3D != null) {
	      this.f = (float)paramVec3D.a;
	      this.g = (float)paramVec3D.b;
	      this.h = (float)paramVec3D.c;
	    } 
	  }
	  
	  public void a(PacketDataSerializer paramPacketDataSerializer) throws IOException {
	    this.a = paramPacketDataSerializer.readFloat();
	    this.b = paramPacketDataSerializer.readFloat();
	    this.c = paramPacketDataSerializer.readFloat();
	    this.d = paramPacketDataSerializer.readFloat();
	    int i = paramPacketDataSerializer.readInt();
	    this.e = Lists.newArrayListWithCapacity(i);
	    int j = (int)this.a;
	    int k = (int)this.b;
	    int m = (int)this.c;
	    for (byte b = 0; b < i; b++) {
	      int n = paramPacketDataSerializer.readByte() + j;
	      int i1 = paramPacketDataSerializer.readByte() + k;
	      int i2 = paramPacketDataSerializer.readByte() + m;
	      this.e.add(new BlockPosition(n, i1, i2));
	    } 
	    this.f = paramPacketDataSerializer.readFloat();
	    this.g = paramPacketDataSerializer.readFloat();
	    this.h = paramPacketDataSerializer.readFloat();
	  }
	  
	  public void b(PacketDataSerializer paramPacketDataSerializer) throws IOException {
	    paramPacketDataSerializer.writeFloat((float)this.a);
	    paramPacketDataSerializer.writeFloat((float)this.b);
	    paramPacketDataSerializer.writeFloat((float)this.c);
	    paramPacketDataSerializer.writeFloat(this.d);
	    paramPacketDataSerializer.writeInt(this.e.size());
	    int i = (int)this.a;
	    int j = (int)this.b;
	    int k = (int)this.c;
	    for (BlockPosition blockPosition : this.e) {
	      int m = blockPosition.getX() - i;
	      int n = blockPosition.getY() - j;
	      int i1 = blockPosition.getZ() - k;
	      paramPacketDataSerializer.writeByte(m);
	      paramPacketDataSerializer.writeByte(n);
	      paramPacketDataSerializer.writeByte(i1);
	    } 
	    paramPacketDataSerializer.writeFloat(this.f);
	    paramPacketDataSerializer.writeFloat(this.g);
	    paramPacketDataSerializer.writeFloat(this.h);
	  }
	  
	  public void a(PacketListenerPlayOut paramPacketListenerPlayOut) {
	    paramPacketListenerPlayOut.a(this);
	  }
	}
