package fr.jessee.worldRouter.listener.player;

import fr.jessee.worldRouter.WorldRouter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player PLAYER = e.getPlayer();

        if (PLAYER.getWorld().getUID().equals(WorldRouter.getWorldRouterCore().getWorld().getUID())) return;

        PLAYER.teleportAsync(WorldRouter.getWorldRouterCore().getWorld().getSpawnLocation());
    }
}
