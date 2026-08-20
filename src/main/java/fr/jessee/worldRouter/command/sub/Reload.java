package fr.jessee.worldRouter.command.sub;

import fr.jessee.worldRouter.WorldRouter;
import fr.jessee.worldRouter.util.abstr.AbstractSubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.List;

public class Reload extends AbstractSubCommand {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public List<String> getAliases() {
        return List.of("restart");
    }

    @Override
    public String getDescription() {
        return "Reload the plugin configuration";
    }

    @Override
    public String getUsage() {
        return "/worldrouter reload";
    }

    @Override
    public Permission getPermission() {
        return new Permission("wr.reload");
    }

    @Override
    public void executePlayer(CommandSender sender, String[] args) {
        if (!(sender instanceof Player p)) return;
        if (!p.hasPermission(getPermission())) {
            p.sendMessage(WorldRouter.getLangFile().getString("no_permission"));
            return;
        }

        WorldRouter.getLangFile().reload();
        WorldRouter.getWorldRouterCore().restart();
        p.sendMessage(WorldRouter.getLangFile().getString("reload_success"));
    }

    @Override
    public void executeConsole(CommandSender sender, String[] args) {
        if (sender instanceof Player) return;

        WorldRouter.getLangFile().reload();
        WorldRouter.getWorldRouterCore().restart();
        sender.sendMessage(WorldRouter.getLangFile().getString("reload_success"));
    }
}
