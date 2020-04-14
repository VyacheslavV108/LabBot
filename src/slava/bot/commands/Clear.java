package slava.bot.commands;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
//import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.lang.IllegalArgumentException;
import slava.bot.LabBot;

public class Clear extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(LabBot.prefix + "clear")) {
			if(args.length < 2) {
				//TO MANY MESSAGES
				EmbedBuilder usege = new EmbedBuilder();
				 usege.setColor(0xff3923);
				 usege.setTitle("������� ���������� ��� ��������");
				 usege.setDescription("Usage: " + LabBot.prefix+ "clear [# of messages]");
				 event.getChannel().sendMessage(usege.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					//�������
					EmbedBuilder success = new EmbedBuilder();
					 success.setColor(0x22ff2a);
					 success.setTitle("������� ������� " + args[1]+ " ���������");
					 success.setDescription("Usage: " + LabBot.prefix+ "clear [# of messages]");
					 event.getChannel().sendMessage(success.build()).queue();
				}
				catch(IllegalArgumentException e) {
					if(e.toString().startsWith("net.dv8tion.jda.api.exceptions.InsufficientPermissionException")) {
						//����� ����� ��������� �������
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("������� ����� ����� ���������");
						error.setDescription("��������� ����� ���� ������� � ������ �� 1-100.");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
					else {
						//��������� �������� � �� ������ �������
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("���� ������� ��������� 2-�� ��������� ��������");
						error.setDescription("��������� 2-�� ��������� �������� �� ���� ���� ������� .");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
				}
			}
		}	
	}
}
