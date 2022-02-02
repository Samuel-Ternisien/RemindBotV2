package dev.remindBot.Utils.commands;

import dev.remindBot.Main;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandRemindList implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        try {
            User user2= Main.api.getUserById("126337300492713984").get();
            user2.sendMessage("test");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
