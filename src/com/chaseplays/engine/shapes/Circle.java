package com.chaseplays.engine.shapes;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.screen.Sprite;

public class Circle {

	public int x, y;
	public double r;

	public int outlineColor = 0xFF;
	public int fillColor = 0xFFFFFFFF;

	public boolean shaded = false;

	public Circle (int x, int y, double r, boolean shaded) {

		this.x = x;
		this.y = y;
		this.r = r;
		this.shaded = shaded;

	}
	
	public Circle (int x, int y, double r) {

		this.x = x;
		this.y = y;
		this.r = r;

	}
	
	public void shade (boolean shade) {
		
		this.shaded = shade;
		
	}
	
	public void setRadius (int radius) {
		
		r = radius;
		
	}
	
	public void color (int color) {
		
		this.outlineColor = color;
		this.fillColor = color;
		
	}
	
	public Circle colored (int color) {
		
		this.color(color);
		
		return this;
		
	}
	
	public void fillColor (int color) {
		
		this.fillColor = color;
		
	}
	
	public void outlineColor (int color) {
		
		this.outlineColor = color;
		
	}
	
	public void anchorTo (Line line) {
		
		this.x = line.endpointX();
		this.y = line.endpointY();
		
	}
	
	public void anchorTo (Graph graph) {
		
		this.x = graph.getX();
		this.y = graph.getY();
		
	}
	
	public void render(Engine e) {

		if (shaded) {

			for (int xr = (int) -Math.round(r); xr <= Math.round(r); xr++) {

				if (xr == 0) {

					for (int j = (int) -Math.round(r); j <= Math.round(r); j++) {

						e.screen.on.render(x + xr, y + j, new Sprite(fillColor, 1, 1));

					}

				} else for (int j = -(int) (xr * Math.tan(Math.acos((double) xr / (double) r))); j <= (int) (xr * Math.tan(Math.acos((double) xr / (double) r))); j++) {

					e.screen.on.render(x + xr, y + j, new Sprite(fillColor, 1, 1));

				}

			}

		}
		
		for (int xr = (int) Math.round(-1 * (Math.cos(Math.PI / 4) * r)); xr <= (int) Math.round(Math.cos(Math.PI / 4) * r); xr++) {

			if (xr == 0) {

				e.screen.on.render(x, y + (int) Math.round(r), new Sprite(outlineColor, 1, 1));
				e.screen.on.render(x, y - (int) Math.round(r), new Sprite(outlineColor, 1, 1));

			} else {
				
				e.screen.on.render(x + xr, y + (int) Math.round(xr * Math.tan(Math.acos((double) xr / (double) r))), new Sprite(outlineColor, 1, 1));
				e.screen.on.render(x + (xr * -1), y + (int) (Math.round(xr * Math.tan(Math.acos((double) xr / (double) r))) * -1), new Sprite(outlineColor, 1, 1));
				
			}
			
		}

		for (int yr = (int) Math.round(-1 * (Math.cos(Math.PI / 4) * r)); yr <= (int) Math.round(Math.cos(Math.PI / 4) * r); yr++) {

			if (yr == 0) {

				e.screen.on.render(x + (int) Math.round(r), y, new Sprite(outlineColor, 1, 1));
				e.screen.on.render(x - (int) Math.round(r), y, new Sprite(outlineColor, 1, 1));

			} else {
				
				e.screen.on.render(x + (int) Math.round(yr / Math.tan(Math.asin((double) yr / (double) r))), y + yr, new Sprite(outlineColor, 1, 1));
				e.screen.on.render(x + ((int) Math.round(yr / Math.tan(Math.asin((double) yr / (double) r))) * -1), y + (yr * -1), new Sprite(outlineColor, 1, 1));
				
			}
			
		}

	}
	
	public Sprite toSprite () {
		
		Sprite s = new Sprite((int) (Math.round(r) * 2) + 1, (int) (Math.round(r) * 2) + 1);
		
		if (shaded) {

			for (int xr = (int) -Math.round(r); xr <= Math.round(r); xr++) {

				if (xr == 0) {

					for (int j = (int) -Math.round(r); j <= Math.round(r); j++) {
						
						s.pixels[(int) Math.round(r) + xr + (s.width * ((int) Math.round(r) + j))] = fillColor;

					}

				} else for (int j = -(int) (xr * Math.tan(Math.acos((double) xr / (double) r))); j <= (int) (xr * Math.tan(Math.acos((double) xr / (double) r))); j++) {
					
					s.pixels[(int) Math.round(r) + xr + (s.width * ((int) Math.round(r) + j))] = fillColor;

				}

			}

		}
		
		for (int xr = (int) Math.round(-1 * (Math.cos(Math.PI / 4) * r)); xr <= (int) Math.round(Math.cos(Math.PI / 4) * r); xr++) {

			if (xr == 0) {

				s.pixels[(int) Math.round(r) + (s.width * (2 * (int) Math.round(r)))] = outlineColor;
				s.pixels[(int) Math.round(r)] = outlineColor;

			} else {
				
				s.pixels[(int) Math.round(r) + xr + (s.width * ((int) Math.round(r) + (int) Math.round(xr * Math.tan(Math.acos((double) xr / (double) r)))))] = outlineColor;
				s.pixels[(int) Math.round(r) - xr + (s.width * ((int) Math.round(r) - (int) Math.round(xr * Math.tan(Math.acos((double) xr / (double) r)))))] = outlineColor;
				
			}
			
		}
		
		for (int yr = (int) Math.round(-1 * (Math.cos(Math.PI / 4) * r)); yr <= (int) Math.round(Math.cos(Math.PI / 4) * r); yr++) {

			if (yr == 0) {
				
				s.pixels[(((int) Math.round(r)) * 2) + (s.width * ((int) Math.round(r)))] = outlineColor;
				s.pixels[(s.width * ((int) Math.round(r)))] = outlineColor;

			} else {
				
				s.pixels[(int) Math.round(r) + (int) Math.round(yr / Math.tan(Math.asin((double) yr / (double) r))) + (s.width * ((int) Math.round(r) + yr))] = outlineColor;
				s.pixels[(int) Math.round(r) - (int) Math.round(yr / Math.tan(Math.asin((double) yr / (double) r))) + (s.width * ((int) Math.round(r) - yr))] = outlineColor;
				
			}
			
		}
		
		return s;
		
	}

}
