package me.liamdar.SimpleWelcome.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListener implements Listener {
  private final JavaPlugin plugin;

  public FirstJoinListener(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();

    e.setJoinMessage(null);

    if (plugin.getConfig() == null) return;

    boolean enabled = plugin.getConfig().getBoolean("first-join-message-enabled", true);

    if (enabled) {
      String var1 = plugin.getConfig().getString("join.first-join-message", "&eWelcome to the server");
      String coloredMsg = ChatColor.translateAlternateColorCodes('&', var1);
      String msg = coloredMsg
      .replace("%player%", p.getName());
      if (!p.hasPlayedBefore()) {
        p.sendMessage(msg);
      }
    }
  }
}