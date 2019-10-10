import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class CenterPanelTest {	
	Init init;
	CenterPanel panel;
	
	@Before
	public void setUp() {
		init = new Init();
		panel = new CenterPanel(Color.yellow, init);
	}
	
	@Test
	public void rotating_colors() {
		panel.rotateClockwiseAroundCenter(1);
		assertSame(init.colors[3], init.panels[0].getBackground());
		assertSame(init.colors[0], init.panels[1].getBackground());
		assertSame(init.colors[1], init.panels[2].getBackground());
		assertSame(init.colors[6], init.panels[3].getBackground());
		assertSame(init.colors[2], init.panels[5].getBackground());
		assertSame(init.colors[7], init.panels[6].getBackground());
		assertSame(init.colors[8], init.panels[7].getBackground());
		assertSame(init.colors[5], init.panels[8].getBackground());	
	}
}
