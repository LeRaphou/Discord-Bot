package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DiscordCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        String discordLink = "https://discord.gg/ton-lien-serveur";
        event.getChannel().sendMessage("🔗 Rejoins notre serveur Discord : " + discordLink).queue();
    }

    @Override
    public String getName() {
        return "discord";
    }

    @Override
    public String getDescription() {
        return "Affiche le lien du serveur Discord";
    }
}

