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
			info.setDescription(" ������, ��� ������. � ������� � ����� �� ���. � ���� � ������ ���� ��������� �����������.	 ����� ~clear ��� �������� ���������, ~togglefilter ��� ��������� ������� ����������� �������, ~filtermessage ��� ��������� �������������� � ���, ����� �� ������� �� ������ , ~calculate ��� �������� �����. �����! ");
			info.setColor(0xf45642);
			info.setFooter("Created by Vyacheslav", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}
