import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Projectile extends GameObject {
	int xSpeed;
	int ySpeed;
	int type;
	int bookType;
	static Random Randy = new Random();
	Rectangle CollisionBox;

	public Projectile(double x, double y, int width, int height, int type, int bookType) {
		super(x, y, width, height);

		ySpeed = Randy.nextInt(3) + 7;
		xSpeed = (Randy.nextInt(10) - 5);

		this.bookType = bookType;
		this.type = type;
		CollisionBox = new Rectangle((int) x, (int) y, width, height);
	}

	void update() {
		x += xSpeed;
		y += ySpeed;
		if (x < 0 || x > 1090) {
			xSpeed *= -1;
		}

	}

	void draw(Graphics graphic) {
		// 0=Book
		// 1=Bomb
		// 2=Invincible
		if (type == 0) {
			if (bookType == 0) {
				graphic.drawImage(GamePanel.blueBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 1) {
				graphic.drawImage(GamePanel.redBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 2) {
				graphic.drawImage(GamePanel.greenBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 3) {
				graphic.drawImage(GamePanel.yellowBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 4) {
				graphic.drawImage(GamePanel.purpleBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 5) {
				graphic.drawImage(GamePanel.orangeBookImg, (int) x, (int) y, width, height, null);
			} else if (bookType == 6) {
				graphic.drawImage(GamePanel.greyBookImg, (int) x, (int) y, width, height, null);
			}
		} else if (type == 1) {
			graphic.drawImage(GamePanel.bombImg, (int) x, (int) y, width, height, null);
		} else if (type == 2) {
			graphic.drawImage(GamePanel.invincibleStarImg, (int) x, (int) y, width, height, null);
		}
	}

}
