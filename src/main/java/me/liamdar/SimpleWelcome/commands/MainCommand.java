package me.liamdar.SimpleWelcome.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/*
 In some weeks
 ill try switching to
 TriumpCMD, Deprecated v of the plugin.
*/

public class MainCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public MainCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label,
            String[] args) {
        if (cmd.getName().equalsIgnoreCase("sw")) {
            if (args.length == 0 || (args.length == 1 && !args[0].equalsIgnoreCase("reload"))) {
                sender.sendMessage("§eSimple§fWelcome §bv" + plugin.getDescription().getVersion());
                sender.sendMessage("§7" + plugin.getDescription());
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("simplewelcome.reload")) {
                    String var1 = plugin.getConfig().getString("lang.no-permission");
                    String coloredMsg = ChatColor.translateAlternateColorCodes('&', var1);
                    sender.sendMessage(coloredMsg);
                    return true;
                } else {
                    String var2 = plugin.getConfig().getString("lang.reloaded");
                    String coloredMsg2 = ChatColor.translateAlternateColorCodes('&', var2);
                    plugin.reloadConfig();
                    sender.sendMessage(coloredMsg2);
                    return true;
                }
                if (args_length == 1 && args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage("§eSimple§fWelcome §bv" + plugin.getDescription().getVersion());
                    sender.sendMessage("§7" + plugin.getDescription());
                    return true;
                }
            }
        }
        return true;
    }
}
