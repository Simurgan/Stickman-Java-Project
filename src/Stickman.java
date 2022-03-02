public class Stickman {
	public static void main(String[] args) {
		int stickmanHeight = Integer.parseInt(args[0]);
		int stairHeight = Integer.parseInt(args[1]);
		
		//Declare variables
		
		String head = " O ", arms = "/|\\", body = " | ", legs = "/ \\", rung = "___|", blank = "   ", stars = "***", ender = "|";
		/* Each part of stickman is declared above to read and write the code easily and logically.
		 * Rungs of stairs, the end of the stairs (ender), triple stars and triple blanks are also declared for the same reason. */
		
		//Render each frame
		
		for(int i = 0; i <= stairHeight; i++) {
			//Render initial blank lines
			
			blankLiner(0, stairHeight - i);

			//Render the line with head (always no rung)
			
			endOfLine(0, i, blank, head);
			
			//Render the line with arms (always no rung)
			
			endOfLine(0, i, blank, arms);
			
			//Render the lines which are with body and without rung/s
			
			for(int pbl = 0; pbl < stickmanHeight - stairHeight - 3 + i; pbl++) {//pbl stands for primary body lines.
				endOfLine(0, i, blank, body);
			}
			
			//Render the lines which are with body and also rung/s
			
			for(int sbl = 0; sbl < stairHeight - i; sbl++) {//sbl stands for secondary body lines
				midOfLine(0, i, blank, body);
				midOfLine(0, stairHeight - i - sbl, blank, rung);
				endOfLine(0, sbl, stars, ender);
			}
			
			//Render the line with legs (always has rung)
			
			midOfLine(0, i, blank, legs + rung);
			endOfLine(0, stairHeight - i, stars, ender);
			
			//Render the lines which are with empty rung/s
			
			for(int es = 0; es < i; es++) {//es stands for empty stairs
				midOfLine(0, i - es, blank, rung);
				endOfLine(0, stairHeight - i + es + 1, stars, ender);
			}
			
			//Render last blank lines
			
			blankLiner(0, 3);
		}
	}
	
	//Define methods to avoid repeating
	
	/* endOfLine method does the repeatition for stars and blanks and then prints sth that is at the end of line.
	 * It was defined to use less character in project source code */
	public static void endOfLine(int initial, int condition, String repeated, String end) {
		for(int k = initial; k < condition; k++) {
			System.out.print(repeated);
		}
		System.out.println(end);
	}
	
	/* midOfLine method does the repeatition for stars and blanks and then prints sth that is at the mid of line.
	 * It was defined to use less character in project source code */
	public static void midOfLine(int initial, int condition, String repeated, String mid) {
		for(int k = initial; k < condition; k++) {
			System.out.print(repeated);
		}
		System.out.print(mid);
	}
	
	/* blankLiner method prints blank lines for changeable times.
	 * It was defined to use less character in project source code */
	public static void blankLiner(int initial, int condition) {
		for(int bl = initial; bl < condition; bl++) {//bl stands for blank lines
			System.out.println();
		}
	}
}