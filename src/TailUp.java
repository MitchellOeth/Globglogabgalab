import java.awt.Color;
import java.awt.Graphics;

public class TailUp extends GameObject {
	double lastX;
	double lastY;

	public TailUp(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	void update(double prevX, double prevY, double nextX, double nextY, double mod) {
		lastX = x;
		lastY = y;
		y = (prevY + nextY) * mod;
		x = (prevX + nextX) * mod;

	}

	void draw(Graphics graphic) {
		if (GamePanel.isInvincible >= 1) {
			graphic.drawImage(GamePanel.foreheadInvincibleImg, (int) x, (int) y, width, height, null);
		} else {
			graphic.drawImage(GamePanel.foreheadImg, (int) x, (int) y, width, height, null);
		}
	}
}
