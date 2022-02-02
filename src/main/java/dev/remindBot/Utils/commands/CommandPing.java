package dev.remindBot.Utils.commands;

import org.javacord.api.event.message.MessageCreateEvent;

public class CommandPing implements CommandExecutor{

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getChannel().sendMessage("Pong!");
    }
}
