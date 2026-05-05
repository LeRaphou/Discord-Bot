package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static final Map<String, ICommand> commands = new HashMap<>();
    private static final String PREFIX = "!";
    
    public static void registerCommand(ICommand command) {
        commands.put(command.getName().toLowerCase(), command);
    }
    
    public static void handleMessage(MessageReceivedEvent event) {
        String messageContent = event.getMessage().getContentRaw();
        
        if (!messageContent.startsWith(PREFIX)) {
            return;
        }
        
        String[] parts = messageContent.substring(PREFIX.length()).split(" ");
        String commandName = parts[0].toLowerCase();
        String[] args = java.util.Arrays.copyOfRange(parts, 1, parts.length);
        
        if (commands.containsKey(commandName)) {
            commands.get(commandName).execute(event, args);
        } else {
            event.getChannel().sendMessage("❌ Commande non reconnue : `" + commandName + "`").queue();
        }
    }
    
    public static Map<String, ICommand> getCommands() {
        return commands;
    }
}
