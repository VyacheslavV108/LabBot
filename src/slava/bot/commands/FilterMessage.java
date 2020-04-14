package slava.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FilterMessage extends ListenerAdapter {
	 
    public static boolean allowed = false;
 
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(FilterOnOff.filterOn) {
            if  (event.getMessage().getContentRaw().equalsIgnoreCase("~filtermessage") && allowed) {
                EmbedBuilder usege = new EmbedBuilder();
				 usege.setColor(0xff3923);
				 usege.setTitle("Filter Has Been Disabled.");
				 usege.setDescription("By " + event.getMember().getUser().getName());
				 event.getChannel().sendMessage(usege.build()).queue();
                System.out.println("Disabled");
                allowed = false;
          
            } else if(event.getMessage().getContentRaw().equalsIgnoreCase("~filtermessage") && !allowed) {
                 EmbedBuilder usege = new EmbedBuilder();
				 usege.setColor(0x22ff2a);
				 usege.setTitle("Filter Has Been Enabled.");
				 usege.setDescription("By " + event.getMember().getUser().getName());
				 event.getChannel().sendMessage(usege.build()).queue();
                System.out.println("Enabled");
                allowed = true;
            }
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase("~filtermessage") && !FilterOnOff.filterOn){
            EmbedBuilder usege = new EmbedBuilder();
			 usege.setColor(0xff3923);
			 usege.setTitle(" Чтобы запустить фильтр, введите ~togglefilter.");
			 event.getChannel().sendMessage(usege.build()).queue();
            
        }
    }
}
