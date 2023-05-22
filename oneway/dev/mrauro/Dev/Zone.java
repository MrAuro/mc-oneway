/*     */ package oneway.dev.mrauro.Dev;
/*     */ 
/*     */ import org.bukkit.Location;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Zone
/*     */ {
/*     */   int x1;
/*     */   int x2;
/*     */   int y1;
/*     */   int y2;
/*     */   int z1;
/*     */   int z2;
/*     */   
/*     */   public Zone(int x1, int y1, int z1, int x2, int y2, int z2) {
/*  88 */     this.x1 = x1;
/*  89 */     this.x2 = x2;
/*  90 */     this.y1 = y1;
/*  91 */     this.y2 = y2;
/*  92 */     this.z1 = z1;
/*  93 */     this.z2 = z2;
/*     */   }
/*     */   
/*     */   public boolean inside(Location location) {
/*  97 */     double x = location.getX();
/*  98 */     double y = location.getY();
/*  99 */     double z = location.getZ();
/*     */     
/* 101 */     return (x >= this.x1 && x <= this.x2 && y >= this.y1 && y <= this.y2 && z >= this.z1 && z <= this.z2);
/*     */   }
/*     */ }


/* Location:              D:\NUC Backup\Minecraft\test\dev.mrauro-1.0-SNAPSHOT.jar!\oneway\dev\mrauro\Dev\Zone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */