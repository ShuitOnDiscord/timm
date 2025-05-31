package com.github.charlyb01.timm.client.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NowPlayingCmd {
    public static Identifier SONG_ID;

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("nowplaying")
                .requires(fabricClientCommandSource -> true)
                .executes(NowPlayingCmd::nowPlaying));

        dispatcher.register(ClientCommandManager.literal("np")
                .requires(fabricClientCommandSource -> true)
                .executes(NowPlayingCmd::nowPlaying));
    }

    private static int nowPlaying(CommandContext<FabricClientCommandSource> context ) {
        context.getSource().sendFeedback(Text.translatable("record.nowPlaying", NowPlayingCmd.SONG_ID));
        return Command.SINGLE_SUCCESS;
    }
}
