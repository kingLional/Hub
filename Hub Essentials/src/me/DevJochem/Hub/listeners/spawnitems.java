package me.DevJochem.Hub.listeners;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.DevJochem.Hub.Main;

public class spawnitems implements Listener {

	
	private Main plugin;

	public spawnitems(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		
		ItemStack servers = new ItemStack(345);
		ItemMeta serversMeta = servers.getItemMeta();
		serversMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Servers");
		serversMeta.setLore(Arrays.asList(ChatColor.WHITE + "Switch servers quickly"));
		servers.setItemMeta(serversMeta);
		
		p.getInventory().setItem(4, servers);
	}
	
}
