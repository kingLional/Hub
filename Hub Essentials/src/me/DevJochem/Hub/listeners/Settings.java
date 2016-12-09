package me.DevJochem.Hub.listeners;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.DevJochem.Hub.Main;

public class Settings implements Listener {
	
	List<String>toggled = new ArrayList<String>();
	
	static boolean hideplayer = false;

	public static Inventory Settings = Bukkit.getServer().createInventory(null, 27, "§c§lCrixion Servers");

	static {
		if(hideplayer == true) {
			createButton(Material.ENDER_PEARL, Settings, 10, "§cHide alle spelers!", null);
		}

		if(hideplayer == false) {
			createButton(Material.EYE_OF_ENDER, Settings, 10, "§cShow alle spelers!", null);
		}

		createButton(Material.DIAMOND_SWORD, Settings, 11, "§c§lFact§f§lions", "§fSurvival and raid with your friends!");




	}

	private Main plugin;

	public Settings(Main instance) {
		plugin = instance;
	}



	public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = new ItemStack(mat);   
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		inv.setItem(Slot, item);
	}
	public static void openSettings(Player p) {
		p.openInventory(Settings);
	}

	@EventHandler
	public void Compass(PlayerInteractEvent e) {

		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (e.getPlayer().getItemInHand().getType().equals(Material.NETHER_STAR)) {

				openSettings(e.getPlayer());

			}
		}

	}

	@EventHandler
	public void click(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inv = e.getInventory();

		if (inv.getName().equals(Settings.getName())) {
			if (clicked.getType() == Material.ENDER_PEARL) {
				e.setCancelled(true);
				p.closeInventory();
				hideplayer = true;
			}
			if (clicked.getType() == Material.EYE_OF_ENDER) {
				e.setCancelled(true);
				p.closeInventory();
				hideplayer = false;

			}

			if (clicked.getType() == Material.DIAMOND_SWORD) {
				e.setCancelled(true);
				p.closeInventory();

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("Factions");
				p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}
		}
	}



}