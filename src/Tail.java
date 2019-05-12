import java.awt.Color;
import java.awt.Graphics;

public class Tail extends GameObject {
	public Tail(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	double tailGlobY;
	double x;
	double ø;

	public double getY(int i) {
		return (700.0 - Math.sqrt(-(Math.pow((GamePanel.mouseX - 500), 2)) + Math.pow(400 - i, 2)));
	}

	void update() {

		for (int i = 1; i <= ObjectManager.tail.size(); i++) {
			if (GamePanel.mouseX >= 100 && GamePanel.mouseX <= 900) {
				tailGlobY = getY(i);
				ø = Math.asin(tailGlobY / 400);
				x = (400.0 - i) * Math.cos(Math.asin(tailGlobY / 400));
			} else {
				tailGlobY = 700.0;
			}

		}
	}

	void draw(Graphics graphic) {
		for (int i = ObjectManager.tail.size() - 1; i >= 0; i--) {
			graphic.setColor(Color.BLUE);
			graphic.fillOval((int) x, (int) tailGlobY, width, height);
		}
	}
}