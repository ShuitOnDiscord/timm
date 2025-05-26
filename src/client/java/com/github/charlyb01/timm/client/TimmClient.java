package com.github.charlyb01.timm.client;

import com.github.charlyb01.timm.client.music.BiomePlaylist;
import com.github.charlyb01.timm.client.registry.SoundEventRegistry;
import net.fabricmc.api.ClientModInitializer;

public class TimmClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BiomePlaylist.init();
        SoundEventRegistry.init();
    }
}
