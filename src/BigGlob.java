import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class BigGlob extends GameObject {
	

	BigGlob(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {

	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		
			graphic.fillOval(x, y, width, height);
		}
		
		

	}

