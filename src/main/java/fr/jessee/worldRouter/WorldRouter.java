package fr.jessee.worldRouter;

import fr.jessee.worldRouter.command.WRCommand;
import fr.jessee.worldRouter.feature.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public final class WorldRouter extends JavaPlugin {
    private static Plugin instance;
    private static ConfigFile configFile;
    private static ConfigFile langFile;
    private static WorldRouterCore worldRouterCore;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        configFile = new ConfigFile("config");
        langFile = new ConfigFile("lang");
        Optional<World> world = loadWorld();

        if (world.isEmpty()) {
            Bukkit.getConsoleSender().sendMessage("World not found. Please check the configuration.");
            Bukkit.getPluginManager().disablePlugin(WorldRouter.getInstance());
            return;
        }

        registerCommands();

        worldRouterCore = new WorldRouterCore(world.get());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static WorldRouterCore getWorldRouterCore() {
        return worldRouterCore;
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

    public static ConfigFile getLangFile() {
        return langFile;
    }

    private void registerCommands() {
        getCommand("wr").setExecutor(new WRCommand());
    }

    public static Optional<World> loadWorld() {
        WorldRouter.getConfigFile().reload();
        return Optional.ofNullable(Bukkit.getWorld(configFile.getString("worldName")));
    }
}
