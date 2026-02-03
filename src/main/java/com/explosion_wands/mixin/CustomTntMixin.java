package com.explosion_wands.mixin;

import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Explosion.class)
public abstract class CustomTntMixin {
/*
    @Redirect(
        method = "destroyBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Explosion;destroyBlock(" +
                            "Lnet/minecraft/core/BlockPos;" +
                            "Z" +
                            "Lnet/minecraft/world/entity/Entity;" +
                            "I" +
                            ")Z"
            )
    )

    public boolean cancelDestroyBlockDrops(Level level, BlockPos pos, boolean dropResources, Entity breaker, int updateLimit) {
        if(breaker instanceof PrimedTnt) {
            return level.destroyBlock(pos, false, breaker, updateLimit);
        }
        return level.destroyBlock(pos, dropResources, breaker, updateLimit);
    }
 */
}
