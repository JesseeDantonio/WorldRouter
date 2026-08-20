package fr.jessee.worldRouter;

import fr.jessee.worldRouter.iface.WRProvider;
import org.bukkit.World;

import java.util.Optional;

public class WorldRouterCore implements WRProvider {

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

        this.setWorld(world.get());
        return true;
    }

    public Optional<World> getWorld() {
        return Optional.ofNullable(world);
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
