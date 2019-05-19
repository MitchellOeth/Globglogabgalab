import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	BigGlob glob;
	public static int tailA;
	static ArrayList<Tail> tail = new ArrayList<Tail>();

	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}

	void update() {
		GamePanel.you.update();
		glob.update();
		for (tailA = 0; tailA < tail.size(); tailA++) {
			tail.get(tailA).update();
		}

	}

	void draw(Graphics graphic) {
		GamePanel.you.draw(graphic);
		glob.draw();
		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).draw(graphic);
		}

	}

	public void manageEnemies() {

	}

	void purgeObjects() {

	}

	void checkCollision() {

	}
}