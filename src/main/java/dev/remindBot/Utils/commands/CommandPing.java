package dev.remindBot.Utils.commands;

import org.javacord.api.event.message.MessageCreateEvent;

/**
 * Pinging command to try out event class and the possibility
 */
public class CommandPing implements CommandExecutor{

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getChannel().sendMessage("Pong!");
        // getChannel retrieve the channel where the command was sent
        // sendMessage send a specified message in a channel object ( retrieved using getchannel on an event object
    }
}
