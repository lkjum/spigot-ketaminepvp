
package net.minecraft.server;

import com.google.common.base.Function;

final class DisplayStateFunctionMonsterEggVarient implements Function {

	DisplayStateFunctionMonsterEggVarient() {}
    public ItemStack a(ItemStack object) {
        return object;
    }
    public Object apply(Object object) {
        return this.a((ItemStack) object);
    }
}