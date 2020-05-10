package com.flansmod.common.eventhandlers;

import com.flansmod.common.driveables.EntitySeat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteractEventListeners
{
	public static boolean cancelled = false;
	public PlayerInteractEventListeners()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@EventHandler
	@SubscribeEvent
	public void PlayerInteract(PlayerInteractEvent event)
	{
		if (event.getEntity().world.isRemote)
			return;
		//entity is Player but we have more choices
		Entity entity = event.getEntity();
		EntityPlayer player = event.getEntityPlayer();
		Entity seat = entity.getRidingEntity();
		cancelled = false;
		
		if(seat != null) {
			Entity drivable = seat.getRidingEntity();
			if(drivable != null) {
				//FlansMod.log.info(drivable.getClass());
			}
			
			if(player.isRiding() && seat instanceof EntitySeat) {
				event.setCanceled(true);
				cancelled = true;
			}
		}
		
	}
}
