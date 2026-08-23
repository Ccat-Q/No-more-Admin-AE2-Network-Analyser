package com.ccatq.nomoreadminae2.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * AE2 Network Analyser normally allows tick profiling only in single-player or
 * when the requesting player is a server operator. This compatibility patch
 * deliberately grants that one permission to every connected player.
 */
@Mixin(targets = "com.glodblock.github.ae2netanalyser.common.me.ticker.RequestBox", remap = false)
abstract class RequestBoxMixin {
    @Inject(method = "checkPermission", at = @At("HEAD"), cancellable = true, remap = false)
    private static void noMoreAdmin$allowTickProfiler(Player player,
                                                       CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(true);
    }
}
