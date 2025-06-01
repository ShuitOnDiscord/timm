package com.github.charlyb01.timm.client.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.sound.MusicInstance;

public class SkipCmd {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("skip")
                .requires(fabricClientCommandSource -> true)
                .executes(SkipCmd::skip));

        dispatcher.register(ClientCommandManager.literal("next")
                .requires(fabricClientCommandSource -> true)
                .executes(SkipCmd::skip));
    }

    private static int skip(CommandContext<FabricClientCommandSource> context ) {
        context.getSource().getClient().getMusicTracker().stop();
        MusicInstance musicInstance = context.getSource().getClient().getMusicInstance();
        if (musicInstance.music() != null) {
            context.getSource().getClient().getMusicTracker().play(musicInstance);
        }
        return Command.SINGLE_SUCCESS;
    }
}
