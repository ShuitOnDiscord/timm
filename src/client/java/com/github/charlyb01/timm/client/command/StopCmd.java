package com.github.charlyb01.timm.client.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class StopCmd {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("stop")
                .requires(fabricClientCommandSource -> true)
                .executes(StopCmd::stop));
    }

    private static int stop(CommandContext<FabricClientCommandSource> context ) {
        if (NowPlayingCmd.SONG_ID == null) {
            context.getSource().sendFeedback(Text.translatable("cmd.stop.none"));
        } else {
            context.getSource().sendFeedback(Text.translatable("cmd.stop"));
            context.getSource().getClient().getMusicTracker().stop();
        }
        return Command.SINGLE_SUCCESS;
    }
}
