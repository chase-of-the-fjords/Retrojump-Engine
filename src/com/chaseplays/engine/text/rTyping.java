package com.chaseplays.engine.text;

public enum rTyping {
	
	ITALICS, BOLD, SINE, SHAKE, DEFAULT, 
	NO_ITALICS, NO_BOLD, NO_SINE, NO_SHAKE;
	
	public TextAction getAction () {
		
		if (this.equals(SHAKE)) return new Shake(1);
		if (this.equals(SINE)) return new Wobble(5, 25);
		else return new Shake(3);
		
	}
	
}
