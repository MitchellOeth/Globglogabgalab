import java.awt.Graphics;
import java.util.Random;

public class ObjectManager {
	BigGlob glob;

	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}

	void update() {
		glob.update();
	}

	void draw(Graphics graphic) {
		glob.draw(graphic);
	}

	public void manageEnemies() {

	}

	void purgeObjects() {

	}

	void checkCollision() {

	}
}