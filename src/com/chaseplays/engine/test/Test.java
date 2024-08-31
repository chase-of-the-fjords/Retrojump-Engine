package com.chaseplays.engine.test;

import com.chaseplays.engine.Game;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;
import com.chaseplays.engine.shapes.CartesianGraph;
import com.chaseplays.engine.shapes.Circle;
import com.chaseplays.engine.shapes.Line;
import com.chaseplays.engine.shapes.PolarGraph;
import com.chaseplays.engine.shapes.Rectangle;
import com.chaseplays.engine.sound.Sound;

public class Test extends Game {
	
	private static final long serialVersionUID = 1L;
	
	public static Test game = new Test();
	
	public static Line line1 = new Line(50, 50);
	public static Line line2 = new Line();
	public static Line line3 = new Line();
	
	public static Circle circ1 = new Circle(50, 50, 20);
	public static Circle circ2 = new Circle(50, 50, 10);
	public static Circle circ3 = new Circle(50, 50, 5);
	
	public static Rectangle rect = new Rectangle(1, 1, 10, 10);
	
	public static int angle = 180;
	
	public Action a = new Action(10, 0);
	
	public CartesianGraph graph = new CartesianGraph(50, 50, 10, 0.01);
	
	public Sound action = new Sound("dimensional_time.wav");
	
	public static void main (String[] args) {
		
		game.setDimensions(100, 100, 5);
		
		game.start();
		
	}
	
	public void setupGame () {
		
		a.start();
		
		circ1.shade(true);
		circ1.outlineColor(0xFF00FF00);
		circ1.fillColor(0xFFFFFFFF);
		
		circ2.shade(true);
		circ2.color(0xFF000000);
		
		circ3.shade(true);
		circ3.outlineColor(0xFFFF0033);
		circ3.fillColor(0xFFFF00FF);
		
		line1.thicken(5);
		
		line2.thicken(7.5);
		
		line3.thicken(2);
		
		graph.setParametric(true);
		
	}
	
	public void update () {
		
		line1.setDegreeVector(20, angle);
		
		line1.color(0xFF0000FF);
		
		line2.setDegreeVector(15, angle * 2);
		line2.anchorTo(line1);
		
		line2.color(0xFF00FFFF);
		
		line3.setDegreeVector(10, angle * 3);
		line3.anchorTo(line2);
		
		line3.color(0xFFFF0000);
		
		line1.anchorTo(graph);
		
		circ1.anchorTo(line1);
		circ2.anchorTo(line2);
		circ3.anchorTo(line3);
		
		graph.update();
		
		graph.gx = (int) (20 * Math.cos(graph.t));
		graph.gy = (int) (10 * Math.sin(2 * graph.t));
		
		if (a.able()) {
			
			a.gather();
			
			if (key.left.pressed) angle += 1;
			if (key.right.pressed) angle -= 1;
			
			if (key.w.pressed) rect.y1--;
			if (key.a.pressed) rect.x1--;
			if (key.s.pressed) rect.y1++;
			if (key.d.pressed) rect.x1++;
			
			if (key.i.pressed) rect.y2--;
			if (key.j.pressed) rect.x2--;
			if (key.k.pressed) rect.y2++;
			if (key.l.pressed) rect.x2++;
			
			if (key.down.pressed) circ1.r -= 0.1;
			if (key.up.pressed) circ1.r += 0.1;
			
		}
		
		if (key.t.typed) action.play();
		
		if (key.space.typed) action.setVolume(0);
		if (key.one.typed) action.setVolume(0.1);
		if (key.two.typed) action.setVolume(0.2);
		if (key.three.typed) action.setVolume(0.3);
		if (key.four.typed) action.setVolume(0.4);
		if (key.five.typed) action.setVolume(0.5);
		if (key.six.typed) action.setVolume(0.6);
		if (key.seven.typed) action.setVolume(0.7);
		if (key.eight.typed) action.setVolume(0.8);
		if (key.nine.typed) action.setVolume(0.9);
		if (key.zero.typed) action.setVolume(1);
		
	}
	
	public void render () {
		
		if (key.slash.pressed) game.screen.on.render(0, 0, new Sprite(0xFFFF0000, 100, 100));
		
		circ1.render(this);
		line1.render(this);
		circ2.render(this);
		line2.render(this);
		circ3.render(this);
		line3.render(this);
		
		rect.render(this);
		
	}
	
}
