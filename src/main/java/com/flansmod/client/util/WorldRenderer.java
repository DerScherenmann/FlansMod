package com.flansmod.client.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class WorldRenderer
{
	public Tessellator tessellator;
	
	public WorldRenderer()
	{
		
	}
	
	public void startDrawingQuads()
	{
		tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(7, DefaultVertexFormats.POSITION_TEX);
	}
	
	public void startDrawingLines()
	{
		tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_TEX);
	}
	
	public void startDrawingPolygon()
	{
		tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(GL11.GL_POLYGON, DefaultVertexFormats.POSITION_TEX);
	}
	
	public void addVertexWithUV(double x, double y, double z, double u, double v)
	{
		tessellator.getBuffer().pos(x, y, z).tex(u, v).endVertex();
	}
	
	public void draw()
	{
		tessellator.draw();
	}
}
