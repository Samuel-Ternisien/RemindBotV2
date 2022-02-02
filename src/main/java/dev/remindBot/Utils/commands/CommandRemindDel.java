package dev.remindBot.Utils.commands;

import dev.remindBot.Main;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.concurrent.ExecutionException;


public class CommandRemindDel implements CommandExecutor {

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args){
        // Retrieve user via his message
        User user= event.getMessageAuthor().asUser().get();
        // send the user a message

    }
}
