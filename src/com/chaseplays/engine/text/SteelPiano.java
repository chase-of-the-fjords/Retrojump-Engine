package com.chaseplays.engine.text;

public class SteelPiano extends Font {
	
	public SteelPiano (String path, int space, int gap, int size) {
		
		super(path, space, gap, size);
		
		for (int f = 0; f < figures.length; f++) {
			
			if (f == 0) figures[f] = new Figure(path, 3, 8, 'A');
			if (f == 1) figures[f] = new Figure(path, 3, 8, 'B');
			if (f == 2) figures[f] = new Figure(path, 3, 8, 'C');
			if (f == 3) figures[f] = new Figure(path, 3, 8, 'D');
			if (f == 4) figures[f] = new Figure(path, 3, 8, 'E');
			if (f == 5) figures[f] = new Figure(path, 3, 8, 'F');
			if (f == 6) figures[f] = new Figure(path, 3, 8, 'G');
			if (f == 7) figures[f] = new Figure(path, 3, 8, 'H');
			if (f == 8) figures[f] = new Figure(path, 3, 8, 'I');
			if (f == 9) figures[f] = new Figure(path, 3, 8, 'J');
			
			if (f == 10) figures[f] = new Figure(path, 3, 8, 'K');
			if (f == 11) figures[f] = new Figure(path, 3, 8, 'L');
			if (f == 12) figures[f] = new Figure(path, 5, 8, 'M');
			if (f == 13) figures[f] = new Figure(path, 4, 8, 'N');
			if (f == 14) figures[f] = new Figure(path, 3, 8, 'O');
			if (f == 15) figures[f] = new Figure(path, 3, 8, 'P');
			if (f == 16) figures[f] = new Figure(path, 3, 8, 'Q');
			if (f == 17) figures[f] = new Figure(path, 3, 8, 'R');
			if (f == 18) figures[f] = new Figure(path, 3, 8, 'S');
			if (f == 19) figures[f] = new Figure(path, 3, 8, 'T');
			
			if (f == 20) figures[f] = new Figure(path, 3, 8, 'U');
			if (f == 21) figures[f] = new Figure(path, 3, 8, 'V');
			if (f == 22) figures[f] = new Figure(path, 5, 8, 'W');
			if (f == 23) figures[f] = new Figure(path, 3, 8, 'X');
			if (f == 24) figures[f] = new Figure(path, 3, 8, 'Y');
			if (f == 25) figures[f] = new Figure(path, 3, 8, 'Z');
			
			
			
			if (f == 26) figures[f] = new Figure(path, 3, 8, 'a');
			if (f == 27) figures[f] = new Figure(path, 3, 8, 'b');
			if (f == 28) figures[f] = new Figure(path, 3, 8, 'c');
			if (f == 29) figures[f] = new Figure(path, 3, 8, 'd');
			
			if (f == 30) figures[f] = new Figure(path, 3, 8, 'e');
			if (f == 31) figures[f] = new Figure(path, 3, 8, 'f');
			if (f == 32) figures[f] = new Figure(path, 3, 8, 'g');
			if (f == 33) figures[f] = new Figure(path, 3, 8, 'h');
			if (f == 34) figures[f] = new Figure(path, 1, 8, 'i');
			if (f == 35) figures[f] = new Figure(path, 1, 8, 'j');
			if (f == 36) figures[f] = new Figure(path, 3, 8, 'k');
			if (f == 37) figures[f] = new Figure(path, 1, 8, 'l');
			if (f == 38) figures[f] = new Figure(path, 5, 8, 'm');
			if (f == 39) figures[f] = new Figure(path, 3, 8, 'n');
			
			if (f == 40) figures[f] = new Figure(path, 3, 8, 'o');
			if (f == 41) figures[f] = new Figure(path, 3, 8, 'p');
			if (f == 42) figures[f] = new Figure(path, 3, 8, 'q');
			if (f == 43) figures[f] = new Figure(path, 3, 8, 'r');
			if (f == 44) figures[f] = new Figure(path, 3, 8, 's');
			if (f == 45) figures[f] = new Figure(path, 3, 8, 't');
			if (f == 46) figures[f] = new Figure(path, 3, 8, 'u');
			if (f == 47) figures[f] = new Figure(path, 3, 8, 'v');
			if (f == 48) figures[f] = new Figure(path, 5, 8, 'w');
			if (f == 49) figures[f] = new Figure(path, 3, 8, 'x');
			if (f == 50) figures[f] = new Figure(path, 3, 8, 'y');
			if (f == 51) figures[f] = new Figure(path, 3, 8, 'z');
			
			if (f == 52) figures[f] = new Figure(path, 3, 8, '1');
			if (f == 53) figures[f] = new Figure(path, 3, 8, '2');
			if (f == 54) figures[f] = new Figure(path, 3, 8, '3');
			if (f == 55) figures[f] = new Figure(path, 3, 8, '4');
			if (f == 56) figures[f] = new Figure(path, 3, 8, '5');
			if (f == 57) figures[f] = new Figure(path, 3, 8, '6');
			if (f == 58) figures[f] = new Figure(path, 3, 8, '7');
			if (f == 59) figures[f] = new Figure(path, 3, 8, '8');
			
			if (f == 60) figures[f] = new Figure(path, 3, 8, '9');
			if (f == 61) figures[f] = new Figure(path, 3, 8, '0');
			
			
			
			if (f == 62) figures[f] = new Figure(path, 1, 8, '!');
			if (f == 63) figures[f] = new Figure(path, 5, 8, '@');
			if (f == 64) figures[f] = new Figure(path, 5, 8, '#');
			if (f == 65) figures[f] = new Figure(path, 3, 8, '$');
			if (f == 66) figures[f] = new Figure(path, 3, 8, '%');
			if (f == 67) figures[f] = new Figure(path, 4, 8, '^');
			if (f == 68) figures[f] = new Figure(path, 4, 8, '&');
			if (f == 69) figures[f] = new Figure(path, 3, 8, '*');
			
			if (f == 70) figures[f] = new Figure(path, 2, 8, '(');
			if (f == 71) figures[f] = new Figure(path, 2, 8, ')');
			if (f == 72) figures[f] = new Figure(path, 3, 8, '_');
			if (f == 73) figures[f] = new Figure(path, 3, 8, '-');
			if (f == 74) figures[f] = new Figure(path, 3, 8, '+');
			if (f == 75) figures[f] = new Figure(path, 3, 8, '=');
			if (f == 76) figures[f] = new Figure(path, 2, 8, '{');
			if (f == 77) figures[f] = new Figure(path, 2, 8, '[');
			if (f == 78) figures[f] = new Figure(path, 2, 8, '}');
			if (f == 79) figures[f] = new Figure(path, 2, 8, ']');
			
			if (f == 80) figures[f] = new Figure(path, 1, 8, '|');
			if (f == 81) figures[f] = new Figure(path, 3, 8, '"');
			if (f == 82) figures[f] = new Figure(path, 1, 8, '\'');
			if (f == 83) figures[f] = new Figure(path, 1, 8, ':');
			if (f == 84) figures[f] = new Figure(path, 1, 8, ';');
			if (f == 85) figures[f] = new Figure(path, 3, 8, '?');
			if (f == 86) figures[f] = new Figure(path, 3, 8, '/');
			if (f == 87) figures[f] = new Figure(path, 3, 8, '>');
			if (f == 88) figures[f] = new Figure(path, 1, 8, '.');
			if (f == 89) figures[f] = new Figure(path, 3, 8, '<');
			
			if (f == 90) figures[f] = new Figure(path, 1, 8, ',');
			if (f == 91) figures[f] = new Figure(path, 3, 8, '\\');
			if (f == 92) figures[f] = new Figure(path, 4, 8, '~');
			if (f == 93) figures[f] = new Figure(path, 2, 8, '`');
			
		}
	
	}
	
}
