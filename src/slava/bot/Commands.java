package slava.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if (args[0].equalsIgnoreCase(LabBot.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("LabBot information");
			info.setDescription(" Привет, это ЛабБот. Я работаю у Славы за еду. У меня в запасе есть некоторые возможности.	 Введи ~clear для удаления сообщений, ~togglefilter для активации фильтра нецензурной лексики, ~filtermessage для активации предупреждения о том, чтобы вы следили за языком , ~calculate для подсчёта чисел. Удачи! ");
			info.setColor(0xf45642);
			info.setFooter("Created by Vyacheslav", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}
