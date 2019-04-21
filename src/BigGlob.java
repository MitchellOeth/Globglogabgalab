import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class BigGlob extends GameObject {
	ArrayList<Tail> tail = new ArrayList<Tail>();

	BigGlob(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {

	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		for (int i = y; i < 800; i++) {
			graphic.fillOval(x, i, width, height);
		}
		
		

	}
}
