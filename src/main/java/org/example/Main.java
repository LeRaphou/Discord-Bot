package org.example;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.command.*;
import org.example.listener.CommandListener;


public class Main extends ListenerAdapter{

    public static void main(String[] args) throws Exception {


        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_TOKEN");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("❌ Token Discord non trouvé !");
        }

        CommandManager.registerCommand(new PingCommand());
        CommandManager.registerCommand(new HelpCommand());
        CommandManager.registerCommand(new JokeCommand());
        CommandManager.registerCommand(new DiscordCommand());
        CommandManager.registerCommand(new RandomIntro());



        JDA jda = JDABuilder
                .createDefault(token)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("!help pour les commandes"))
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new CommandListener())
                .build();

        jda.awaitReady();

        System.out.println("✅ Bot connecté : " + jda.getSelfUser().getName());
        System.out.println("📡 Statut : " + jda.getStatus());
        System.out.println("🏓 Ping : " + jda.getGatewayPing() + "ms");
        System.out.println("📚 Commandes disponibles : " + CommandManager.getCommands().size());
    }
}