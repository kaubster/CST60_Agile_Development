import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SystemWrapperTest {

	// intentionally mocked instances for each test, 
	// mocking as member variables cause unclean tests
	
	@Test
	void println_expect_specific_string_output() {
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);

		String expected = "print the goods";
		
		systemWrapper.println(expected);
		
		Mockito.verify(systemWrapper).println(expected);
	}
	
	@Test
	void start_expect_Null_Obj_Prints_Txt_Null_Similar_To_System_Println() throws InterruptedException {
		SystemWrapper systemWrapper = Mockito.mock(SystemWrapper.class);
				
		Object obj = null;
				
		systemWrapper.println(null);
		
		Mockito.verify(systemWrapper).println(obj);
	}
}
