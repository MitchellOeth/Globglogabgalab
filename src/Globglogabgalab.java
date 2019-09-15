import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Globglogabgalab {
	public final static int width = 1100;
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
		frame.addMouseListener(gamePanel);
		frame.add(gamePanel);
		frame.setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		gamePanel.startGame();
	}
}