package dev.remindBot;

import dev.remindBot.Utils.commands.MessageManager;
import dev.remindBot.Utils.configManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;

public class Main {

    private static DiscordApi api;
    private static configManager configManager;


    public static void main(String[] args) {

        configManager = new configManager(new File(System.getProperty("user.dir"),"config.toml"));

        api= new DiscordApiBuilder()
                .setToken(configManager.getToml().getString("bot.token"))
                .login().join();

        api.addMessageCreateListener(MessageManager::create);

    }

    public static dev.remindBot.Utils.configManager getConfigManager() {
        return configManager;
    }
}
