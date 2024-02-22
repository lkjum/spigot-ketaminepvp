
package net.minecraft.server;

import com.google.common.base.Function;

final class DisplayStateFunctionAcidVariant implements Function {

    DisplayStateFunctionAcidVariant() {}

	public String a(ItemStack object) {
		
		return EnumAcidVariant.byMetadata(object.getData()).getUnlocalizedName();
	}

	@Override
	public Object apply(Object object) {
		
		return this.a((ItemStack) object);
	}
}
