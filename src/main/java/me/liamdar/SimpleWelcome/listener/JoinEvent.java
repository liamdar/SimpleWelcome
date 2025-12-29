package me.liamdar.SimpleWelcome.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
  private final JavaPlugin plugin;

  public JoinEvent(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();

    e.setJoinMessage(null);

    if (plugin.getConfig() == null) return;

    boolean enabled = plugin.getConfig().getBoolean("join-messages-enabled", true);

    if (enabled) {
      String var1 = plugin.getConfig().getString("join.join-message", "&eWelcome to the server");
      String coloredMsg = ChatColor.translateAlternateColorCodes('&', var1);
      String msg = coloredMsg
      .replace("%player%", p.getName());
      p.sendMessage(msg);
    }
  }
}