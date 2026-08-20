package fr.jessee.worldRouter;

import org.bukkit.World;

import java.util.Optional;

public class WorldRouterCore {

    private World world;

    public WorldRouterCore(final World world) {
        this.world = world;
    }

    public boolean restart() {
        WorldRouter.getConfigFile().reload();
        Optional<World> world = WorldRouter.loadWorld();
        if(world.isEmpty()) {
            return false;
        }

        WorldRouter.getWorldRouterCore().setWorld(world.get());
        return true;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
