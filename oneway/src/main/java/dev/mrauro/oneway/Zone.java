package dev.mrauro.oneway;

import org.bukkit.Location;

class Zone
{
    int x1;
    int x2;
    int y1;
    int y2;
    int z1;
    int z2;

    public Zone(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
    }

    public boolean inside(Location location) {
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        return (x >= this.x1 && x <= this.x2 && y >= this.y1 && y <= this.y2 && z >= this.z1 && z <= this.z2);
    }
}