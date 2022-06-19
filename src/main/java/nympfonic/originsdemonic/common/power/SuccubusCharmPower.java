package nympfonic.originsdemonic.common.power;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

public class SuccubusCharmPower extends Power {
    private final Set<EntityType<?>> entityTypes = new HashSet<>();
    private final boolean inverted;

    public SuccubusCharmPower(PowerType<?> type, LivingEntity entity, List<EntityType<?>> entityTypes, boolean inverted) {
        super(type, entity);
        this.entityTypes.addAll(entityTypes);
        this.inverted = inverted;
    }
    
    public boolean isValidTarget(EntityType<?> entityType) {
        if (inverted) {
            return !entityTypes.contains(entityType);
        }
        return entityTypes.contains(entityType);
    }
}
