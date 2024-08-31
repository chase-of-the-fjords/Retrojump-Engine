package com.chaseplays.engine.single;

import com.chaseplays.engine.Engine;
import com.chaseplays.engine.graphics.Animation;
import com.chaseplays.engine.screen.Sprite;

public class rEntity implements Single {
	
	public Sprite sprite;
	
	public Animation defaultAnim;
	
	public Animation animation = new Animation();
	
	public int x, y;
	
	public int xOffset = 0, yOffset = 0;
	
	public void setup (Engine e) {
		
		
		
	}
	
	public void u (Engine e) {
		
		update(e);
		
		if (animation.active) animation.update(e);
		
		//if (animation.finished) this.resort();
		
	}
	
	public void update (Engine e) {
		
	}
	
	public void render (Engine e) {
		
		e.screen.in.render(x - xOffset, y - yOffset, animation.getSprite(e));
		
	}
	
	public void play (Animation a, boolean loop) {
		
		if (!animation.frames.equals(a.frames)) {
			
			this.animation = a.getCopy();
			
			animation.start();
			
		}
		
	}
	
	public void playSimilar (Animation a) {
		
		playSimilar(a, false);
		
	}
	
	public void playSimilar (Animation a, boolean loop) {
		
		this.animation.frames = a.getFramesClone();
		
		animation.startSimilar(loop);
		
	}
	
	public void play (Animation a) {
		
		play(a, false);
		
	}
	
	public void setDefaultAnimation (Animation a) {
		
		this.defaultAnim = a.getCopy();
		play(defaultAnim, true);
		
	}
	
	public void resortIfEquals (Animation a) {
		
		if (animation.frames.equals(a.frames)) play(defaultAnim, true);
		
	}
	
	public void resort () {
		
		play(defaultAnim);
		
	}
	
}
