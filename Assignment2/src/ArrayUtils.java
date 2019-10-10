
public class ArrayUtils {
	
	// Modified original code from following website:
	// Source: https://www.java67.com/2018/05/how-to-rotate-array-left-and-right-by-given-number.html
	public static Object[] rotateArrayRight(Object[] input, int numOfRotations) {
		
		if(numOfRotations <= 0 || input == null || input.length == 0)
			return input;
		
		int length = input.length;
		
		Object[] working = input.clone();
		
		for (int i = 0; i < numOfRotations; i++) {
		
			// take out the last element
			Object temp = working[length - 1];
			
			for (int j = length - 1; j > 0; j--) {
				// shift array elements towards right by one place
				working[j] = working[j - 1];
			}
			working[0] = temp;
		}
		return working;
	}
}
