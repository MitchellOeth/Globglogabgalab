import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
	static BigGlob you = new BigGlob(450, 350, 100, 100);
	ObjectManager objectManager = new ObjectManager(you);
	public static int mouseX;
	public static int mouseY;
	Font titleFont = new Font("Arial", Font.BOLD, 75);
	Font normalFont = new Font("Arial", Font.PLAIN, 25);
	Font gameFont = new Font("Arial", Font.BOLD, 75);
	Font invincibleFont = new Font("Arial", Font.BOLD, 150);
	Timer framerate;
	boolean epilepsy = false;
	int epilepsyCounter = 0;
	Button level1 = new Button(125, 575, 200, 50);
	Button level2 = new Button(450, 575, 200, 50);
	Button level3 = new Button(775, 575, 200, 50);
	public static int difficulty;

	public final static int MENU_STATE = 0;
	public final static int GAME_STATE = 1;
	public final static int END_STATE = 2;
	public static int currentState = MENU_STATE;
	public static int kill = 0;
	public static int lives = 3;
	public static int winCounter = 75;
	public static int isInvincible;
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
	public static BufferedImage bookmarkImg;
	public static BufferedImage glassesImg;
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
		addMouseListener(this);
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
			bookmarkImg = ImageIO.read(this.getClass().getResourceAsStream("Bookmark.png"));
			glassesImg = ImageIO.read(this.getClass().getResourceAsStream("glasses.png"));
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
			bookshelf2Img= ImageIO.read(this.getClass().getResourceAsStream("bookShelf2.png"));
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
		if (event.getKeyCode() == KeyEvent.VK_Z) {
			epilepsy = true;
		}
		if (event.getKeyCode() == KeyEvent.VK_X) {
			epilepsy = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null, "Controls: Move the mouse to control glob."
					+ "Goal: Try to hit as many books as possible and avoid the bookmarks ");
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
		graphic.drawString("GLOBGLOGABGALAB", 147, 200);
		graphic.setFont(normalFont);
		graphic.drawString("Select a DIFFICULTY to Start", 435, 300);
		graphic.drawString("Press SPACE for Instructions", 385, 400);
		graphic.setColor(Color.GREEN);
		level1.draw(graphic);
		graphic.setColor(Color.YELLOW);
		level2.draw(graphic);
		graphic.setColor(Color.RED);
		level3.draw(graphic);
		graphic.setColor(Color.BLACK);
		graphic.drawString("Easy", 195, 610);
		graphic.drawString("Medium", 510, 610);
		graphic.drawString("Hard", 800, 610);
		kill = 0;
		lives = 3;
		isInvincible = 0;
		BookInShelf.numRow = 0;
		BookInShelf.numBooksInShelf = 0;
	}

	
	void drawGameState(Graphics graphic) {
		if (epilepsy == true) {
			if(epilepsyCounter==1) {
				graphic.setColor(Color.RED);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
			if(epilepsyCounter==2) {
				graphic.setColor(Color.BLUE);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
			if(epilepsyCounter==3) {
				graphic.setColor(Color.ORANGE);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
			if(epilepsyCounter==4) {
				graphic.setColor(Color.BLACK);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
			if(epilepsyCounter==5) {
				graphic.setColor(Color.GREEN);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
			if(epilepsyCounter==6) {
				graphic.setColor(Color.YELLOW);
				graphic.fillRect(0,0,Globglogabgalab.width, Globglogabgalab.height);
		}
		}
		
			else {
			graphic.setColor(Color.BLACK);
			graphic.fillRect(0, 0, Globglogabgalab.width, Globglogabgalab.height);
			graphic.drawImage(bookshelf2Img, 0, 0, 1100, 800, null);
		}
		
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
		epilepsyCounter +=1;
		if (epilepsyCounter >=7
				) {
			epilepsyCounter = 1;
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
			winCounter=75;
			for (int i = 0; i < ObjectManager.projectile.size()-1; i++) {
				ObjectManager.projectile.remove(ObjectManager.projectile.get(i));
			}
			for (int i = 0; i < ObjectManager.bookInShelf.size(); i++) {
				ObjectManager.bookInShelf.remove(ObjectManager.bookInShelf.get(i));
			}
		}
	}

	public void keyTyped(KeyEvent event) {

	}

	public void mouseClicked(MouseEvent event) {
		
		
		
	}

	public void mouseMoved(MouseEvent event) {
		mouseX = event.getX();
		mouseY = event.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(mouseX>=125&&mouseX<=325&&mouseY>=575&&mouseY<=625&&currentState==MENU_STATE) {
			difficulty = 1;
			currentState++;
		}
		if(mouseX>=450&&mouseX<=650&&mouseY>=575&&mouseY<=625&&currentState==MENU_STATE) {
			difficulty = 2;
			currentState++;
		}
		if(mouseX>=775&&mouseX<=975&&mouseY>=575&&mouseY<=625&&currentState==MENU_STATE) {
			difficulty = 3;
			currentState++;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}