package org.L2X9.BungeeTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class Main extends Plugin {
	  public ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
	  public static Map<String, Integer> violationMap = new ConcurrentHashMap<>();
	  public Configuration config;
	@Override
	public void onEnable() {
		getLogger().info("Test Plugin enabled");
		getProxy().getPluginManager().registerListener(this, new Events());
		getProxy().getPluginManager().registerCommand(this, new ForceCommand("forceauth"));

}}
	
