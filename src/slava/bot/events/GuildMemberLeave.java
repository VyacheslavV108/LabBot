package slava.bot.events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberLeave extends ListenerAdapter{
	String[] messages = {
			"[member] left. Goodbye.",
		
	};
	
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0xff3923);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
  }
}
