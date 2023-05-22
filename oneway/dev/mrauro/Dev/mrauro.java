/*    */ package oneway.dev.mrauro.Dev;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public final class mrauro
/*    */   extends JavaPlugin
/*    */   implements Listener
/*    */ {
/*    */   public void onEnable() {
/* 21 */     getServer().getPluginManager().registerEvents(this, (Plugin)this);
/*    */   }
/*    */   
/* 24 */   public Vector<Player> playersInZone = new Vector<>();
/* 25 */   public Vector<PlayerTask> playerTasks = new Vector<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {}
/*    */ 
/*    */   
/* 32 */   Zone[] zones = new Zone[] { new Zone(213, 67, 247, 220, 99, 263) };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   Face[] faces = new Face[] { new Face(220, 92, 252, 220, 99, 258, 
/*    */         
/* 39 */         getServer().getWorld("main")), new Face(218, 83, 248, 218, 89, 262, 
/* 40 */         getServer().getWorld("main")), new Face(218, 75, 252, 218, 82, 258, 
/* 41 */         getServer().getWorld("main")) };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerMoveEvent(PlayerMoveEvent event) {
/* 48 */     Player player = event.getPlayer();
/* 49 */     Location location = player.getLocation();
/*    */     
/* 51 */     for (Zone zone : this.zones) {
/* 52 */       if (zone.inside(location)) {
/*    */         
/* 54 */         if (!this.playersInZone.contains(player)) {
/* 55 */           this.playersInZone.add(player);
/* 56 */           for (Face face : this.faces) {
/* 57 */             face.getBlocks().forEach(block -> player.sendBlockChange(block.getLocation(), Material.BLACK_STAINED_GLASS.createBlockData()));
/* 58 */             this.playerTasks.add(new PlayerTask(player, face, (Plugin)this));
/*    */           }
/*    */         
/*    */         }
/*    */       
/* 63 */       } else if (this.playersInZone.contains(player)) {
/* 64 */         this.playersInZone.remove(player);
/* 65 */         for (Face face : this.faces) {
/* 66 */           face.getBlocks().forEach(block -> player.sendBlockChange(block.getLocation(), block.getBlockData()));
/*    */           
/* 68 */           Iterator<PlayerTask> iterator = this.playerTasks.iterator();
/* 69 */           while (iterator.hasNext()) {
/* 70 */             PlayerTask playerTask = iterator.next();
/* 71 */             if (playerTask.player == player) {
/* 72 */               Bukkit.getScheduler().cancelTask(playerTask.taskId);
/* 73 */               iterator.remove();
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\NUC Backup\Minecraft\test\dev.mrauro-1.0-SNAPSHOT.jar!\oneway\dev\mrauro\Dev\mrauro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */