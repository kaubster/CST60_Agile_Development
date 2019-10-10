import static org.junit.Assert.assertSame;

import java.awt.Color;

@SuppressWarnings("serial")
public class CenterPanel extends MyJPanel {
	Init init;

	public CenterPanel(Color myColor, Init init) {
		super(myColor);
		this.init = init;
	}

	@Override
	public void clicked() {
		rotateClockwiseAroundCenter(1);
	}
	
	public void rotateClockwiseAroundCenter(int i) {		
		Color start[] = { 
				this.init.panels[0].getBackground(), this.init.panels[1].getBackground(), this.init.panels[2].getBackground(), 
				this.init.panels[5].getBackground(), this.init.panels[8].getBackground(), this.init.panels[7].getBackground(),
				this.init.panels[6].getBackground(), this.init.panels[3].getBackground()};
		
		Color[] rColors = (Color[])ArrayUtils.rotateArrayRight(start, 1);
		
		this.init.panels[0].setMyColor(rColors[0]);
		this.init.panels[1].setMyColor(rColors[1]);
		this.init.panels[2].setMyColor(rColors[2]);
		this.init.panels[5].setMyColor(rColors[3]);
		// panel[4] remains
		this.init.panels[8].setMyColor(rColors[4]);		
		this.init.panels[7].setMyColor(rColors[5]);
		this.init.panels[6].setMyColor(rColors[6]);
		this.init.panels[3].setMyColor(rColors[7]);
	}
}