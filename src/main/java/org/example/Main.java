package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main extends ListenerAdapter{

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder
                .createDefault("MTUwMTEyMzI0NDg1MjUxMDc0MA.GZ9VCp.kXZ8y25yGZ3c7VfgZU-SZwGR9-HeHg1SNRaqBE")
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("mon premier bot"))
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.awaitReady();

        System.out.println("✅ Bot connecté : " + jda.getSelfUser().getName());
        System.out.println("📡 Statut : " + jda.getStatus());
        System.out.println("🏓 Ping : " + jda.getGatewayPing() + "ms");
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        if(event.getAuthor().isBot())return;

        String message = event.getMessage().getContentRaw();

        if (message.equals("hi")){
            event.getChannel().sendMessage("je suis open minded").queue();
        }
    }
}