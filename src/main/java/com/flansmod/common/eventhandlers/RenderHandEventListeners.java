package com.flansmod.common.eventhandlers;

import com.flansmod.common.FlansMod;

import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHandEventListeners
{
	public RenderHandEventListeners()
	{
		try {
			MinecraftForge.EVENT_BUS.register(this);
		}catch(Exception e) {
			FlansMod.log.info("Server Side");
		}
	}
	
	@EventHandler
	@SubscribeEvent
	public void RenderHand(RenderHandEvent event)
	{
		if(PlayerInteractEventListeners.cancelled) {
			event.setCanceled(true);
		}
	}
}
