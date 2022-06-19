package nympfonic.originsdemonic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import nympfonic.originsdemonic.common.registry.ModEntityRenderers;
import nympfonic.originsdemonic.common.registry.ModParticleTypes;

@Environment(EnvType.CLIENT)
public class OriginsDemonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityRenderers.init();
        ModParticleTypes.init();
        //initPackets();
    }

    // private void initPackets() {
        
    // }
}
