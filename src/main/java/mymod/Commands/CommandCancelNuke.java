package mymod.Commands;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import mymod.CustomEvents;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class CommandCancelNuke extends CommandBase {
	/**
     * Gets the name of the command
     */
    public String getName()
    {
        return "cancel_nuke";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    /**
     * Gets the usage string for the command.
     */
    public String getUsage(ICommandSender sender)
    {
        return usage;
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
    	CustomEvents.sphereExplosionList.clear();
    }
    
    protected String usage = "/cancel_nuke Cancels any nuke explosions.";
}
