package io.github.li_sp.deathquotes;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

	private DeathQuotes plugin;
	private Random random;

	public PlayerDeathListener(DeathQuotes plugin) {
		this.plugin = plugin;
		random = new Random();
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		String message = plugin.configAccessor.message;
		int index = random.nextInt(plugin.quotes.size());
		String quote = plugin.quotes.get(index);
		message = message.replace("%q", quote);
		if (plugin.configAccessor.victimOnly) {
			event.getEntity().sendMessage(message);
		} else {
			plugin.getServer().broadcastMessage(message);
		}
	}

}
