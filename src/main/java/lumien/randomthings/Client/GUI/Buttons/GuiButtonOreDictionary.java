package lumien.randomthings.Client.GUI.Buttons;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiButtonOreDictionary extends GuiButton
{
	ResourceLocation oreButtonTextures = new ResourceLocation("randomthings:textures/gui/buttonOreDict.png");
	boolean enabled;
	

	public GuiButtonOreDictionary(int id,int posX,int posY,boolean enabled)
	{
		super(id, posX, posY, "");
		
		this.enabled = enabled;
	}
	
	public void setEnabled(boolean state)
	{
		this.enabled = state;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}

	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	{
		if (this.visible)
		{
			FontRenderer fontrenderer = p_146112_1_.fontRenderer;
			p_146112_1_.getTextureManager().bindTexture(oreButtonTextures);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			
			this.drawTexturedModalRect(this.xPosition, this.yPosition, (!enabled?0:1)*20, (k-1) * 20, 20, 20);
			
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
			int l = 14737632;

			if (packedFGColour != 0)
			{
				l = packedFGColour;
			}
			else if (!this.enabled)
			{
				l = 10526880;
			}
			else if (this.field_146123_n)
			{
				l = 16777120;
			}
		}
	}

}
