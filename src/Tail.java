import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Tail extends GameObject {
	public Tail(double x, double y, int width, int height) {
		super(x, y, width, height);

	}

	void update(double prevX, double prevY, double nextX, double nextY) {
		y = (prevY + nextY) / 2;
		x = (prevX + nextX) / 2;

	}

	void draw(Graphics graphic) {
		if (GamePanel.isInvincible >= 1) {
			graphic.drawImage(GamePanel.globInvincibilityImg, (int) x, (int) y, width, height, null);
		} else {
			graphic.drawImage(GamePanel.globImg, (int) x, (int) y, width, height, null);
		}
	}

}