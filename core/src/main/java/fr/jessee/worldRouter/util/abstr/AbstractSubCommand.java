package fr.jessee.worldRouter.util.abstr;

import fr.jessee.worldRouter.util.iface.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public abstract class AbstractSubCommand implements SubCommand {
    public abstract List<String> getAliases();
    public abstract String getDescription();
    public abstract String getUsage();
    public abstract Permission getPermission();
    public abstract void executePlayer(CommandSender sender, String[] args);
    public abstract void executeConsole(CommandSender sender, String[] args);
}
