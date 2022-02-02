package dev.remindBot.Utils.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Command registry that stores all the possible commands in a ArrayList
 */

public class CommandRegistry {

    // Attrs
    private ArrayList<Command> commands;

    // Constructor
    public CommandRegistry(){
        this.commands= new ArrayList<>();
    }

    // Add a command in the array
    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    // Remove a command using the id
    public void removeCommand(String id){
        commands.removeIf((cmd) -> cmd.getId().equalsIgnoreCase(id));
    }

    // Return a command from an alias
    public Optional<Command> getByAlias(String alias){
        for (Command command : commands) {
            if (Arrays.asList(command.getAliases()).contains(alias)){
                return Optional.of(command);
            }
        }
    
        return Optional.empty();
    }
}
