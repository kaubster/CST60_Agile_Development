import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class MyJPanelTest {
	private static final Color COLOR = Color.BLACK;
	private static final Color MAGENTA = Color.magenta;
	MyJPanel myJPanel;
	
	@Before
	public void setUp() {
		myJPanel = new MyJPanel(COLOR);
	}

	@Test
	public void set_selected_color() {
		myJPanel.setSelectedColor();
		assertSame(MAGENTA, myJPanel.getBackground());
	}

	@Test
	public void set_original_color() {
		myJPanel.setOriginalColor();
		assertSame(COLOR, myJPanel.getBackground());
	}
	
	@Test
	public void get_my_color() {
		Color actual = myJPanel.getMyColor();
		assertSame(COLOR, actual);
	}
}