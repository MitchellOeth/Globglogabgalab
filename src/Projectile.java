import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Projectile extends GameObject {
	int xSpeed;
	int ySpeed;
	int type;
	static Random Randy = new Random();
	Rectangle CollisionBox;

	public Projectile(double x, double y, int width, int height, int type) {
		super(x, y, width, height);
		ySpeed = Randy.nextInt(3) + 7;
		xSpeed = (Randy.nextInt(10) - 5);
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
		graphic.setColor(Color.WHITE);
		graphic.fillRect((int) x, (int) y, width, height);
		graphic.setColor(Color.BLACK);
		graphic.fillRect((int) x + 5, (int) y + 5, 5, 5);
		graphic.fillRect((int) x + 15, (int) y + 5, 5, 5);
		graphic.fillRect((int) x + 5, (int) y + 15, 15, 5);
	}

}
