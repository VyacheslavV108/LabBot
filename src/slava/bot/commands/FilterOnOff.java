package slava.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterOnOff extends ListenerAdapter {
	 
    public static boolean filterOn = true;
 
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    	 if (event.getMessage().getContentRaw().equalsIgnoreCase("~Onfilter") && filterOn){
             filterOn = false;
             EmbedBuilder toggle = new EmbedBuilder();
             toggle.setColor(0xff3923);
             toggle.setTitle("The Curse-Filter has been disabled.");
             toggle.setDescription("By " + event.getMember().getUser().getName());
			 event.getChannel().sendMessage(toggle.build()).queue();
         }else if(event.getMessage().getContentRaw().equalsIgnoreCase("~Offfilter") && !filterOn){
             filterOn = true;
             EmbedBuilder togglen = new EmbedBuilder();
             togglen.setColor(0x22ff2a);
             togglen.setTitle("The Curse-Filter has been enabled.");
             togglen.setDescription("By " + event.getMember().getUser().getName());
			 event.getChannel().sendMessage(togglen.build()).queue();
         }
     }
 }
