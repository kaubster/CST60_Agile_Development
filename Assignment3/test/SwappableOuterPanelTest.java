import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class SwappableOuterPanelTest {	
	private static final Color BLACK = Color.BLACK;
	private static final Color MAGENTA = Color.magenta;
	Init init;
	SwappableOuterPanel panel1;
	SwappableOuterPanel panel2;
	
	@Before
	public void setUp() {
		init = new Init();
		panel1 = (SwappableOuterPanel)init.panels[0];
		panel2 = (SwappableOuterPanel)init.panels[1];
	}
	
	@Test
	public void panel0_is_SwappableOuterPanel() {
		assertThat(init.panels[0], instanceOf(SwappableOuterPanel.class));
	}	
	
	@Test
	public void panel1_is_SwappableOuterPanel() {
		assertThat(init.panels[1], instanceOf(SwappableOuterPanel.class));
	}
	
	private MouseEvent mock_mouse(SwappableOuterPanel panel) {
		return new MouseEvent(panel, 0, 0, 0, 0, 0, 0, false);		
	}
	
	@Test
	public void swap_colors_first_click_no_previous_to_swap() {
		MouseEvent mMouseEvent = mock_mouse(panel1);
		panel1.clicked(mMouseEvent);		
		validate_unchanged_panel_colors();		
	}
	
	@Test
	public void swap_colors_second_click_claim_previous_color() {
		Color color1 = panel1.getBackground();
		Color color2 = panel2.getBackground();
		MouseEvent mMouseEvent = mock_mouse(panel1);
		panel1.clicked(mMouseEvent);
		MouseEvent mMouseEvent2 = mock_mouse(panel2);
		panel2.clicked(mMouseEvent2);
		assertSame(color1, panel2.getBackground());
		assertSame(color2, panel1.getBackground());	
	}
	
	@Test
	public void swap_colors_third_click_claim_original_color() {
		swap_colors_second_click_claim_previous_color();
		MouseEvent mMouseEvent = mock_mouse(panel1);
		panel1.clicked(mMouseEvent);
		validate_unchanged_panel_colors();		
	}

	private void validate_unchanged_panel_colors() {
		assertSame(init.colors[0], init.panels[0].getBackground());
		assertSame(init.colors[1], init.panels[1].getBackground());
		assertSame(init.colors[2], init.panels[2].getBackground());
		assertSame(init.colors[3], init.panels[3].getBackground());
		assertSame(init.colors[4], init.panels[4].getBackground());
		assertSame(init.colors[5], init.panels[5].getBackground());
		assertSame(init.colors[6], init.panels[6].getBackground());
		assertSame(init.colors[7], init.panels[7].getBackground());
	}
}
