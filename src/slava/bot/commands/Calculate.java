package slava.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import slava.bot.LabBot;

public class Calculate extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] message = event.getMessage().getContentRaw().split(" ");
		
				
		if(message[0].equalsIgnoreCase(LabBot.prefix + "calculate") && message.length == 1) {
			event.getChannel().sendMessage("To use this command, type(without brackets): calculate[add/sub] [first-num] [second-num] ").queue();
		}else if (message[0].equalsIgnoreCase(LabBot.prefix + "calculate") && message[1].equalsIgnoreCase("add")) {
			int num1 = Integer.parseInt(message[2]);
			int num2 = Integer.parseInt(message[3]);
			event.getChannel().sendMessage(" results: " + (num1 + num2)).queue();
		}else if (message[0].equalsIgnoreCase(LabBot.prefix + "calculate") && message[1].equalsIgnoreCase("sub")) {
			int num1 = Integer.parseInt(message[2]);
			int num2 = Integer.parseInt(message[3]);
			event.getChannel().sendMessage(" results: " + (num1 - num2)).queue();
		}else if (message[0].equalsIgnoreCase(LabBot.prefix + "calculate") && message[1].equalsIgnoreCase("mult")) {
			int num1 = Integer.parseInt(message[2]);
			int num2 = Integer.parseInt(message[3]);
			event.getChannel().sendMessage(" results: " + (num1 * num2)).queue();
		}else if (message[0].equalsIgnoreCase(LabBot.prefix + "calculate") && message[1].equalsIgnoreCase("div")) {
			int num1 = Integer.parseInt(message[2]);
			int num2 = Integer.parseInt(message[3]);
			event.getChannel().sendMessage(" results: " + (num1 / num2)).queue();
		}
	}
}