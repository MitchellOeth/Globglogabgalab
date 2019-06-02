import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	BigGlob glob;
	public static int tailA = 0;
	static ArrayList<Tail> tail = new ArrayList<Tail>();
	int frameCounter = 0;
	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}

	void update() {
		GamePanel.you.update();
		glob.update();
		/*	if (tailA < tail.size()) {
				tail.get(tailA).update();
				tailA+= 100;
			}
				else {
					tailA=0;
				}
		*/
		tail.get(0).update();
		for (tailA = 1;  tailA < tail.size(); tailA++) {
			if(frameCounter%tailA==0) {
				tail.get(tailA).update();
			}
		}
		//if(frameCounter<tail.size()) {
			frameCounter++;
		//}
		//else {
		//	frameCounter=0;
	//	}
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