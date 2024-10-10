package mymod._07_BuildAndBoom;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Chat;

public class EntityWorldErasingGrenade extends EntityThrowable {

	public EntityWorldErasingGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityWorldErasingGrenade(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				BlockPos pos;
				int cube_size=200;
				int p=0;
				this.setDead();
				for (int y=255;y>=0;y--) {
					for (int x= -cube_size;x<=cube_size;x++) {
						for (int z= -cube_size;z<=cube_size;z++) {
							pos=new BlockPos(result.getBlockPos().getX()+x,y,result.getBlockPos().getZ()+z);
//							if (p%(160801)==0) {
//								System.out.println(world.getBlockState(pos));
//							}
							world.setBlockToAir(pos);
							p++;
							if (p%(160801)==0) {
								ITextComponent text = (ITextComponent) new TextComponentString(p+"/41165056");
								EntityPlayer player=this.world.getClosestPlayerToEntity(this, 1000);
								if (player!=null) player.sendMessage(text);
//								System.out.println(p+"/41165056");
//								System.out.println(x+","+y+","+z);
//								System.out.println(world.getBlockState(pos));
							}
						}
					}
				}
			}
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, 100, true);
				this.setDead();
			}
//			this.setDead();
		}
	}
}
