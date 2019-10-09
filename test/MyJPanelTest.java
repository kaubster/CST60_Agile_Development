import static org.junit.Assert.assertSame;

import java.awt.Color;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class MyJPanelTest {
	private static final Color COLOR = Color.BLACK;
	private static final Color MAGENTA = Color.magenta;
	MyJPanel myJPanel;

	@BeforeEach
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
}