package dev.mrauro.oneway;

import java.util.Vector;
import org.bukkit.World;
import org.bukkit.block.Block;

class Face
{
    int x1;
    int x2;
    int y1;
    int y2;
    int z1;
    int z2;
    World world;

    public Face(int x1, int y1, int z1, int x2, int y2, int z2, World world) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        this.world = world;
    }
    /*     */

    public Vector<Block> getBlocks() {
        Vector<Block> blocks = new Vector<>();
        for (int x = this.x1; x <= this.x2; x++) {
            for (int y = this.y1; y <= this.y2; y++) {
                for (int z = this.z1; z <= this.z2; z++) {
                    blocks.add(this.world.getBlockAt(x, y, z));
                }
            }
        }

        return blocks;
    }
}