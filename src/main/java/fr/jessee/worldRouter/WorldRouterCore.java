package fr.jessee.worldRouter;

import org.bukkit.World;

import java.util.Optional;

public class WorldRouterCore {

    private World world;

    public WorldRouterCore(final World world) {
        this.world = world;
    }

    public void restart() {
        WorldRouter.getConfigFile().reload();
        Optional<World> world = WorldRouter.loadWorld();
        if(world.isEmpty()) {
            return;
        }

        WorldRouter.getWorldRouterCore().setWorld(world.get());
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
