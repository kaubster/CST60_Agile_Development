import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
//import org.junit.jupiter.api.*;

public class ArrayUtilsTest {	
	@Test
	public void rotating_indexes() {
		
		// 0, 1, 2, 
		// 3,    5, 
		// 6, 7, 8 };
		Integer start[] = {0, 1, 2, 5, 8, 7, 6, 3};

		//  3, 0, 1, 
		//  6,    2, 
		//  7, 8, 5};
		Integer expected[] = {3, 0, 1, 2, 5, 8, 7, 6}; 
		
		Integer actual[] = (Integer[])ArrayUtils.rotateArrayRight(start, 1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void rotating_colors() {
		Color start[] = { 
				Color.blue, Color.green, Color.red, 
				Color.black, Color.gray, Color.cyan, 
				Color.orange, Color.white};

		Color expected[] = { Color.white, Color.blue, Color.green, 
				Color.red, Color.black, Color.gray, 
				Color.cyan, Color.orange};
				
		Color actual[] = (Color[])ArrayUtils.rotateArrayRight(start, 1);
		
		assertArrayEquals(expected, actual);
	}
}
