package com.github.charlyb01.timm.client.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class HelpCmd {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("timmhelp")
                .requires(fabricClientCommandSource -> true)
                .executes(HelpCmd::help));
    }

    private static int help(CommandContext<FabricClientCommandSource> context ) {
        Text cfg = Text.literal("\n/cfg ")
                .append(Text.translatable("cmd.help.cfg"));
        Text np = Text.literal("\n/nowplaying /np ")
                .append(Text.translatable("cmd.help.nowPlaying"));
        Text skip = Text.literal("\n/skip /next ")
                .append(Text.translatable("cmd.help.skip"));
        Text stop = Text.literal("\n/timmstop /stp ")
                .append(Text.translatable("cmd.help.stop"));
        Text help = Text.translatable("cmd.help")
                .append(cfg)
                .append(np)
                .append(skip)
                .append(stop);

        context.getSource().sendFeedback(help);
        return Command.SINGLE_SUCCESS;
    }
}
