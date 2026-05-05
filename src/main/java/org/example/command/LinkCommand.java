package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class LinkCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        if (args.length == 0) {
            event.getChannel().sendMessage("❌ Usage: `!link <nom>`").queue();
            return;
        }

        String linkName = args[0].toLowerCase();
        String link = getLink(linkName);

        if (link != null) {
            event.getChannel().sendMessage("🔗 " + linkName + " : " + link).queue();
        } else {
            event.getChannel().sendMessage("❌ Lien non trouvé pour : `" + linkName + "`").queue();
        }
    }

    private String getLink(String name) {
        return switch (name) {
            case "google" -> "https://www.google.com";
            case "youtube" -> "https://www.youtube.com";
            default -> null;
        };
    }

    @Override
    public String getName() {
        return "link";
    }

    @Override
    public String getDescription() {
        return "Affiche un lien (usage: !link <google|youtube>)";
    }
}

