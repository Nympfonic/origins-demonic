package nympfonic.originsdemonic.common.entities;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import nympfonic.originsdemonic.common.OriginsDemonic;
import nympfonic.originsdemonic.common.power.SuccubusCharmPower;

public class SuccubusCharmOrbEntity extends SmallFireballEntity {
    public SuccubusCharmOrbEntity(EntityType<? extends SmallFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    public SuccubusCharmOrbEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ) {
        super(world, owner, velocityX, velocityY, velocityZ);
    }

    public SuccubusCharmOrbEntity(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        //super.onEntityHit(entityHitResult);
        if (this.world.isClient) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();

        if (entity2 instanceof LivingEntity) {
            if (entity instanceof LivingEntity && entity.isAlive()) {
                PowerHolderComponent.getPowers(entity2, SuccubusCharmPower.class).forEach(scp -> {
                    if (scp.isValidTarget(entity.getType())) {
                        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(OriginsDemonic.CharmEffect, 500, 0), this.getEffectCause());
                    }
                });
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState blockState = this.world.getBlockState(blockHitResult.getBlockPos());
        blockState.onProjectileHit(this.world, blockState, blockHitResult, this);
    }
}
