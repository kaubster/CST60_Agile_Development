import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InitTest {
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
	public void upper_left_not_rotating_colors() {
		init.panels[0].clicked();
		validate_unchanged_panels();
	}

	@Test
	public void upper_center_not_rotating_colors() {
		init.panels[1].clicked();
		validate_unchanged_panels();
	}

	@Test
	public void upper_right_not_rotating_colors() {
		init.panels[2].clicked();
		validate_unchanged_panels();
	}
	
	@Test
	public void middle_left_not_rotating_colors() {
		init.panels[3].clicked();
		validate_unchanged_panels();
	}
	
	@Test
	public void middle_right_not_rotating_colors() {
		init.panels[5].clicked();
		validate_unchanged_panels();
	}

	@Test
	public void lower_left_not_rotating_colors() {
		init.panels[6].clicked();
		validate_unchanged_panels();
	}

	@Test
	public void lower_center_not_rotating_colors() {
		init.panels[7].clicked();
		validate_unchanged_panels();
	}

	@Test
	public void lower_right_not_rotating_colors() {
		init.panels[8].clicked();
		validate_unchanged_panels();
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