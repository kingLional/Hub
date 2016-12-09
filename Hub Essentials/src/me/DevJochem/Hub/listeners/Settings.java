package me.DevJochem.Hub.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.DevJochem.Hub.Main;

public class Settings implements Listener {


	private Main plugin;

	public Settings(Main instance) {
		plugin = instance;
	}

	public void onJoin(PlayerJoinEvent e) {
		
	}
	
}