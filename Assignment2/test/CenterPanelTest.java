import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.*;

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
		
	}
}
