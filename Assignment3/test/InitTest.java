import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class InitTest {
	private static final Color MAGENTA = Color.magenta;
	Init init;

	@Before
	public void setUp() {
		init = new Init();
	}
	
	private void click_panel4_this_many_times(int num_clicks) {
		for (int i = 0; i < num_clicks; i++) {
			init.panels[4].clicked();
		}
	}
		
	@Test
	public void set_last_clicked_panel_reference() {
		MyJPanel testPanel = new MyJPanel(MAGENTA);
		init.setLastClickedPanel(testPanel);
		MyJPanel actual = init.getLastClickedPanel();
		assertSame(testPanel, actual);
	}
	
	@Test
	public void set_last_clicked_panel_color() {
		MyJPanel testPanel = new MyJPanel(MAGENTA);
		init.setLastClickedPanel(testPanel);
		MyJPanel actual = init.getLastClickedPanel();
		assertSame(MAGENTA, actual.getBackground());
	}

	private void validate_unchanged_panels() {
		assertSame(init.colors[0], init.panels[0].getBackground());
		assertSame(init.colors[1], init.panels[1].getBackground());
		assertSame(init.colors[2], init.panels[2].getBackground());
		assertSame(init.colors[3], init.panels[3].getBackground());
		assertSame(init.colors[4], init.panels[4].getBackground());
		assertSame(init.colors[5], init.panels[5].getBackground());
		assertSame(init.colors[6], init.panels[6].getBackground());
		assertSame(init.colors[7], init.panels[7].getBackground());
	}
	
	@Test
	public void panel0_is_SwappableOuterPanel() {
		assertThat(init.panels[0], instanceOf(SwappableOuterPanel.class));
	}	
	
	@Test
	public void panel1_is_SwappableOuterPanel() {
		assertThat(init.panels[1], instanceOf(SwappableOuterPanel.class));
	}

	@Test
	public void panel2_is_SwappableOuterPanel() {
		assertThat(init.panels[2], instanceOf(SwappableOuterPanel.class));
	}	
	
	@Test
	public void panel3_is_SwappableOuterPanel() {
		assertThat(init.panels[3], instanceOf(SwappableOuterPanel.class));
	}

	@Test
	public void panel4_is_CenterPanel() {
		assertThat(init.panels[4], instanceOf(CenterPanel.class));
	}

	@Test
	public void panel5_is_SwappableOuterPanel() {
		assertThat(init.panels[5], instanceOf(SwappableOuterPanel.class));
	}

	@Test
	public void panel6_is_SwappableOuterPanel() {
		assertThat(init.panels[6], instanceOf(SwappableOuterPanel.class));
	}

	@Test
	public void panel7_is_SwappableOuterPanel() {
		assertThat(init.panels[7], instanceOf(SwappableOuterPanel.class));
	}

	@Test
	public void panel8_is_SwappableOuterPanel() {
		assertThat(init.panels[8], instanceOf(SwappableOuterPanel.class));
	}
	
	private void validate_first_click_outer_panel_no_change(int i, int j) {
		Color color1 = init.panels[i].getBackground();	
		init.panels[i].clicked();
		assertSame(color1, init.panels[i].getBackground());
	}

	@Test
	public void swap_panel_color_top_left_corner_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(0);	
	}
	
	@Test
	public void swap_panel_color_top_center_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(1);	
	}
	
	@Test
	public void swap_panel_color_top_right_corner_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(2);	
	}
	
	@Test
	public void swap_panel_color_center_left_corner_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(3);	
	}
	
	@Test
	public void swap_panel_color_center_right_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(5);	
	}	
	
	@Test
	public void swap_panel_color_bottom_left_corner_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(6);	
	}
	
	@Test
	public void swap_panel_color_bottom_center_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(7);	
	}
	
	@Test
	public void swap_panel_color_bottom_right_corner_with_other_outer_panels() {
		swap_panel_color_with_other_outer_panels(8);
		
	}
		
	private void swap_panel_color_with_other_outer_panels(int initialPanelToClick) {
		init.setLastClickedPanel(init.panels[initialPanelToClick]);
		for (int i = 0; i < init.panels.length; i++) {
			validate_only_outer_panels(i);
		}
	}
	
	private MouseEvent mock_mouse(SwappableOuterPanel panel) {
		return new MouseEvent(panel, 0, 0, 0, 0, 0, 0, false);		
	}
	
	private void validate_only_outer_panels(int i) {
		
		SwappableOuterPanel panel1 = (init.panels[i] instanceof SwappableOuterPanel ? (SwappableOuterPanel)init.panels[i] : null);
		SwappableOuterPanel panel2 = (init.getLastClickedPanel() instanceof SwappableOuterPanel ? (SwappableOuterPanel)init.getLastClickedPanel() : null);
		
		// case where null is expected to be panel[4], see panel4_is_CenterPanel.
		if(panel1 != null && panel2 != null) {
			validate_swapped_panels(panel1,panel2);		
		}
	}
	
	private void validate_swapped_panels(SwappableOuterPanel panel1, SwappableOuterPanel panel2) {
		assert(panel1 != null);
		assert(panel2 != null);		
		if(panel1 != null && panel2 != null) {
			Color color1 = panel1.getBackground();
			Color color2 = panel2.getBackground();
			MouseEvent mMouseEvent = mock_mouse(panel1);
			panel2.clicked(mMouseEvent);
			assertSame(color1, panel2.getBackground());
			assertSame(color2, panel1.getBackground());			
		}
	}
	
	@Test
	public void swap_panels_1_2_colors() {
		init.setLastClickedPanel(init.panels[1]);
		validate_only_outer_panels(2);
	}

	@Test
	public void center_clockwise_rotating_colors_by_1() {
		init.panels[4].clicked();	
		assertSame(init.colors[3], init.panels[0].getBackground());
		assertSame(init.colors[0], init.panels[1].getBackground());
		assertSame(init.colors[1], init.panels[2].getBackground());	
		assertSame(init.colors[2], init.panels[5].getBackground());
		assertSame(init.colors[5], init.panels[8].getBackground());
		assertSame(init.colors[8], init.panels[7].getBackground());
		assertSame(init.colors[7], init.panels[6].getBackground());
		assertSame(init.colors[6], init.panels[3].getBackground());		
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_2() {
		click_panel4_this_many_times(2);
		assertSame(init.colors[6], init.panels[0].getBackground());
		assertSame(init.colors[3], init.panels[1].getBackground());
		assertSame(init.colors[0], init.panels[2].getBackground());	
		assertSame(init.colors[1], init.panels[5].getBackground());
		assertSame(init.colors[2], init.panels[8].getBackground());
		assertSame(init.colors[5], init.panels[7].getBackground());
		assertSame(init.colors[8], init.panels[6].getBackground());
		assertSame(init.colors[7], init.panels[3].getBackground());
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_3() {
		click_panel4_this_many_times(3);
		assertSame(init.colors[7], init.panels[0].getBackground());
		assertSame(init.colors[6], init.panels[1].getBackground());
		assertSame(init.colors[3], init.panels[2].getBackground());	
		assertSame(init.colors[0], init.panels[5].getBackground());
		assertSame(init.colors[1], init.panels[8].getBackground());
		assertSame(init.colors[2], init.panels[7].getBackground());
		assertSame(init.colors[5], init.panels[6].getBackground());
		assertSame(init.colors[8], init.panels[3].getBackground());
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_4() {
		click_panel4_this_many_times(4);
		assertSame(init.colors[8], init.panels[0].getBackground());
		assertSame(init.colors[7], init.panels[1].getBackground());
		assertSame(init.colors[6], init.panels[2].getBackground());	
		assertSame(init.colors[3], init.panels[5].getBackground());
		assertSame(init.colors[0], init.panels[8].getBackground());
		assertSame(init.colors[1], init.panels[7].getBackground());
		assertSame(init.colors[2], init.panels[6].getBackground());
		assertSame(init.colors[5], init.panels[3].getBackground());
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_5() {
		click_panel4_this_many_times(5);
		assertSame(init.colors[5], init.panels[0].getBackground());
		assertSame(init.colors[8], init.panels[1].getBackground());
		assertSame(init.colors[7], init.panels[2].getBackground());	
		assertSame(init.colors[6], init.panels[5].getBackground());
		assertSame(init.colors[3], init.panels[8].getBackground());
		assertSame(init.colors[0], init.panels[7].getBackground());
		assertSame(init.colors[1], init.panels[6].getBackground());
		assertSame(init.colors[2], init.panels[3].getBackground());
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_6() {
		click_panel4_this_many_times(6);
		assertSame(init.colors[2], init.panels[0].getBackground());
		assertSame(init.colors[5], init.panels[1].getBackground());
		assertSame(init.colors[8], init.panels[2].getBackground());	
		assertSame(init.colors[7], init.panels[5].getBackground());
		assertSame(init.colors[6], init.panels[8].getBackground());
		assertSame(init.colors[3], init.panels[7].getBackground());
		assertSame(init.colors[0], init.panels[6].getBackground());
		assertSame(init.colors[1], init.panels[3].getBackground());
	}
	
	@Test
	public void center_clockwise_rotating_colors_by_7() {
		click_panel4_this_many_times(7);
		assertSame(init.colors[1], init.panels[0].getBackground());
		assertSame(init.colors[2], init.panels[1].getBackground());
		assertSame(init.colors[5], init.panels[2].getBackground());	
		assertSame(init.colors[8], init.panels[5].getBackground());
		assertSame(init.colors[7], init.panels[8].getBackground());
		assertSame(init.colors[6], init.panels[7].getBackground());
		assertSame(init.colors[3], init.panels[6].getBackground());
		assertSame(init.colors[0], init.panels[3].getBackground());
	}	
	
	@Test
	public void center_clockwise_rotating_colors_by_8_back_to_beginning() {
		click_panel4_this_many_times(8);
		validate_unchanged_panels();
	}
}