package dev.remindBot;

import dev.remindBot.Utils.commands.MessageManager;
import dev.remindBot.Utils.configManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Main classes to run the bot with a listener
 * Running this main method connect the bot and give it ability to execute command registered in CommandRegistry static method
 */
public class Main {

    //attrs
    public static DiscordApi api;
    private static configManager configManager;


    public static void main(String[] args) {
        // Init the configManager which allows use to get the bot properties through all our classes
        configManager = new configManager(new File(System.getProperty("user.dir"), "config.toml"));

        // Init out bot and get the bot token through the configManager
        api = new DiscordApiBuilder()
                .setToken(configManager.getToml().getString("bot.token"))
                .login().join();

        // Add a listener for the bot { read the comments on MessageManager classes for more information }
        api.addMessageCreateListener(MessageManager::create);

        /**
        while (true) {
            LocalDate jour = LocalDate.now();
            LocalTime heure = LocalTime.now(Clock.system(ZoneId.of("UTC+1")));
            boolean matin = (heure.getHour() == 9) && (heure.getMinute() == 0) && (heure.getSecond() == 0);
            boolean soir = (heure.getHour() == 17) && (heure.getMinute() == 0) && (heure.getSecond() == 0);
            if (matin || soir) {}
        }
         */
    }


    //Getter
    public static dev.remindBot.Utils.configManager getConfigManager() {
        return configManager;
    }
}
