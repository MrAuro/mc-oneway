/*     */ package oneway.dev.mrauro.Dev;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
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
/*     */ class Face
/*     */ {
/*     */   int x1;
/*     */   int x2;
/*     */   int y1;
/*     */   int y2;
/*     */   int z1;
/*     */   int z2;
/*     */   World world;
/*     */   
/*     */   public Face(int x1, int y1, int z1, int x2, int y2, int z2, World world) {
/* 110 */     this.x1 = x1;
/* 111 */     this.x2 = x2;
/* 112 */     this.y1 = y1;
/* 113 */     this.y2 = y2;
/* 114 */     this.z1 = z1;
/* 115 */     this.z2 = z2;
/* 116 */     this.world = world;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector<Block> getBlocks() {
/* 121 */     Vector<Block> blocks = new Vector<>();
/* 122 */     for (int x = this.x1; x <= this.x2; x++) {
/* 123 */       for (int y = this.y1; y <= this.y2; y++) {
/* 124 */         for (int z = this.z1; z <= this.z2; z++) {
/* 125 */           blocks.add(this.world.getBlockAt(x, y, z));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     return blocks;
/*     */   }
/*     */ }


/* Location:              D:\NUC Backup\Minecraft\test\dev.mrauro-1.0-SNAPSHOT.jar!\oneway\dev\mrauro\Dev\Face.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */