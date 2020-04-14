package slava.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Filter extends  ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	       if(FilterOnOff.filterOn){
	            String[] LIST_OF_BAD_WORDS = {"����", "����", "�����","�����","������",
	            		"�����", "����", "�����", "�����", "�����","���",
	            		"�����","������","��������","�������","��������","������","�����","������","������",
	            		"������","��������", "��������", "������", "�������", "�������", "�����"
	            		,"������", "�������", "����", "�������", "���", "������", "��������", "�����"};
	            String[] message = event.getMessage().getContentRaw().split(" ");
	            for(int i = 0;i < message.length;i++){
	                boolean badWord = false;
	       	                for(int b = 0; b < LIST_OF_BAD_WORDS.length;b++){
	                    if (message[i].equalsIgnoreCase(LIST_OF_BAD_WORDS[b])){
	                   event.getMessage().delete().queue();
	                        badWord = true;
	                        if(FilterMessage.allowed){ 
	                            event.getChannel().sendMessage("�� ���������! " + event.getMember().getUser().getName()).queue();
	                        }
	                    }
	                }
	                System.out.println(message[i] + " " + badWord); 
	            }
	        }
	    }
	}