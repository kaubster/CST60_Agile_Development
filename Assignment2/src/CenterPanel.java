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
	}
}