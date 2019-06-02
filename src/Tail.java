import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Tail extends GameObject {
	public Tail(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	double sampleX;
	double tailGlobY;

	void update() {
		
		tailGlobY = (BigGlob.globY + ObjectManager.tailA);
		sampleX = (GamePanel.mouseX - 500) * (800 - tailGlobY) / (800 - BigGlob.globY);
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.fillOval((int) sampleX + 500, (int) tailGlobY, width, height);
	}
}