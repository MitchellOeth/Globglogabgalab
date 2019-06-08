import java.awt.Color;
import java.awt.Graphics;

public class TailUp extends GameObject{

	public TailUp(double x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	//Try to replicate all instances with tail with tailup. do it backwards
	void update(double prevX,  double prevY, double nextX, double nextY) {
		y = (prevY + nextY)/2;
		x = (prevX + nextX)/2;
		}
	
	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.fillOval((int) x, (int) y, width, height);
	}
}
