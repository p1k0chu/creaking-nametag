package com.github.p1k0chu.creaking_nametag.mixin;

import net.minecraft.entity.mob.CreakingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreakingEntity.class)
public class CreakingEntityMixin {
    @Inject(method = "canBeNameTagged", at = @At("HEAD"), cancellable = true)
    void canBeNameTagged(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
