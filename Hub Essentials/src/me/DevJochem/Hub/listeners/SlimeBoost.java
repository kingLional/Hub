package me.DevJochem.Hub.listeners;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.DevJochem.Hub.Main;

public class SlimeBoost implements Listener{
	
	private Main plugin;
	
	public SlimeBoost(Main instance) {
		plugin = instance;
	}
	
	 @EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {

		if(e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.SLIME_BLOCK) {
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
			e.getPlayer().setVelocity(new Vector(e.getPlayer().getLocation().getX(), 1.0D, e.getPlayer().getLocation().getZ()));
		}






	}
}
