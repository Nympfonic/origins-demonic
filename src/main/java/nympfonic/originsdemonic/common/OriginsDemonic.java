package nympfonic.originsdemonic.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nympfonic.originsdemonic.common.entities.SuccubusCharmOrbEntity;
import nympfonic.originsdemonic.common.registry.ModParticleTypes;
import nympfonic.originsdemonic.common.registry.ModPowers;

public class OriginsDemonic implements ModInitializer {
	public static final String MOD_ID = "originsdemonic";

	public static final EntityType<SuccubusCharmOrbEntity> SuccubusCharmOrbEntityType = FabricEntityTypeBuilder.<SuccubusCharmOrbEntity>create(SpawnGroup.MISC, SuccubusCharmOrbEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).trackRangeBlocks(10).trackedUpdateRate(10).build();

	public static final StatusEffect CharmEffect = new CharmedStatusEffect();

	@Override
	public void onInitialize() {
		ModParticleTypes.init();
		//ModSoundEvents.init();
		ModPowers.init();
		//ModConditions.init();
		Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "charmed"), CharmEffect);

		Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "succubus_charm_orb"), SuccubusCharmOrbEntityType);
		// initPackets();
		// initEvents();
	}

	// private void initPackets() {
	// 	ServerPlayNetworking.registerGlobalReceiver(ChangeRadialDirectionPacket.ID, ChangeRadialDirectionPacket::receive);
	// 	ServerPlayNetworking.registerGlobalReceiver(MountC2SPacket.ID, MountC2SPacket::receive);
	// }

	// private void initEvents() {
	// 	ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
	// 		if (PowerHolderComponent.hasPower(handler.player, MountPower.class)
	// 				&& handler.player.getVehicle() instanceof PlayerEntity) {
	// 			handler.player.dismountVehicle();
	// 		}
	// 	});
	// }
}
