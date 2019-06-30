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
		graphic.setColor(Color.WHITE);
		if (GamePanel.isInvincible > 0) {
			graphic.setColor(Color.YELLOW);
		}
		graphic.drawImage(GamePanel.foreheadImg, (int) x, (int) y, width, height, null);	}
}
