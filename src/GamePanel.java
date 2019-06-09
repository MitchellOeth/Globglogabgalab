import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener {
	static BigGlob you = new BigGlob(450, 350, 100, 100);
	ObjectManager objectManager = new ObjectManager(you);
	public static int mouseX;
	public static int mouseY;
	Font titleFont = new Font("Arial", Font.BOLD, 48);
	Font normalFont = new Font("Arial", Font.PLAIN, 25);
	Timer framerate;

	public GamePanel() {
		framerate = new Timer(1000 / 60, this);
		addKeyListener(this);
		addMouseMotionListener(this);
	}

	void startGame() {
		framerate.start();
		for (double i = 0; i < 500; i += 25) {
			ObjectManager.tailDownArrayList.add(new Tail(450, 350 + i, 100, 100));
		}
		for (double i = 0; i < 100; i += 25) {
			ObjectManager.tailUpArrayList.add(new TailUp(450, 350 - i, 100, 100));
		}
		// For loop add tail up's
	}

	public void paintComponent(Graphics graphic) {
		if (currentState == MENU_STATE) {
			drawMenuState(graphic);
		} else if (currentState == GAME_STATE) {
			drawGameState(graphic);
		} else if (currentState == END_STATE) {
			drawEndState(graphic);
		}
	}

	public void actionPerformed(ActionEvent event) {
		// Done
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;

		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
	}

	public void keyReleased(KeyEvent event) {

	}

	public final static int MENU_STATE = 0;
	public final static int GAME_STATE = 1;
	public final static int END_STATE = 2;
	public static int currentState = MENU_STATE;
	public static int kill = 0;

	void updateMenuState() {
	}

	void updateGameState() {
		objectManager.update();
	}

	void updateEndState() {
		// Nothing goes here
	}

	void drawMenuState(Graphics graphic) {
		// DONE
		graphic.setColor(Color.BLUE);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		graphic.setFont(titleFont);
		graphic.setColor(Color.WHITE);
		graphic.drawString("GLOBGLOGABGALAB", 225, 200);
		graphic.setFont(normalFont);
		graphic.drawString("Press ENTER to start", 375, 400);
		graphic.drawString("Press SPACE for instructions", 325, 600);
	}

	void drawGameState(Graphics graphic) {
		graphic.setColor(Color.BLACK);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		objectManager.draw(graphic);
	}

	void drawEndState(Graphics graphic) {
		graphic.setColor(Color.RED);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		graphic.setColor(Color.BLACK);
		graphic.setFont(titleFont);
		graphic.drawString("GAME OVER", 375, 200);
		graphic.setFont(normalFont);
		graphic.drawString("You killed " + kill + " enemies", 400, 400);
		graphic.drawString("Press ENTER to restart", 385, 600);
		if (currentState == END_STATE) {
			you = new BigGlob(450, 350, 100, 100);
			objectManager = new ObjectManager(you);
			for (int i = 0; i < 500; i += 25) {
				ObjectManager.tailDownArrayList.add(new Tail(450, 350 + i, 100, 100));
			}
			for (int i = 0; i < 100; i += 25) {
				ObjectManager.tailUpArrayList.add(new TailUp(450, 350 - i, 100, 100));

			}
			// for loop add ups
			kill = 0;
		}
	}

	public void keyTyped(KeyEvent event) {

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

}