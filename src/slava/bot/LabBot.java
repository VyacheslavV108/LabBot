package slava.bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import slava.bot.commands.Calculate;
import slava.bot.commands.Clear;
import slava.bot.commands.Filter;
import slava.bot.commands.FilterMessage;
import slava.bot.commands.FilterOnOff;
import slava.bot.commands.HelloEvent;
import slava.bot.events.GuildMemberJoin;
import slava.bot.events.GuildMemberLeave;


public class LabBot {
	public static JDA jda;
	
	//ÇÀÄÀÅÌ ÁÎÒÓ ÏĞÅÔÈÊÑ ÄËß ÅÃÎ ÂÛÇÎÂÀ
	public static String prefix = "~";
	
	//ÃËÀÂÍÛÉ ÌÅÒÎÄ
	public static void main(String[] args ) throws LoginException{
		jda =  new JDABuilder(AccountType.BOT).setToken("your token").build();
		//ÄÅËÀÅÌ ÅÌÓ ÎÍËÀÉÍ ÑÒÀÒÓÑ
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		
		jda.addEventListener(new Commands());
		jda.addEventListener(new Clear());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMemberLeave());
		jda.addEventListener(new HelloEvent());
		jda.addEventListener(new Calculate());
		jda.addEventListener(new Filter());
		jda.addEventListener(new FilterMessage());
		jda.addEventListener(new FilterOnOff());
		
	}
}
