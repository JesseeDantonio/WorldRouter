package fr.jessee.worldRouter.command.sub;

import fr.jessee.worldRouter.util.abstr.AbstractSubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public class Reload extends AbstractSubCommand {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public List<String> getAliases() {
        return List.of();
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public Permission getPermission() {
        return null;
    }

    @Override
    public void executePlayer(CommandSender sender, String[] args) {

    }

    @Override
    public void executeConsole(CommandSender sender, String[] args) {

    }
}
