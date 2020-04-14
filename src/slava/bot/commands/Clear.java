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
				 usege.setTitle("Укажите количество для удаления");
				 usege.setDescription("Usage: " + LabBot.prefix+ "clear [# of messages]");
				 event.getChannel().sendMessage(usege.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					//УСПЕШНО
					EmbedBuilder success = new EmbedBuilder();
					 success.setColor(0x22ff2a);
					 success.setTitle("Успешно удалено " + args[1]+ " Сообщений");
					 success.setDescription("Usage: " + LabBot.prefix+ "clear [# of messages]");
					 event.getChannel().sendMessage(success.build()).queue();
				}
				catch(IllegalArgumentException e) {
					if(e.toString().startsWith("net.dv8tion.jda.api.exceptions.InsufficientPermissionException")) {
						//ОЧЕНЬ МНОГО СООБЩЕНИЙ УКАЗАНО
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("Выбрано очень много сообщений");
						error.setDescription("Сообщения могут быть удалены в рамках от 1-100.");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
					else {
						//СООБЩЕНИЯ УСТАРЕЛИ И ИХ НЕЛЬЗЯ УДАЛИТЬ
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("Были выбраны сообщения 2-ух недельной давности");
						error.setDescription("Сообщения 2-ух недельной давности не могу быть удалены .");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
				}
			}
		}	
	}
}
