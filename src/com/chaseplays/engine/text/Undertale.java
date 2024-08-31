package com.chaseplays.engine.text;

import java.util.Random;

public class Undertale implements TextAction {
	
	public static Random rand = new Random();
	
	public Undertale () {
		
	}
	
	public void update () { }
	
	public int xchange(int position) {
		
		int show = rand.nextInt(200);
		
		if (show == 10) return 1;
		if (show == 90) return -1;
		
		return 0;
		
	}
	
	public int ychange(int position) {
		
		int show = rand.nextInt(200);
		
		if (show == 10) return 1;
		if (show == 90) return -1;
		
		return 0;
		
	}
	
	public boolean show () {
		
		int show = rand.nextInt(1000);
		
		return show != 50;
		
	}

}
