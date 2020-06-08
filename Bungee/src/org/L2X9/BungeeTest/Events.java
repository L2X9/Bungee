package org.L2X9.BungeeTest;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerConnectEvent.Reason;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {
	@EventHandler
	public void onJoin(ServerConnectEvent event) {
		ServerInfo l2x9 = ProxyServer.getInstance().getServerInfo("l2x9");
		ServerInfo queue = ProxyServer.getInstance().getServerInfo("queue");
		if (ForceCommand.activeList.contains(event.getPlayer().getName())) {
			if (!(event.getPlayer().getServer() == queue)) {
				if (event.getPlayer().getServer() == l2x9) {
					if (event.getReason() == Reason.PLUGIN) {
						event.setCancelled(true);
						
					}
						
					
				}
			}
			
		}
	}
}
