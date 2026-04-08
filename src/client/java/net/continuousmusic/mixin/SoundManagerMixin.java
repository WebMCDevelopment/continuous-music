package net.continuousmusic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.continuousmusic.access.SoundManagerAccess;
import net.continuousmusic.access.SoundSystemAccess;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.SoundSystem;

@Mixin(value = SoundManager.class)
public class SoundManagerMixin implements SoundManagerAccess {

	@Shadow
	private SoundSystem soundSystem;
	
	@Override
	public boolean isSoundSystemStarted() {
		SoundSystemAccess soundSystemAccess = (SoundSystemAccess) soundSystem;
		
		return soundSystemAccess.isStarted();
	}
}
