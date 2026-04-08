package net.continuousmusic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.continuousmusic.ContinuousMusicMod;
import net.minecraft.client.render.GameRenderer;

@Mixin(value = GameRenderer.class)
public class GameRendererMixin {

	@Inject(method = "render", at = @At("TAIL"))
	private void onRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
		if (!ContinuousMusicMod.ENABLE_TICK_THREAD) {
			ContinuousMusicMod.tickChannel();
		}
	}

}
