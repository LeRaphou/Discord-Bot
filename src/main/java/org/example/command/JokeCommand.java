package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.Random;

public class JokeCommand implements ICommand {
    private static final String[] JOKES = {
        "Pourquoi les plongeurs plongent-ils toujours en arrière et jamais en avant? Parce que sinon ils tombent dans le bateau!",
        "Quel est le comble pour un électricien? De ne pas être au courant!",
        "Qu'est-ce qu'un crocodile qui surveille la pharmacie? Un Lacoste-guard!",
        "Comment appelle-t-on un chat tombé dans un pot de peinture le jour de Noël? Un chat-peint de Noël!"
    };

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Random random = new Random();
        String randomJoke = JOKES[random.nextInt(JOKES.length)];
        event.getChannel().sendMessage("😂 " + randomJoke).queue();
    }

    @Override
    public String getName() {
        return "joke";
    }

    @Override
    public String getDescription() {
        return "Raconte une blague aléatoire";
    }
}
