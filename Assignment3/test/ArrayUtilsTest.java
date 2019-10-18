import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class ArrayUtilsTest {	
	
	@Test(expected = java.lang.NullPointerException.class) 
	public void null_returns_exception() {
		ArrayUtils.rotateArrayRight(null, 1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class) 
	public void invalid_num_rotations_exception() {
		Integer start[] = {0, 1};
		ArrayUtils.rotateArrayRight(start, -2);
	}
	
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class) 
	public void empty_returns_exception() {
		Integer start[] = { };
		ArrayUtils.rotateArrayRight(start, 1);
	}

	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class) 
	public void rotate_more_than_array_zerobased_length() {
		Integer start[] = {0, 1, 2, 5, 8, 7, 6, 3};
		ArrayUtils.rotateArrayRight(start, 8);
	}
	
	@Test
	public void rotating_indexes_right_by_1() {
		
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
	public void rotating_colors_right_by_1() {
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
