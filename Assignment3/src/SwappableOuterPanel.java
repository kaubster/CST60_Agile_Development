import java.awt.Color;
import java.awt.event.MouseEvent;

public class SwappableOuterPanel extends MyJPanel {
	Init init;
	
	Color lastClicked;

	public SwappableOuterPanel(Color myColor, Init init) {
		super(myColor);
		this.init = init;
	}

	@Override
	public void clicked(MouseEvent me) {
		SwappableOuterPanel panel = (SwappableOuterPanel)me.getSource();
		swapColorWithLastPanel(panel);
	}
	
	private void swapColorWithLastPanel(MyJPanel target) {
		
		if(target == null)
			throw new NullPointerException("swapWithLastClickedOuterPanel argument 'target' was null.");

		/* Assignment 2: When the user consecutively clicks on two 
		 * of the outer panels, the colors of these panels are 
		 * swapped. */
		
		MyJPanel lPanel = init.getLastClickedPanel();
		
		if(lPanel != null) {
			swapColorWithPanel(lPanel, target);
		}		
		
		init.setLastClickedPanel(target);
	}
	
	private void swapColorWithPanel(MyJPanel from, MyJPanel target) {
		
		if(from == null)
			throw new NullPointerException("swapColorWithPanel argument 'from' was null.");

		if(target == null)
			throw new NullPointerException("swapColorWithPanel argument 'target' was null.");
				
		/* Assignment 2: When the user consecutively clicks on two 
		 * of the outer panels, the colors of these panels are 
		 * swapped. */
				
		Color tColor = target.getMyColor();
		Color lastColor = from.getMyColor();
		target.setMyColor(lastColor);
		from.setMyColor(tColor);
	}
}
