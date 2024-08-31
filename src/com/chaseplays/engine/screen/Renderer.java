package com.chaseplays.engine.screen;

import java.awt.Color;

import com.chaseplays.engine.text.Figure;
import com.chaseplays.engine.text.Font;
import com.chaseplays.engine.text.Text;

public class Renderer {
	
	public Screen screen;
	
	public String type;
	
	public Renderer (String type, Screen screen) {
		
		this.type = type;
		this.screen = screen;
		
	}
	
	public void render (int x, int y, Sprite sprite) {
		
		yLoop:
		
		for (int spriteY = 0; spriteY < sprite.height; spriteY++) {
			
			int screenPixelY = 0;
			
			if (on()) screenPixelY = y + spriteY;
			else if (in()) screenPixelY = y + spriteY - screen.cam.y;
			
			if (spriteY == 0) {
				
				spriteY = Math.max(0, (-1 * screenPixelY) - 1);
				
			}
			
			if (spriteY >= sprite.height) break yLoop;
			
			xLoop:
			
			for (int spriteX = 0; spriteX < sprite.width; spriteX++) {
				
				int screenPixelX = 0;
				
				if (on()) screenPixelX = x + spriteX;
				else if (in()) screenPixelX = x + spriteX - screen.cam.x;
				
				if (spriteX == 0) spriteX = Math.max(0, (-1 * screenPixelX) - 1);
				
				if (spriteX >= sprite.width) break xLoop;
				
				int color = sprite.pixels[spriteX + spriteY * sprite.width];
				
				double alpha = 1;
				
				if (!sprite.opaque) alpha = (double) (sprite.alphas[spriteX + spriteY * sprite.width]) / (double) 255;
				
				if (!(screenPixelX < 0 || screenPixelX >= screen.width || screenPixelY < 0 || screenPixelY >= screen.height) && !sprite.opaque) {
					
					Color cScreen = new Color(screen.pixels[screenPixelX + screenPixelY * screen.width]);
					Color cSprite = new Color(color);
					
					int red = Math.min( (int) (((double) cScreen.getRed() * (1 - alpha)) + ((double) cSprite.getRed() * alpha)), 255);
					int green = Math.min( (int) (((double) cScreen.getGreen() * (1 - alpha)) + ((double) cSprite.getGreen() * alpha)), 255);
					int blue = Math.min( (int) (((double) cScreen.getBlue() * (1 - alpha)) + ((double) cSprite.getBlue() * alpha)), 255);
					
					cScreen = new Color(red, green, blue);
					
					screen.pixels[screenPixelX + screenPixelY * screen.width] = cScreen.getRGB();
					
				} else if (!(screenPixelX < 0 || screenPixelX >= screen.width || screenPixelY < 0 || screenPixelY >= screen.height)) { 
					
					screen.pixels[screenPixelX + screenPixelY * screen.width] = color;
					
				} else if (screenPixelX >= screen.width) {
					
					spriteX = sprite.width;
					
					break xLoop;
					
				} else if (screenPixelY >= screen.height) {
					
					break yLoop;
					
				}
				
			}
			
		}
		
	}
	
	public void renderText (Text text) {
		
		int pixelx = 0;
		
		int pixely = 0;
		
		int line = 0;
		
		if (text.direction.equals("center")) {
			
			pixelx -= text.getLength(line) / 2;
			
		}
		
		if (text.direction.equals("left")) {
			
			pixelx -= text.getLength(line);
			
		}
		
		for (int f = 0; f < text.text.size(); f++) {
			
			Figure figure = text.text.get(f);
			
			if (figure.c == ' ') {
				
				pixelx += text.text.get(f).font.space;
				
			} else if (figure.c == '\n') {
				
				pixely += text.text.get(f).font.size;
				pixelx = 0;
				
				line++;
				
				if (text.direction.equals("center")) {
					
					pixelx -= text.getLength(line) / 2;
					
				}
				
				if (text.direction.equals("left")) {
					
					pixelx -= text.getLength(line);
					
				}
				
			} else {
				
				Sprite fSprite = figure.sprite;
				
				if (figure.color != -1) fSprite = figure.sprite.tinted(figure.color, 1);
				
				int xchange = 0;
				int ychange = 0;
				
				boolean show = true;
				
				for (int a = 0; a < figure.actions.size(); a++) {
					
					xchange += figure.actions.get(a).xchange(f);
					ychange += figure.actions.get(a).ychange(f);
					
					if (!figure.actions.get(a).show()) show = false;
					
				}
				
				if (show) render((text.x + pixelx + xchange) - (figure.height), text.y + pixely + ychange, fSprite);
				
				pixelx += figure.width;
				
				if (f + 1 < text.text.size()) if (text.text.get(f + 1).c != '\n' || text.text.get(f + 1).c != ' ') pixelx += figure.font.gap;
				
			}
			
		}
		
	}
	
	public void renderText (int x, int y, String text, int color, Font font) {
		
		this.renderText(new Text(x, y, text, font, color));
		
	}
	
	public boolean in () {
		
		if (type.equals("in")) return true;
		return false;
		
	}
	
	public boolean on () {
		
		if (type.equals("on")) return true;
		return false;
		
	}
	
}
