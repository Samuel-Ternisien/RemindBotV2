package dev.remindBot.Utils.commands;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

/**
 * Command created to test how embed messages works with the API
 */
public class CommandEmbed implements CommandExecutor{
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        EmbedBuilder embed= new EmbedBuilder()
                .setTitle("Test") // Set the title of the embed message
                .setDescription("Ceci est un test") // Set the description
                .setAuthor("Mizuwari") // Set the author
                .addField("Field 1","Value 1") // Add a new field with value "Value 1"
                .setColor(Color.GREEN) // Set the color of the text
                .setFooter("Test Footer"); // Set a footer for the embed message
        event.getChannel().sendMessage(embed);
    }
}
