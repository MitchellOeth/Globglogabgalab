import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Tail extends GameObject {
	public Tail(double x, double y, int width, int height) {
		super(x, y, width, height);

	}

	

	void update(double prevX,  double prevY, double nextX, double nextY) {
		/*if(ObjectManager.tailA<400) {
		tailGlobY = 800-(800-prevY-(800-prevY)/(400-ObjectManager.tailA));
		sampleX = 500 +prevX-500+ (prevX-500)/(400-ObjectManager.tailA);
		} else {
			tailGlobY = 800;
			sampleX = 500;
		}*/
		y = (prevY + nextY)/2;
		x = (prevX + nextX)/2;

		
		
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.fillOval((int) x, (int) y, width, height);
	}
}