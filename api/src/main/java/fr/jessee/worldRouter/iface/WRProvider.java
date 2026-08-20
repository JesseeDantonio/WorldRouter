package fr.jessee.worldRouter.iface;

import org.bukkit.World;

import java.util.Optional;

public interface WRProvider {

    Optional<World> getWorld();
}
