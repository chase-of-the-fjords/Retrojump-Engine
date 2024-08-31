package com.chaseplays.engine.shapes;

import com.chaseplays.engine.Engine;

public class Line {
	
	public int x, y, xc, yc;
	
	public int color = 0xFFFFFFFF;
	
	public double thickness = 1;
	
	public Line () {
		
		x = 0;
		y = 0;
		xc = 0;
		yc = 0;
		
	}
	
	public Line (int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public Line (int x, int y, int xc, int yc) {
		
		this.x = x;
		this.y = y;
		
		this.xc = xc;
		this.yc = yc;
		
	}

	public static Line radian (int x, int y, double rad, int r) {
		
		Line polarRad = new Line(x, y, (int) Math.round((double) r * Math.cos(rad)), -1 * (int) Math.round((double) r * Math.sin(rad)));
		
		return polarRad;
		
	}
	
	public static Line degree (int x, int y, int degree, int r) {
		
		Line polarDegree = new Line(x, y, (int) Math.round((double) r * Math.cos(degree * ((Math.PI) / 180))), -1 * (int) Math.round((double) r * Math.sin(degree * ((Math.PI) / 180))));
		
		return polarDegree;
		
	}
	
	public static Line slope (int x, int y, double slope, int r) {
		
		Line slopeLine = new Line(x, y, (int) Math.round((double) r * Math.cos(Math.atan(slope))), (int) Math.round((double) r * Math.sin(Math.atan(slope))));
		
		return slopeLine;
		
	}
	
	public static Line coordinates (int x1, int y1, int x2, int y2) {
		
		Line coordinatedLine = new Line(x1, y1, x2 - x1, y2 - y1);
		
		return coordinatedLine;
		
	}
	
	public void setRadVector (int r, double rad) {
		
		xc = (int) Math.round((double) r * Math.cos(rad));
		yc = -1 * (int) Math.round((double) r * Math.sin(rad));
	
		
	}
	
	public void setSlopeVector (int r, double slope) {
		
		xc = (int) Math.round(((double) r) * Math.cos(Math.atan(slope)));
		yc = (int) Math.round(((double) r) * Math.sin(Math.atan(slope)));
		
	}

	public void setDegreeVector (int r, int degree) {
		
		xc = (int) Math.round(((double) r * Math.cos(degree * ((Math.PI) / 180))));
		yc = -1 * (int) Math.round(((double) r * Math.sin(degree * ((Math.PI) / 180))));
		
	}

	public int endpointX () {
		
		return x + xc;
		
	}
	
	public int endpointY () {
		
		return y + yc;
		
	}
	
	public void anchorTo (Line line) {
		
		this.x = line.endpointX();
		this.y = line.endpointY();
		
	}
	
	public void anchorTo (Graph graph) {
		
		this.x = graph.getX();
		this.y = graph.getY();
		
	}
	
	public void thicken (double thickness) {
		
		this.thickness = thickness;
		
	}
	
	public Line thickened (double thickness) {
		
		this.thicken(thickness);
		
		return this;
		
	}
	
	public void render (Engine e) {
		
		if (Math.abs(xc) >= Math.abs(yc)) {
			
			if (xc > 0) for (int xf = 0; xf < xc; xf++) new Circle(x + xf, (int) (y + (((double) yc/ (double) xc) * xf)), thickness / 2, true).colored(color).render(e);
			else for (int xf = 0; xf > xc; xf--) new Circle(x + xf, (int) (y + (((double) yc/ (double) xc) * xf)), thickness / 2, true).colored(color).render(e);
			
		}
		if (Math.abs(xc) < Math.abs(yc)) {
			
			if (yc > 0) for (int yf = 0; yf < yc; yf++) new Circle((int) (x + (((double) xc/ (double) yc) * yf)), y + yf, thickness / 2, true).colored(color).render(e);
			else for (int yf = 0; yf > yc; yf--) new Circle((int) (x + (((double) xc/ (double) yc) * yf)), y + yf, thickness / 2, true).colored(color).render(e);
			
		}
		
	}
	
	public void color (int color) {
		
		this.color = color;
		
	}
	
}
