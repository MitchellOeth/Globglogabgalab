import java.awt.Color;
import java.awt.Graphics;

public class Button extends GameObject{

	public Button(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	void update(){
	
	}
	void draw(Graphics graphic) {
		graphic.fillRect((int) x, (int) y, width, height);
	}
}
