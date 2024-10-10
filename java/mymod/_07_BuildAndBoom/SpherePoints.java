package mymod._07_BuildAndBoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import net.minecraft.util.math.BlockPos;

public class SpherePoints {
//    public static HashSet<BlockPos> getPointsOnSphere(BlockPos center, int radius) {
//        double centerX = center.getX(); // Center X-coordinate
//        double centerY = center.getY(); // Center Y-coordinate
//        double centerZ = center.getZ(); // Center Z-coordinate
//        HashSet<BlockPos> points = new HashSet<>();
//        // Generate points on the sphere's surface
//        for (double z = centerZ - radius; z <= centerZ + radius; z += 0.1) {
//            double yLimit = Math.sqrt(radius * radius - Math.pow(z - centerZ, 2));
//            for (double y = centerY + yLimit; y >= centerY - yLimit; y -= 0.1) {
//                double xLimit = Math.sqrt(radius * radius - Math.pow(z - centerZ, 2) - Math.pow(y - centerY, 2));
//                for (double x = centerX - xLimit; x <= centerX + xLimit; x += 0.1) {
//                    points.add(new BlockPos((int) x, (int) y, (int) z));
//                }
//            }
//        }
//        return points;
//	}
	public static ArrayList<BlockPos> getPointsOnSphere(BlockPos center, int radius) {
        int cx = center.getX(); // Center X-coordinate
        int cy = center.getY(); // Center Y-coordinate
        int cz = center.getZ(); // Center Z-coordinate
        double tolerance = 1;
        
        ArrayList<BlockPos> points = new ArrayList<>();
        // Generate points on the sphere's surface
        for (int y = radius; y >= -radius; y--) {
        	for (int z = -radius; z <= radius; z++) {
                for (int x = -radius; x <= radius; x++) {
                	double distance = Math.sqrt((x*x) + (y*y) + (z*z));
                	if (Math.abs(distance - radius) < tolerance) points.add(new BlockPos(cx + x, cy + y, cz + z));
                }
            }
        }
        Collections.shuffle(points);
        return points;
	}
}