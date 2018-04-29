package io.github.li_sp.deathquotes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

public class DeathQuotes extends JavaPlugin {

	public ConfigAccessor configAccessor;
	public ArrayList<String> quotes;

	@Override
	public void onEnable() {
		saveResource("deathquotes.txt", false);
		configAccessor = new ConfigAccessor(this);
		quotes = new ArrayList<>();
		loadQuotes();
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
		getLogger().info("Enabled DeathQuotes");
	}

	public void loadQuotes() {
		quotes.clear();
		try {
			FileInputStream input = new FileInputStream(getDataFolder().getAbsolutePath() + "/deathquotes.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				quotes.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
