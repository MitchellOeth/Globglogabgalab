import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	BigGlob you = new BigGlob(450, 350, 100, 100);
	ObjectManager objectManager = new ObjectManager(you);
	Font titleFont = new Font("Arial", Font.BOLD, 48);
	Font normalFont = new Font("Arial", Font.PLAIN, 25);
	Timer framerate;

	public GamePanel() {
		framerate = new Timer(1000 / 60, this);
		addKeyListener(this);
	}

	void startGame() {
		framerate.start();
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
			if (currentState == END_STATE) {
				you = new BigGlob(450, 350, 100, 100);
				objectManager = new ObjectManager(you);
			}
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}

		// Code here

	}

	public void keyReleased(KeyEvent event) {

		// Code here

	}

	public final static int MENU_STATE = 0;
	public final static int GAME_STATE = 1;
	public final static int END_STATE = 2;
	public static int currentState = MENU_STATE;
	public static int kill = 0;

	void updateMenuState() {
		// Nothing goes here
	}

	void updateGameState() {

		// Code here

		objectManager.update();
		objectManager.manageEnemies();
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
		// DONE
		graphic.setColor(Color.BLACK);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		you.draw(graphic);
		objectManager.draw(graphic);
		objectManager.checkCollision();
	}

	void drawEndState(Graphics graphic) {
		// DONE
		graphic.setColor(Color.RED);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		graphic.setColor(Color.BLACK);
		graphic.setFont(titleFont);
		graphic.drawString("GAME OVER", 375, 200);
		graphic.setFont(normalFont);
		graphic.drawString("You killed " + kill + " enemies", 400, 400);
		graphic.drawString("Press ENTER to restart", 385, 600);
		if (currentState == END_STATE) {
			you = new BigGlob(500, 500, 100, 100);
			objectManager = new ObjectManager(you);
			kill = 0;
		}
	}

	public void keyTyped(KeyEvent event) {
		// Nothing goes here

	}

}