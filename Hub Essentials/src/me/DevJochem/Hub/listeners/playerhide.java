package me.DevJochem.Hub.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.DevJochem.Hub.Main;

public class playerhide implements Listener {
	
	ArrayList<String> toggled = new ArrayList<String>();
	
	private Main plugin;

	public playerhide(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void Compass(PlayerInteractEvent e) {

		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (e.getPlayer().getItemInHand().getType().equals(Material.WATCH)) {
				
				if(toggled.contains(e.getPlayer().getName())) {
					toggled.remove(e.getPlayer().getName());
					hideAllPlayers(e.getPlayer());
					return;
				} else if(!toggled.contains(e.getPlayer().getName())) {
					toggled.add(e.getPlayer().getName());
					showAllPlayers(e.getPlayer());
					return;
				}
				
			}
		}

	}
	
	public void hideAllPlayers(Player player) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			player.hidePlayer(p);
		}
	}
	
	public void showAllPlayers(Player player) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			player.showPlayer(p);
		}
	}
	
	

}
