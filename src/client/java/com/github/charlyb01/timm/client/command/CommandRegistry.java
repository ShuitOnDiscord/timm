package com.github.charlyb01.timm.client.command;

import com.github.charlyb01.timm.Timm;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class CommandRegistry {
    public static void init() {
        Timm.LOGGER.info("Registering commands");

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            NowPlayingCmd.register(dispatcher);
            OpenConfigCmd.register(dispatcher);
        });

        Timm.LOGGER.info("Commands successfully registered");
    }
}
