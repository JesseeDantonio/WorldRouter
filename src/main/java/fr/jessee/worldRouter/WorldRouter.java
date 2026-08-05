package fr.jessee.worldRouter;

import fr.jessee.worldRouter.feature.ConfigFile;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldRouter extends JavaPlugin {
    private static Plugin instance;
    private static ConfigFile configFile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        configFile = new ConfigFile("config");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static WorldRouter getInstance() {
        if (instance == null) {
            throw new IllegalStateException("The WorldRouter plugin is not yet initialized.");
        }
        return (WorldRouter) instance;
    }

    public static ConfigFile getConfigFile() {
        return configFile;
    }
}
