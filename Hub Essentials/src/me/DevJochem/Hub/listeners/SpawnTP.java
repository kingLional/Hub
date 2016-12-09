package me.DevJochem.Hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.DevJochem.Hub.Main;

public class SpawnTP implements Listener{
	
	private Main plugin;

	public SpawnTP(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Location spawntp = new Location(Bukkit.getWorld("world"), 570.5, 57, 943.5);
		p.teleport(spawntp);
	}
	
}
