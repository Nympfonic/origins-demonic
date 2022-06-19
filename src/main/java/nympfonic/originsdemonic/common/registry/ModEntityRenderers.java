package nympfonic.originsdemonic.common.registry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import nympfonic.originsdemonic.common.OriginsDemonic;

public class ModEntityRenderers {
    public static void init() {
        EntityRendererRegistry.register(OriginsDemonic.SuccubusCharmOrbEntityType, (context) -> new FlyingItemEntityRenderer<>(context));
    }
}
