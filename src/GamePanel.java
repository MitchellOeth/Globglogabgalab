import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener {
	static BigGlob you = new BigGlob(450, 350, 100, 100);
	ObjectManager objectManager = new ObjectManager(you);
	public static int mouseX;
	public static int mouseY;
	Font titleFont = new Font("Arial", Font.BOLD, 48);
	Font normalFont = new Font("Arial", Font.PLAIN, 25);
	Font gameFont = new Font("Arial", Font.BOLD, 75);
	Font invincibleFont = new Font("Arial", Font.BOLD, 150);
	Timer framerate;
	public final static int MENU_STATE = 0;
	public final static int GAME_STATE = 1;
	public final static int END_STATE = 2;
	public static int currentState = MENU_STATE;
	public static int kill = 0;
	public static int lives = 3;
	public static int winCounter = 75;
	public static int isInvincible;
	public static int level = 1;
	public static BufferedImage globImg;
	public static BufferedImage glob0Img;
	public static BufferedImage glob1Img;
	public static BufferedImage glob2Img;
	public static BufferedImage foreheadImg;
	public static BufferedImage globInvincibilityImg;
	public static BufferedImage glob1InvincibilityImg;
	public static BufferedImage foreheadInvincibleImg;
	public static BufferedImage blueBookImg;
	public static BufferedImage redBookImg;
	public static BufferedImage greenBookImg;
	public static BufferedImage yellowBookImg;
	public static BufferedImage purpleBookImg;
	public static BufferedImage orangeBookImg;
	public static BufferedImage greyBookImg;
	public static BufferedImage bombImg;
	public static BufferedImage invincibleStarImg;
	public static BufferedImage blueBookshelfImg;
	public static BufferedImage greenBookshelfImg;
	public static BufferedImage greyBookshelfImg;
	public static BufferedImage orangeBookshelfImg;
	public static BufferedImage purpleBookshelfImg;
	public static BufferedImage redBookshelfImg;
	public static BufferedImage yellowBookshelfImg;
	public static BufferedImage bookshelfImg;
	public static BufferedImage bookshelf1Img;
	public static BufferedImage bookshelf2Img;

	public GamePanel() {
		framerate = new Timer(1000 / 60, this);
		addKeyListener(this);
		addMouseMotionListener(this);
		try {
			globImg = ImageIO.read(this.getClass().getResourceAsStream("glob.png"));
			glob0Img = ImageIO.read(this.getClass().getResourceAsStream("glob0.png"));
			glob1Img = ImageIO.read(this.getClass().getResourceAsStream("glob1.png"));
			foreheadImg = ImageIO.read(this.getClass().getResourceAsStream("forehead.png"));
			blueBookImg = ImageIO.read(this.getClass().getResourceAsStream("BlueBook.png"));
			redBookImg = ImageIO.read(this.getClass().getResourceAsStream("RedBook.png"));
			greenBookImg = ImageIO.read(this.getClass().getResourceAsStream("GreenBook.png"));
			yellowBookImg = ImageIO.read(this.getClass().getResourceAsStream("YellowBook.png"));
			purpleBookImg = ImageIO.read(this.getClass().getResourceAsStream("PurpleBook.png"));
			orangeBookImg = ImageIO.read(this.getClass().getResourceAsStream("OrangeBook.png"));
			greyBookImg = ImageIO.read(this.getClass().getResourceAsStream("GreyBook.png"));
			bombImg = ImageIO.read(this.getClass().getResourceAsStream("Bomb.png"));
			invincibleStarImg = ImageIO.read(this.getClass().getResourceAsStream("InvincibleStar.png"));
			globInvincibilityImg = ImageIO.read(this.getClass().getResourceAsStream("globInvincibility.png"));
			glob1InvincibilityImg = ImageIO.read(this.getClass().getResourceAsStream("glob1Invincibility.png"));
			foreheadInvincibleImg = ImageIO.read(this.getClass().getResourceAsStream("foreheadInvincible.png"));
			blueBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("blueBookshelf.png"));
			greenBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("greenBookshelf.png"));
			greyBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("greyBookshelf.png"));
			orangeBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("orangeBookshelf.png"));
			purpleBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("purpleBookshelf.png"));
			redBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("redBookshelf.png"));
			yellowBookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("yellowBookshelf.png"));
			bookshelfImg = ImageIO.read(this.getClass().getResourceAsStream("bookShelf.png"));
			bookshelf1Img= ImageIO.read(this.getClass().getResourceAsStream("bookShelf1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void startGame() {
		framerate.start();
		for (double i = 0; i < 500; i += 25) {
			ObjectManager.tailDownArrayList.add(new Tail(450, 350 + i, 100, 100));
		}
		for (double i = 0; i < 100; i += 25) {
			ObjectManager.tailUpArrayList.add(new TailUp(450, 350 - i, 100, 100));
		}
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

	void updateMenuState() {
	}

	void updateGameState() {
		objectManager.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		graphic.setFont(titleFont);
		graphic.setColor(Color.WHITE);
		graphic.drawString("GLOBGLOGABGALAB", 225, 200);
		graphic.setFont(normalFont);
		graphic.drawString("Press ENTER to start", 375, 400);
		graphic.drawString("Press SPACE for instructions", 325, 600);
		kill = 0;
	}

	void drawGameState(Graphics graphic) {
		
		graphic.setColor(Color.BLACK);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		objectManager.draw(graphic);
		graphic.setColor(Color.WHITE);
		graphic.setFont(gameFont);
		graphic.drawString("Lives: " + lives, 10, 60);
		graphic.drawLine(0, 650, 1100, 650);
		graphic.drawLine(1000, winCounter * 4, 1090, winCounter * 4);
		graphic.drawLine(1000, 1+winCounter * 4, 1090, 1+winCounter * 4);
		graphic.drawLine(1000, -1 + winCounter * 4, 1090, -1 + winCounter * 4);
		graphic.drawRect(1000, 100, 90, 400);
		graphic.drawRect(999, 99, 92, 402);
		graphic.drawRect(998, 98, 94, 404);
		graphic.setColor(Color.GREEN);
		graphic.fillRect(1001, 2 + winCounter*4, 90, 498-winCounter*4);
		graphic.setColor(Color.WHITE);
		graphic.setFont(invincibleFont);
		if (isInvincible >=60 && isInvincible<=90) {
		graphic.drawString("3", 475, 400);
		}
		if (isInvincible >=120 && isInvincible<=150) {
			graphic.drawString("2", 475, 400);
			}
		if (isInvincible >=180 && isInvincible<=210
				) {
				graphic.drawString("1", 475, 400);
			}
	}

	void drawEndState(Graphics graphic) {
		if (ObjectManager.win == true) {
			graphic.setColor(Color.GREEN);
			graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
			graphic.setColor(Color.BLACK);
			graphic.setFont(titleFont);
			graphic.drawString("YOU WIN!", 375, 200);
			graphic.setFont(normalFont);
			graphic.drawString("You read " + kill + " books", 400, 400);
			graphic.drawString("Press ENTER to restart", 385, 600);
		}
		else {
			graphic.setColor(Color.RED);
		graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
		graphic.setColor(Color.BLACK);
		graphic.setFont(titleFont);
		graphic.drawString("GAME OVER", 375, 200);
		graphic.setFont(normalFont);
		graphic.drawString("You read " + kill + " books", 400, 400);
		graphic.drawString("Press ENTER to restart", 385, 600);
		}
		
		if (currentState == END_STATE) {
			you = new BigGlob(450, 350, 100, 100);
			objectManager = new ObjectManager(you);
			for (int i = 0; i < 500; i += 25) {
				ObjectManager.tailDownArrayList.add(new Tail(450, 350 + i, 100, 100));
			}
			for (int i = 0; i < 100; i += 25) {
				ObjectManager.tailUpArrayList.add(new TailUp(450, 350 - i, 100, 100));

			}
			
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