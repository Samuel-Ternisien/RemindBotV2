package dev.remindBot.Utils.commands;

import dev.remindBot.Main;
import org.javacord.api.event.message.MessageCreateEvent;

import javax.crypto.CipherInputStream;
import java.util.Arrays;

/**
 * Manage all messages received by the bot
 * Declare all the command the bot can receive and executes
 */

public class MessageManager {

    // Registry of command
    private static CommandRegistry registry = new CommandRegistry();

    // Create all the existing command
    static {
        registry.addCommand(new Command(
                "ping",
                "ping the bot",
                new CommandPing(),
                "ping","p?"
        ));

        registry.addCommand(new Command(
                "Embed",
                "Test embed",
                new CommandEmbed(),
                "test","embed"
        ));

        registry.addCommand(new Command(
                "RemindAdd",
                "Permet de rajouter un rappel",
                new CommandRemindAdd(),
                "r","remindAdd","radd","ra"
        ));

        registry.addCommand(new Command(
                "RemindDelete",
                "Permet de supprimer un rappel",
                new CommandRemindDel(),
                "rd","remindDelete","rdel"
        ));

        registry.addCommand(new Command(
                "RemindList",
                "Permet de consulter la liste des commandes",
                new CommandRemindList(),
                "rl","remindList","rlist"
        ));

    }


    // Get the bot PREFIX from the configManager
    private static final String PREFIX = Main.getConfigManager().getToml().getString("bot.prefix");

    // Method that receive message and treat them if the prefix is the required one
    public static void create(MessageCreateEvent event){
        if (event.getMessageContent().startsWith(PREFIX)){
            String[] args = event.getMessageContent().split(" ");
            String commandName = args[0].substring(PREFIX.length());
            args=args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);

            String[] finalArgs = args;
            registry.getByAlias(commandName).ifPresent((cmd) -> {
                cmd.getExecutor().run(event, cmd, finalArgs);
            });
        }
    }
}
