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
}
