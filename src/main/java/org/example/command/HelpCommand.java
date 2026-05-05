package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        StringBuilder helpMessage = new StringBuilder("📚 **Commandes disponibles :** \n\n");

        for (ICommand command : CommandManager.getCommands().values()) {
            helpMessage.append("`!").append(command.getName()).append("` - ").append(command.getDescription()).append("\n");
        }

        event.getChannel().sendMessage(helpMessage.toString()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Affiche toutes les commandes disponibles";
    }
}
