package dev.mrauro.oneway;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PlayerTask
{
    Player player;
    int taskId;
    Face face;

    public PlayerTask(Player player, Face face, Plugin plugin) {
        this.player = player;
        this.taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> face.getBlocks().forEach(block -> player.sendBlockChange(block.getLocation(), Material.BLACK_STAINED_GLASS.createBlockData())), 0L, 1L);

        this.face = face;
    }
}