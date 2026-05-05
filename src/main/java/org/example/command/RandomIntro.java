package org.example.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class RandomIntro implements ICommand {

    private static final String[] intro = {
            "https://www.youtube.com/watch?v=WO-qVfxc3ZQ",
            "https://www.youtube.com/watch?v=04yykUQ2cMs",
            "https://www.youtube.com/watch?v=eanhC7tVP-k",
            "https://www.youtube.com/watch?v=PCeUEEZq3nI",
            "https://www.youtube.com/watch?v=cRj-7EIlHN0",
            "https://www.youtube.com/watch?v=dYUV3i6-AGs",
            "https://www.youtube.com/watch?v=WZz_jniDN3Q&list=RDWZz_jniDN3Q&start_radio=1",

    };

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Random random = new Random();
        String randomIntro = intro[random.nextInt(intro.length)];
        event.getChannel().sendMessage("😂 " + randomIntro).queue();
    }

    @Override
    public String getName() {
        return "intro";
    }

    @Override
    public String getDescription() {
        return "Met un lien d'intro aléatoire";
    }
}



