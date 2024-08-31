package com.chaseplays.engine;

/**
 * 
 * The general class for a "game".
 * 
 * @author Chase "Bown" Peterson
 *
 */

public class Game extends Engine {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * sets up the game and it's objects
	 * 
	 */
	
	public void start () {
		
		setup();
		
		setupGame();
		
		run(this);
		
	}
	
	public void setupGame () {
		
		
		
	}
	
	public void u () {
		
		screen.cam.update(this);
		
		update();
		
	}
	
	/**
	 * 
	 * the update method of a game and it's objects
	 * 
	 */
	
	public void update () {
		
		
		
	}
	
	public void r () {
		
		render();
		
	}
	
	/**
	 * 
	 * the render method of a game and it's objects
	 * 
	 */
	
	public void render () {
		
		
		
	}
	
}
