package org.L2X9.BungeeTest;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ForceCommand extends Command {
	
	public static ArrayList<String> activeList = new ArrayList<>();
	public static ProxiedPlayer player;
	public ForceCommand(String name) {
		super("forceauth");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ServerInfo auth = ProxyServer.getInstance().getServerInfo("auth");
			ServerInfo l2x9 = ProxyServer.getInstance().getServerInfo("l2x9");
			 player = (ProxiedPlayer)sender;
			if (args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error:&r&c Please include atleast one argument /forceauth <on/off>&r"));				
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
				if (player.getServer() == l2x9) {
					player.connect(auth);
					activeList.add(player.getName());
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You just turned forceauth:&r&a ON"));
				 }else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error:&r&c You must be on the main server to execute this command&r"));
					 
				 }
				}
				if (args[0].equalsIgnoreCase("off")) {
					activeList.remove(player.getName());
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You just turned forceauth:&r&a OFF"));
	}			
   }
  }else {
   sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error:&r&c You must be a player to execute this command&r"));
  }
 }
}