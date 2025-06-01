package com.github.charlyb01.timm.client.command;

import com.github.charlyb01.timm.Timm;
import com.github.charlyb01.timm.config.ModConfig;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class CommandRegistry {
    public static void init() {
        if (ModConfig.get().general.debugLog) {
            Timm.LOGGER.info("Registering commands");
        }

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            HelpCmd.register(dispatcher);
            NowPlayingCmd.register(dispatcher);
            OpenConfigCmd.register(dispatcher);
            SkipCmd.register(dispatcher);
            StopCmd.register(dispatcher);
        });
    }
}
