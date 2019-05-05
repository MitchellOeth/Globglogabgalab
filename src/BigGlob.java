import java.awt.Graphics;
import java.awt.Color;

public class BigGlob extends GameObject{

	BigGlob(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
y = 800-(int)Math.abs(Math.sqrt(-((GamePanel.mouseX-500)^2)+160000));
System.out.println(y);
System.out.println("Glob update");
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		graphic.fillOval(GamePanel.mouseX, y, width, height);
		}
	}