package nympfonic.originsdemonic.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
	@Inject(method = "canTarget", at = @At("HEAD"), cancellable = true)
	private static void originsdemonic$charmDisableAggression(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {

	}

	@Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
	private static void originsdemonic$succubusCharm(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
		// PowerHolderComponent.getPowers(target, SuccubusCharmPower.class).forEach(succubusCharmPower -> {
		// 	if (succubusCharmPower.canBeCharmed(EntityType.PIGLIN)) {
		// 		cir.setReturnValue(true);
		// 	}
		// });
	}

	@Inject(method = "onGuardedBlockInteracted", at = @At("HEAD"), cancellable = true)
	private static void originsdemonic$succubusCharm(PlayerEntity player, boolean blockOpen, CallbackInfo ci) {
		// PowerHolderComponent.getPowers(player, SuccubusCharmPower.class).forEach(succubusCharmPower -> {
		// 	if (succubusCharmPower.canBeCharmed(EntityType.PIGLIN)) {
		// 		ci.cancel();
		// 	}
		// });
	}
}
