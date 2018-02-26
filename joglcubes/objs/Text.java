// thanks to NeHe: http://nehe.gamedev.net/
package joglcubes.objs;

import com.jogamp.opengl.GLAutoDrawable;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.text.DecimalFormat;

public class Text {
	   GLAutoDrawable drw;
	   private TextRenderer textRenderer;
	   private String msg = "Primitive(s) Wall ( java+jogl ) - C.R.G. 2018";
	   private DecimalFormat formatter = new DecimalFormat("###0.00");
	   private int textPosX; // x-position of the text
	   private int textPosY; // y-position of the text
	   
	   public Text(GLAutoDrawable drawable) {
		   drw = drawable;
		   // Allocate textRenderer with the chosen font
		   textRenderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 14));
		   
		   Rectangle2D bounds = textRenderer.getBounds(msg);
		   int textWidth = (int)bounds.getWidth();
		   int textHeight = (int)bounds.getHeight();
		   
		   // Centralize text on the canvas
		   textPosX = (drawable.getSurfaceWidth() - textWidth) / 2;
//		   textPosY = (drawable.getSurfaceHeight() - textHeight) / 2 - textHeight;
		   textPosY = (drawable.getSurfaceHeight() - textHeight*2);
	   }
	   
	   public void Display() {
		   // Prepare to draw text
		   textRenderer.beginRendering(drw.getSurfaceWidth(), drw.getSurfaceHeight());
		   
		   // Pulsing colors based on text position, set color in RGBA
		   textRenderer.setColor(0.5f, // R
		         0.5f, // G
		         1f, // B
		         0.8f); // Alpha
		   // 2D text using int (x, y) coordinates in OpenGL coordinates system,
		   // i.e., (0,0) at the bottom-left corner, instead of Java Graphics coordinates.
		   // x is set to between (+/-)10. y is set to be (+/-)80.
		   textRenderer.draw(msg, // string
		         (int)textPosX,  // x
		         (int)textPosY);   // y

		   textRenderer.endRendering();  // finish rendering
	   }

}
