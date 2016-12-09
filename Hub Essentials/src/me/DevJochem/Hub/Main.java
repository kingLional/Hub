package me.DevJochem.Hub;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.DevJochem.Hub.listeners.DoubleJump;
import me.DevJochem.Hub.listeners.Launchpad;
import me.DevJochem.Hub.listeners.Selector;
import me.DevJochem.Hub.listeners.Settings;
import me.DevJochem.Hub.listeners.SpawnTP;
import me.DevJochem.Hub.listeners.Weather;
import me.DevJochem.Hub.listeners.nomessage;
import me.DevJochem.Hub.listeners.playerhide;
import me.DevJochem.Hub.listeners.spawnitems;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
	 public final Selector mbl = new Selector(this);
	private static Plugin plugin;
	public void onEnable() {
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		plugin = this;
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
		registerEvents(this, new spawnitems(this));
		registerEvents(this, new Launchpad(this));
		registerEvents(this, new SpawnTP(this));
		registerEvents(this, new Selector(this));
		registerEvents(this, new DoubleJump(this));
		registerEvents(this, new Settings(this));
		registerEvents(this, new nomessage(this));
		registerEvents(this, new Weather(this));
		registerEvents(this, new playerhide(this));
		Bukkit.getPluginManager().registerEvents((Listener)listener, this);
	}

	public void onDisable() {
		plugin = null;
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ef")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                mbl.openMenu(p);
            }
        }
        return false;
    }

	public static Plugin getPlugin() {
		return plugin;
	}
	
	private final Launchpad listener = new Launchpad(this);
	public final Logger logger = Logger.getLogger("Minecraft");
}
