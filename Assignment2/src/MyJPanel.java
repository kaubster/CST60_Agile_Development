import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyJPanel extends JPanel {
	private Color myColor;

	public MyJPanel(Color myColor) {
		this.myColor = myColor;
		setBackground(myColor);
		addMouseListener(new MouseWatcher());
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
		setOriginalColor();
	}

	public void setSelectedColor() {
		setBackground(Color.magenta);
	}

	public void setOriginalColor() {
		setBackground(myColor);
	}

	class MouseWatcher extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent me) {
			setSelectedColor();
		}

		@Override
		public void mouseExited(MouseEvent me) {
			setOriginalColor();
		}

		@Override
		public void mouseClicked(MouseEvent me) {
			
			clicked();
		}
	}

	public void clicked() {
		
		// Whenever the mouse enters a panel, it turns magenta; 
		// when the mouse leaves, the color reverts back to its original color. 
		// Add the following user story: "When the user clicks on the center panel, the colors of the eight surrounding panels rotate to the next panel in a clockwise direction." Remember to TDD. The test cases you write matter more than the code. 
		
		
	}
}