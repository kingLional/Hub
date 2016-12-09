package me.DevJochem.Hub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import me.DevJochem.Hub.Main;

public class Weather implements Listener {

	private Main plugin;
	
	public Weather(Main instance) {
		plugin = instance;
	}
	@EventHandler
	  public void onWeatherChange(WeatherChangeEvent event)
	  {
	    if (event.toWeatherState()) {
	      event.setCancelled(true);
	    }
	  }

}
