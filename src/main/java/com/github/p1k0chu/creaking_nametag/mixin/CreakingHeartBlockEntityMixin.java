package com.github.p1k0chu.creaking_nametag.mixin;

import net.minecraft.block.entity.CreakingHeartBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreakingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;

@Mixin(CreakingHeartBlockEntity.class)
public class CreakingHeartBlockEntityMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/CreakingHeartBlockEntity;killPuppet(Lnet/minecraft/entity/damage/DamageSource;)V"))
    private static void killIfNotPersistent(CreakingHeartBlockEntity instance, DamageSource damageSource) {
        Optional<CreakingEntity> optional = instance.getCreakingPuppet();

        if(optional.isPresent()) {
            if(optional.get().isPersistent()) {
                return;
            }
        }

        instance.killPuppet(damageSource);
    }
}
