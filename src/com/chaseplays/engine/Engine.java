package com.chaseplays.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.chaseplays.engine.action.Action;
import com.chaseplays.engine.input.Keyboard;
import com.chaseplays.engine.input.Mouse;
import com.chaseplays.engine.screen.Cam;
import com.chaseplays.engine.screen.Screen;
import com.chaseplays.engine.sound.Sound;

/**
 * 
 * the class that "runs" the game.
 * the general engine of the game, that
 * renders, updates, and sets everything up.
 * 
 * @author Chase Peterson
 *
 */

public class Engine extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * the major version of the game engine.
	 * 
	 */
	
	public int majorVersion = 0;
	
	/**
	 * 
	 * the minor version of the game engine.
	 * 
	 */
	
	public int minorVersion = 15;
	
	/**
	 * 
	 * the patch of the game engine.
	 * 
	 */
	
	public int patch = 2;
	
	/**
	 * 
	 * the title of the game. defaults
	 * to "Retrojump major.minor.patch"
	 * 
	 */
	
	public String title = "Retrojump " + majorVersion + "." + minorVersion + "." + patch;
	
	/**
	 * 
	 * the size of the window
	 * 
	 */
	
	public int width = 100, height = 80, scale = 5;
	
	/**
	 * 
	 * whether or not the game is currently running
	 * 
	 */
	
	public boolean running = false;
	
	/**
	 * 
	 * the frame (or window) of the game
	 * 
	 */
	
	public JFrame frame = new JFrame();
	
	/**
	 * 
	 * the image displayed on the window
	 * 
	 */
	
	public BufferedImage image; 
	
	/**
	 * 
	 * the pixel-array which forms an image
	 * on the window
	 * 
	 */
	
	public int[] pixels;
	
	/**
	 * 
	 * the bufferstrategy of the game. pre-loads
	 * the image on the screen before showing it.
	 * 
	 */
	
	public BufferStrategy buffer;
	
	/**
	 * 
	 * the screen of the game. responsible for
	 * rendering sprites onto the window.
	 * 
	 */
	
	public Screen screen;
	
	/**
	 * 
	 * the mouse of the game. tracks position,
	 * left click, right click, and middle click,
	 * among other things.
	 * 
	 */
	
	public Mouse mouse;
	
	/**
	 * 
	 * the keyboard of the game. tracks whether
	 * or not any key on the keyboard is pressed
	 * 
	 */
	
	public Keyboard key;
	
	/**
	 * 
	 * The list of current sounds in the game system.
	 * 
	 */
	
	public ArrayList<Sound> sounds = new ArrayList<Sound>();
	
	/**
	 * 
	 * renders the screen, either starting or finishing the render
	 * 
	 * @param e the game
	 * 
	 */
	
	public void render (Game e) {
		
		buffer = getBufferStrategy(); // sets the bufferstrategy
		
		if (buffer == null) { // checks if bufferstrategy exists
			
			createBufferStrategy(3); // if not, creates a bufferstrategy
			
			return; // returns the render method
			
		}
		
		screen.clear(); // clears the screen
		
		e.r(); // renders everything in the game
		
		for (int i = 0; i < pixels.length; i++) pixels[i] = screen.pixels[i]; // sets the pixels on the screen
		
		Graphics g = buffer.getDrawGraphics(); // draws the bufferstrategy onto the graphics
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); // draws the graphics into the image
		g.dispose(); // disposes the graphics
		
		buffer.show(); // shows the graphics on the screen
		
	}
	
	/**
	 * 
	 * the general update method for the game engine.
	 * updates each part of the engine, specifically
	 * the mouse, keyboard, and game.
	 * 
	 * @param e the game
	 * 
	 */
	
	public void update (Game e) {
		
		mouse.update(); // updates the mouse
		key.update(); // updates the keyboard
		
		e.u(); // updates the game
		
	}
	
	/**
	 * 
	 * sets up the initial game and window
	 * 
	 */
	
	public void setup () {
		
		Dimension size = new Dimension(width * scale, height * scale); // sets a variable equal to the size of the screen
		setPreferredSize(size); // sets the size of the screen
		
		frame = new JFrame();
		
		frame.setResizable(false); // does not allow the game's JFrame to be resizable
		frame.add(this); // adds the game to the JFrame
		frame.pack(); // sets the size of the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes sure that the windows exits when it's closed
		frame.setLocationRelativeTo(null); // sets the JFrame at the middle of the screen
		frame.setVisible(true); // sets the JFrame to be visible
		frame.setLayout(new BorderLayout()); // sets the layout of the JFrame
		
		frame.setTitle(title); // sets the title of the JFrame
	
		mouse = new Mouse(); // creates the mouse
		
		key = new Keyboard(); // creates the keyboard
		
		mouse.setup();
		key.setup();
		
		screen = new Screen(width, height, new Cam(width, height)); // creates the screen
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // creates the image
		
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // creates the pixel-array
		
		addMouseListener(mouse); // adds the mouse into the game
		addMouseMotionListener(mouse); // adds the mouse into the game
		addKeyListener(key); // adds the keyboard into the game
		
		requestFocus(); // requests for the OS to direct it's focus to the game
		
	}
	
	/**
	 * 
	 * runs the game
	 * 
	 * @param e the game
	 * 
	 */
	
	public void run (Game e) {
		
		running = true; // sets the game to "running"
		
		Action techTimer = new Action(10, 0); // the timer that causes the game to update every 1/100 seconds.
		
		techTimer.start();
		
		while (running) { // loops as long as the game is running
			
			render(e); // renders the game
			
			while (techTimer.able()) { // loops as long as it has been at least one tech since the last update
				
				techTimer.gather(); // resets the tech timer.
				
				update(e); // updates the game
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * sets the dimensions of the game
	 * 
	 * @param width the amount of pixels for the width of the screen
	 * @param height the amount of pixels for the height of the screen
	 * @param scale the scale of each pixel
	 * 
	 */
	
	public void setDimensions (int width, int height, int scale) {
		
		if (width != -1) this.width = width; // sets the width
		if (height != -1) this.height = height; // sets the height
		if (scale != -1) this.scale = scale; // sets the scale
		
	}
	
	/**
	 * 
	 * sets the title of the game
	 * 
	 * @param title the title of the game
	 * 
	 */
	
	public void setTitle (String title) {
		
		this.title = title; // sets the title variable
		
		this.frame.setTitle(title); // sets the frame title
		
	}
	
	/**
	 * 
	 * sets the icon for the window
	 * 
	 * @param path where the icon is located
	 * 
	 */
	
	public void setIcon (String path) {
		
		try { // attempts the following code
			
			Image icon = Toolkit.getDefaultToolkit().getImage(Engine.class.getResource(path)); // sets the icon of the game
			
			frame.setIconImage(icon); // attaches the icon of the game to the frame
			
		} catch (Exception e) { } // catches an exception if there is one
		
	}
	
	/**
	 * 
	 * gets the x location of the mouse
	 * 
	 * @param factorScale whether or not the scale of the window should be factored
	 * @return the x location of the mouse
	 * 
	 */
	
	public int getMouseX (boolean factorScale) {
		
		int mouseX = mouse.x; // finds the mouse's x location
		
		if (factorScale) mouseX /= scale; // factors scale if requested
		
		return mouseX; // returns the mouse's x location
		
	}
	
	/**
	 * 
	 * gets the y location of the mouse
	 * 
	 * @param factorScale whether or not the scale of the window should be factored
	 * @return the x location of the mouse
	 * 
	 */
	
	public int getMouseY (boolean factorScale) {
		
		int mouseY = mouse.y; // finds the mouse's y location
		
		if (factorScale) mouseY /= scale; // factors scale if requested
		
		return mouseY; // returns the mouse's y location
		
	}
	
	/**
	 * 
	 * (nonfunctional) sets the game window to occupy the entire screen
	 * 
	 */
	
	public void setFullscreen () {
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
	}
	
}