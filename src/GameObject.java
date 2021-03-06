import java.awt.Point;

public class GameObject {
	double x;
	double y;
	int width;
	int height;
	boolean isAlive = true;

	public GameObject(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	boolean isInsideCircle(int x2, int y2) {
		Point origin = new Point(x2, y2);
		Point notOrigin = new Point((int) this.x + 50, (int) this.y + 50);
		double dist = origin.distance(notOrigin);
		if (dist < (width / 2)) {
			return false;
		} else {
			return true;
		}
	}

	void update() {

	}

	void draw() {
	}

}
