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
		graphic.setColor(null);
		if (GamePanel.isInvincible > 0) {
			graphic.setColor(Color.YELLOW);
		}
		graphic.drawImage(GamePanel.globImg, (int) x, (int) y, width, height, null);
	}
	
}