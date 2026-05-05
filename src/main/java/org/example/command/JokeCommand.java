package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.api.JokeAPI;

public class JokeCommand implements ICommand {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        JokeAPI.Joke joke = JokeAPI.getRandomJoke();

        if (joke != null) {
            event.getChannel().sendMessage("😂 " + joke).queue();
        } else {
            event.getChannel().sendMessage("❌ Impossible de récupérer une blague en ce moment.").queue();
        }
    }

    @Override
    public String getName() {
        return "joke";
    }

    @Override
    public String getDescription() {
        return "Raconte une blague aléatoire (depuis une API)";
    }
}
