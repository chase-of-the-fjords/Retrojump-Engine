package com.chaseplays.engine.test;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.Game;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;
import com.chaseplays.engine.single.PhysicalObject;
import com.chaseplays.engine.sound.Sound;

public class jumpTest extends Game {
	
	private static final long serialVersionUID = 1L;
	
	public static jumpTest game = new jumpTest();
	
	public Player player = new Player();
	
	public Action framesPerSecond = new Action(1000, 0);
	
	public Level level = new Level();
	
	public int frame = 0;
	
	public Sound sound = new Sound("dimensional_time.wav");
	
	public static void main (String[] args) {
		
		game.setDimensions(150, 150, 4);
		
		game.setTitle("Jump Test Program");
		
		game.start();
		
	}
	
	public void setupGame () {
		
		framesPerSecond.start();
		
	}
	
	public void update () {
		
		player.update(this);
		
		if (framesPerSecond.able()) {
			
			game.setTitle("Jump Testing: " + frame + " fps");
			
			frame = 0;
			
			framesPerSecond.gather();
			
		}
		
	}
	
	public void render () {
		
		level.render(this);
		player.render(this);
		
		frame++;
		
	}
	
	class Player extends PhysicalObject {
		
		public Sprite sprite;
		
		public Player () {
			
			pWidth = 3;
			pHeight = 3;
			
			thrust = 1.4;
			maximum_downwards_velocity = -0.7;
			v_decay = 0.03;
			
			h_decay = 0.03;
			h_acceleration = 0.06;
			maximum_h_velocity = 0.4;
			
			sprite = new Sprite(0xFFFF0000, pWidth, pHeight);
			
		}
		
		public boolean level_blocked (int new_x, int new_y) {
			
			Sprite s = new Sprite(jumpTest.game.level.level_sprite, new_x, new_y, pWidth, pHeight);
			
			boolean empty = false;
			
			for (int y = 0; y < s.height; y++) {
				
				for (int x = 0; x < s.width; x++) {
					
					if (s.pixels[x + (y * s.width)] != 0xFFFFFFFF) empty = true;
					
				}
				
			}
			
			return empty;
			
		}
		
		public void update (Engine e) {
			
			if (e.key.apostrophe.typed) sound.play();
			if (e.key.semicolon.typed) sound.stop();
			if (e.key.dash.typed) sound.setVolume(0.5);
			if (e.key.l.typed) sound.fade_out(100);
			
			updatePhysics(e);
			
		}
		
		public void render (Engine e) {
			
			e.screen.in.render((int) x, (int) y, sprite); 
			
		}
		
	}
	
	class TechAction {
		
		int timeSinceLast;
		
		int limit;
		
		public TechAction (int limit) {
			
			this.limit = limit;
			
		}
		
		public boolean able () {
			
			timeSinceLast++;
			
			if (timeSinceLast >= limit) return true;
			
			return false;
			
		}
		
		public void gather () {
			
			timeSinceLast -= limit;
			
		}
		
	}
	
	class Level {
		
		public Sprite level_sprite = new Sprite("/map.png");
		
		public Level () {
			
			
			
		}
		
		public void render (Engine e) {
			
			e.screen.in.render(0, 0, level_sprite);
			
		}
		
	}
	
}