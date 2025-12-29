package me.liamdar.SimpleWelcome.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import me.liamdar.SimpleWelcome.WelcomePlugin;

import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class JoinEvent implements Listener {
  private final WelcomePlugin plugin;
  private final MiniMessage miniMessage = MiniMessage.miniMessage();

  public JoinEvent(WelcomePlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    boolean dfjm = plugin.getConfig().getBoolean("disable-default-joinmsg", true);

    if (dfjm) {
      e.setJoinMessage(null);
    }

    if (plugin.getConfig() == null) return;

    boolean enabled = plugin.getConfig().getBoolean("join-messages-enabled", true);

    if (enabled) {
      String var1 = plugin.getConfig().getString("join.join-message", "&eWelcome to the server");
      String msg = var1
      .replace("%player%", p.getName());
      msg = convertAmpersandToMiniMessage(msg);
      Player player = (Player) e.getPlayer();

      Component message = miniMessage.deserialize(msg);
      plugin.getAdventure().player(player).sendMessage(message);
    }
  }

   private String convertAmpersandToMiniMessage(String input) {
    return input
        .replace("&0", "<black>")
        .replace("&1", "<dark_blue>")
        .replace("&2", "<dark_green>")
        .replace("&3", "<dark_aqua>")
        .replace("&4", "<dark_red>")
        .replace("&5", "<dark_purple>")
        .replace("&6", "<gold>")
        .replace("&7", "<gray>")
        .replace("&8", "<dark_gray>")
        .replace("&9", "<blue>")
        .replace("&a", "<green>")
        .replace("&b", "<aqua>")
        .replace("&c", "<red>")
        .replace("&d", "<light_purple>")
        .replace("&e", "<yellow>")
        .replace("&f", "<white>")
        .replace("&l", "<bold>")
        .replace("&o", "<italic>")
        .replace("&n", "<underlined>")
        .replace("&m", "<strikethrough>")
          .replace("&r", "<reset>");
    }
  }