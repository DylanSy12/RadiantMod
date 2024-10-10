package mymod._07_BuildAndBoom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class SphereExplosion {
	public BlockPos center;
	public int radius;
	public int currentLayer;
	public Set<BlockPos> alreadyErased;
	public Explosion explosion;
	public SphereExplosion(BlockPos center, int radius, Explosion explosion) {
		this.center = center;
		this.radius = radius;
		this.currentLayer = 0;
		this.alreadyErased = new HashSet<BlockPos>();
		this.explosion = explosion;
	}
	public String toString() {
		return "Center: " + this.center + ", Radius: " + this.radius + ", CurrentLayer: " + this.currentLayer;
	}
}
