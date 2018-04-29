package io.github.li_sp.deathquotes;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigAccessor {

	public boolean victimOnly = false;
	public String message = "\"%q\"";

	public ConfigAccessor(DeathQuotes plugin) {
		FileConfiguration config = plugin.getConfig();

		config.addDefault("victim-only", victimOnly);
		config.addDefault("message", message);
		config.options().copyDefaults(true);

		config.options().header("DeathQuotes Configuration");
		config.options().copyHeader(true);

		plugin.saveConfig();

		victimOnly = config.getBoolean("victim-only");
		message = config.getString("message");
	}

}
