import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	BigGlob glob;
	static ArrayList<Tail> tail = new ArrayList<Tail>();
	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}

	void update() {
		GamePanel.you.update();
		glob.update();
	}

	void draw(Graphics graphic) {
		GamePanel.you.draw(graphic);
		tail.get(1).draw(graphic);
		glob.draw();
		
		
	}

	public void manageEnemies() {

	}

	void purgeObjects() {

	}

	void checkCollision() {

	}
}