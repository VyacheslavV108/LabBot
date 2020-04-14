package slava.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import slava.bot.LabBot;

public class HelloEvent extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName(); 
        if(args[0].equalsIgnoreCase(LabBot.prefix + "hi")){
            if(!event.getMember().getUser().isBot()){ 
                event.getChannel().sendMessage("hi " + name).queue(); 
            }
        }
    }
}

