package com.chaseplays.engine.text;

public enum rColor {
	
	RED (0xFFFF0000), DARKRED (0x660000), PINK (0xFFAAAA), 
	ORANGE (0xFFAA00), DARKORANGE (0xFF8600), LIGHTORANGE (0xFFFBAC54), 
	YELLOW (0xFFF2FF00), DARKYELLOW (0xFF7E8500), LIGHTYELLOW (0xFFAFF9D),
	GREEN (0xFF1AD569), DARKGREEN (0xFF00451D), LIGHTGREEN (0xFF5DDD93),
	BLUE (0x0454FF), DARKBLUE (0xFF002067), LIGHTBLUE (0xFF27C147),
	PURPLE (0xFFBC00FF), DARKPURPLE (0xFF3a0048), LIGHTPURPLE (0xFFCD6CE4),
	WHITE (0xFFFFFFFF), LIGHTGRAY (0xFFDDDDDD), DARKGRAY (0xFF333333), BLACK (0xFF000000),
	BROWN (0x996600), TAN (0xFFecc77c);
	
	public int color;
	
	rColor (int color) {
		
		this.color = color;
		
	}
	
}
