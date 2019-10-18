import static org.junit.Assert.assertArrayEquals;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Init {
	private MyJPanel lastClickedPanel;
	private JFrame jFrame;
	public MyJPanel panels[];
	public Color colors[] = { 
			Color.blue, Color.green, Color.red, 
			Color.white, Color.yellow, Color.black, 
			Color.orange, Color.cyan, Color.gray };

	public Init() {
		panels = new MyJPanel[9];
		jFrame = new JFrame("NINE SQUARES PROGRAM (Assignment 4)");
		jFrame.setSize(500, 500);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.getContentPane().setLayout(new GridLayout(3, 3));
		for (int i = 0; i < panels.length; i++) {
			if (i == 4) {
				panels[i] = new CenterPanel(colors[i], this);
			} else {
				panels[i] = new SwappableOuterPanel(colors[i], this);
			}
			jFrame.getContentPane().add(panels[i]);
		}
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new Init();
	}

	public MyJPanel getLastClickedPanel() {
		return lastClickedPanel;
	}

	public void setLastClickedPanel(MyJPanel panel) {
		lastClickedPanel = panel;
	}
}