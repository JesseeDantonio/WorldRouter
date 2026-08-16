package fr.jessee.worldRouter;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Optional;

public class WorldRouterCore {

    private World world;

    public WorldRouterCore(final World world) {
        this.world = world;
    }

    public void start() {

    }

    public void stop() {

    }

    public void restart() {
        Optional<World> world = Optional.ofNullable(Bukkit.getWorld(WorldRouter.getConfigFile().getString("worldName")));
        if (world.isEmpty()) return;

        setWorld(world.get());
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
