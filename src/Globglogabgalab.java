import javax.swing.JFrame;

public class Globglogabgalab {
	public final static int width = 1000;
	public final static int height = 800;
	GamePanel gamePanel;
	JFrame frame;
	Globglogabgalab() {
	frame = new JFrame();
	gamePanel = new GamePanel();
	}
public static void main(String[] args) {
	Globglogabgalab starter = new Globglogabgalab();
	starter.setup();
}
void setup() {
	frame.addKeyListener(gamePanel);
	frame.add(gamePanel);
	frame.setVisible(true);
	frame.pack();
}
}
