package com.chaseplays.engine.graphics;

import java.util.ArrayList;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.screen.Sprite;

public class Animation {
	
	public volatile ArrayList<Frame> frames = new ArrayList<Frame>();
	
	public volatile int frame = 0;
	
	public volatile boolean loop;
	
	public volatile boolean active;
	
	public Thread animate;
	
	public Animation(Object... animframes) {
		
		for (int x = 0; x < animframes.length / 2; x++) {
			
			this.frames.add(new Frame((String) animframes[x * 2], (int) animframes[(x * 2) + 1]));
			
		}
		
		animate = new Thread () {
			
			public void run () {
				
				while (active) {
					
					try {
						Thread.sleep(frames.get(frame).duration);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					frame++;
					
					if (loop) frame %= frames.size();
					else if (frame >= frames.size()) active = false;
					
				}
				
			}
			
		};
		
	}
	
	public void start () {
		
		frame = 0;
		
		this.loop = true;
		this.active = true;
		
		animate.start();
		
	}
	
	public void play () {
		
		Animation a = getCopy();
		
		a.frame = 0;
		
		a.active = true;
		a.loop = false;
		
		animate.start();
		
	}
	
	public void stop () {
		
		loop = false;
		
	}
	
	public void startSimilar (boolean loop) {
		
	}
	
	public void update (Engine e) {
		
	}
	
	public Sprite getSprite (Engine e) {
		
		return this.frames.get(frame).sprite;
		
	}
	
	public ArrayList<Frame> getFramesClone () {
		
		ArrayList<Frame> result = new ArrayList<Frame>();
		
		for (int x = 0; x < frames.size(); x++) result.add(frames.get(x));
		
		return result;
		
	}
	
	public Animation getCopy () {
		
		Animation copy = new Animation();
		
		copy.frames = this.getFramesClone();
		
		copy.frame = this.frame;
		
		copy.loop = this.loop;
		
		copy.active = this.active;
		
		return copy;
		
	}
	
}
