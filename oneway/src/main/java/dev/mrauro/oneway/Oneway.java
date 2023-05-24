package dev.mrauro.oneway;

import org.bukkit.World;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Iterator;
import java.util.Vector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.ls.LSOutput;

public final class Oneway extends JavaPlugin implements Listener
{
    public Vector<Player> playersInZone = new Vector<>();
    public Vector<PlayerTask> playerTasks = new Vector<>();
    private Vector<Face> faces = new Vector<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
    }


    public void onDisable() {}

    Zone[] zones = new Zone[] { new Zone(213, 67, 247, 220, 99, 263) };


    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        // Temporary code for testing
        // Should use a config file to store the faces and zones later
        if (faces.size() != 1) {
            World world = event.getPlayer().getWorld();
            faces.add(new Face(220, 92, 252, 220, 99, 258, world));
        };

        Player player = event.getPlayer();
        Location location = player.getLocation();

        for (Zone zone : this.zones) {
            if (zone.inside(location)) {
                if (!this.playersInZone.contains(player)) {
                    this.playersInZone.add(player);
                    for (Face face : this.faces) {
                        face.getBlocks().forEach(block -> player.sendBlockChange(block.getLocation(), Material.BLACK_STAINED_GLASS.createBlockData()));
                        this.playerTasks.add(new PlayerTask(player, face, (Plugin)this));
                    }

                }

            } else if (this.playersInZone.contains(player)) {
                this.playersInZone.remove(player);
                for (Face face : this.faces) {
                    face.getBlocks().forEach(block -> player.sendBlockChange(block.getLocation(), block.getBlockData()));

                    Iterator<PlayerTask> iterator = this.playerTasks.iterator();
                    while (iterator.hasNext()) {
                        PlayerTask playerTask = iterator.next();
                        if (playerTask.player == player) {
                            Bukkit.getScheduler().cancelTask(playerTask.taskId);
                            iterator.remove();
                        }
                    }
                }
            }
        }
    }
}
