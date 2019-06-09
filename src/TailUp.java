import java.awt.Color;
import java.awt.Graphics;

public class TailUp extends GameObject{
double lastX;
double lastY;
	public TailUp(double x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update(double prevX,  double prevY, double nextX, double nextY, double mod) {
		lastX = x;
		lastY = y;
		System.out.println(lastX);
		System.out.println(lastY);
		y = (prevY + nextY)*mod;
		x = (prevX + nextX)*mod;
		
		}
	
	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.fillOval((int) x, (int) y, width, height);
	}
}
