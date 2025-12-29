package me.liamdar.SimpleWelcome;

import org.bukkit.plugin.java.JavaPlugin;

import me.liamdar.SimpleWelcome.listener.FirstJoinListener;
import me.liamdar.SimpleWelcome.listener.JoinEvent;
import me.liamdar.SimpleWelcome.commands.MainCommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;

import lombok.Getter;

@Getter
public class WelcomePlugin extends JavaPlugin {

    @Getter
    private static WelcomePlugin instance;
    private static BukkitAudiences adventure;

    @Override
    public void onEnable() {
        instance = this;

        adventure = BukkitAudiences.create(this);

        saveDefaultConfig();

        this.getCommand("sw").setExecutor(new MainCommand(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new FirstJoinListener(this), this);
        getLogger().info("SimpleWelcome 1.0.0 enabled");
    }

    @Override
    public void onDisable() {
        if (adventure != null) {
            adventure.close();
        }

        getLogger().info("Disabled SimpleWelcome");
    }

    public BukkitAudiences getAdventure() {
            return adventure;
            }
    }