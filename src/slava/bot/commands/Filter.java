package slava.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Filter extends  ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	       if(FilterOnOff.filterOn){
	            String[] LIST_OF_BAD_WORDS = {"жопа", "анус", "мудак","уебан","пиздец",
	            		"нигер", "сука", "ебень", "блядь", "уебок","хуй",
	            		"пидор","блядун","выблядок","блядина","ебалнище","гандон","блять","долбоёб","хуерга",
	            		"пиздюк","хуйлопан", "ахуевать", "ахуеть", "пиздить", "пиздеть", "уебан"
	            		,"нихуёва", "нихуйно", "хуёво", "наебать", "наёб", "уебать", "уебаться", "пизда"};
	            String[] message = event.getMessage().getContentRaw().split(" ");
	            for(int i = 0;i < message.length;i++){
	                boolean badWord = false;
	       	                for(int b = 0; b < LIST_OF_BAD_WORDS.length;b++){
	                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[b])){
	                   event.getMessage().delete().queue();
	                        badWord = true;
	                        if(FilterMessage.allowed){ 
	                            event.getChannel().sendMessage("НЕ ВЫРАЖАЙСЯ! " + event.getMember().getUser().getName()).queue();
	                        }
	                    }
	                }
	                System.out.println(message[i] + " " + badWord); 
	            }
	        }
	    }
	}