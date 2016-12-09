package me.DevJochem.Hub.listeners;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.DevJochem.Hub.Main;

public class Selector implements Listener {

	public static Inventory server = Bukkit.getServer().createInventory(null, 27, "§c§lCrixion Servers");

	static {
		createButton(Material.DIAMOND_BLOCK, server, 10, "§b§lMine§f§lLive", null);
		createButton(Material.DIAMOND_SWORD, server, 11, "§c§lFact§f§lions", "§fSurvival and raid with your friends!");
		createButton(Material.ENDER_STONE, server, 12, "§a§lWI§f§lDM", null);



	}

	private Main plugin;

	public Selector(Main instance) {
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
	public static void openMenu(Player p) {
		p.openInventory(server);
	}

	@EventHandler
	public void Compass(PlayerInteractEvent e) {

		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (e.getPlayer().getItemInHand().getType().equals(Material.COMPASS)) {
				
				openMenu(e.getPlayer());
				
			}
		}

	}

	@EventHandler
	public void click(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inv = e.getInventory();

		if (inv.getName().equals(server.getName())) {
			if (clicked.getType() == Material.DIAMOND_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("MineLive");
				p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}

			if (clicked.getType() == Material.DIAMOND_SWORD) {
				e.setCancelled(true);
				p.closeInventory();

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("Factions");
				p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}
			if (clicked.getType() == Material.ENDER_STONE) {
				e.setCancelled(true);
				p.closeInventory();

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("WIDM");
				p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}
		}
	}



}