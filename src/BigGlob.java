import java.awt.Graphics;
import java.awt.Color;

public class BigGlob extends GameObject {

	BigGlob(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	static double globY;

	void update() {
		if (GamePanel.mouseX >= 100 && GamePanel.mouseX <= 900) {
			globY = 700.0 - Math.sqrt(-(Math.pow((GamePanel.mouseX - 500), 2)) + Math.pow(400, 2));
		} else {
			globY = 700.0;
		}
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.drawImage(GamePanel.glob1Img,GamePanel.mouseX - 50, GamePanel.mouseY - 50, width, height, null, null);
	}
}