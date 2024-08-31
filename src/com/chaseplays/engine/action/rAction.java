package com.chaseplays.engine.action;

import com.chaseplays.engine.single.rEntity;

public class rAction {
	
	public rEntity r = new rEntity();
	
	public rEntity go (rEntity r) {
		
		this.r = r;
		
		if (able()) run();
		
		return this.r;
		
	}
	
	public boolean able () {
		
		return true;
		
	}
	
	public void run () {
		
	}
	
}
