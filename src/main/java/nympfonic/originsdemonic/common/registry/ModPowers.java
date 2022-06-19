package nympfonic.originsdemonic.common.registry;

import java.util.Collections;

import io.github.apace100.apoli.power.*;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nympfonic.originsdemonic.common.OriginsDemonic;
import nympfonic.originsdemonic.common.power.*;

public class ModPowers {
    public static final PowerFactory<Power> SUCCUBUS_CHARM = new PowerFactory<>(new Identifier(OriginsDemonic.MOD_ID, "succubus_charm"), new SerializableData().add("entity_types", SerializableDataType.list(SerializableDataTypes.ENTITY_TYPE), Collections.emptyList()).add("inverted", SerializableDataTypes.BOOLEAN, false), data -> (type, entity) -> new SuccubusCharmPower(type, entity, data.get("entity_types"), data.getBoolean("inverted"))).allowCondition();

    public static void init() {
        Registry.register(ApoliRegistries.POWER_FACTORY, SUCCUBUS_CHARM.getSerializerId(), SUCCUBUS_CHARM);
    }
}
