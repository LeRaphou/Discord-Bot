package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        long ping = event.getJDA().getGatewayPing();
        event.getChannel().sendMessage("🏓 Pong! Latence: `" + ping + "ms`").queue();
    }

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Affiche la latence du bot";
    }
}
