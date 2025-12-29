package me.liamdar.SimpleWelcome;

import org.bukkit.plugin.java.JavaPlugin;
import me.liamdar.SimpleWelcome.listener.JoinEvent;
import me.liamdar.SimpleWelcome.commands.MainCommand;

public class WelcomePlugin extends JavaPlugin {

    /*
    @author: liamdar
    @project WelcomePlugin
    */

    @Override
    public void onEnable() {
        saveDefaultConfig();

        this.getCommand("sw").setExecutor(new MainCommand(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getLogger().info("SimpleWelcome 1.0.0 enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled SimpleWelcome");
    }
}