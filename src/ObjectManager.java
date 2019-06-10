import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	int upX;
	int upY;
	BigGlob glob;
	int frameCounter = 0;
	public static int tailDown = 0;
	public static int tailUp = 0;

	static ArrayList<Tail> tailDownArrayList = new ArrayList<Tail>();
	static ArrayList<TailUp> tailUpArrayList = new ArrayList<TailUp>();
	static ArrayList<Projectile> projectile = new ArrayList<Projectile>();

	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}

	void update() {
		GamePanel.you.update();

		tailDownArrayList.get(0).update(GamePanel.mouseX - 50, GamePanel.mouseY - 50, GamePanel.mouseX - 50,
				GamePanel.mouseY - 50);
		tailUpArrayList.get(0).update(GamePanel.mouseX - 50, GamePanel.mouseY - 50, GamePanel.mouseX - 50,
				GamePanel.mouseY - 50, .5);

		for (tailDown = 1; tailDown < tailDownArrayList.size() - 1; tailDown++) {
			tailDownArrayList.get(tailDown).update(tailDownArrayList.get(tailDown - 1).x,
					tailDownArrayList.get(tailDown - 1).y, tailDownArrayList.get(tailDown + 1).x,
					tailDownArrayList.get(tailDown + 1).y);
		}
		for (tailUp = 1; tailUp < tailUpArrayList.size() - 1; tailUp++) {
			tailUpArrayList.get(tailUp).update(tailUpArrayList.get(tailUp - 1).x, tailUpArrayList.get(tailUp - 1).y,
					tailUpArrayList.get(tailUp + 1).x, tailUpArrayList.get(tailUp + 1).y, .5);
		}
		int mx = GamePanel.mouseX - 50;
		int my = GamePanel.mouseY - 50;
		double tx = tailDownArrayList.get(3).x;
		double ty = tailDownArrayList.get(3).y;
		double targetX = mx + (mx - tx);
		double targetY = my + (my - ty);
		double lastX = tailUpArrayList.get(tailUpArrayList.size() - 1).lastX;
		double lastY = tailUpArrayList.get(tailUpArrayList.size() - 1).lastY;
		double[] diff = difference(targetX, lastX, targetY, lastY);

		tailUpArrayList.get(tailUpArrayList.size() - 1).update(1, 1, 1, 1, 1);
		tailUpArrayList.get(tailUpArrayList.size() - 1).x = lastX + diff[0] / 5;
		tailUpArrayList.get(tailUpArrayList.size() - 1).y = lastY + diff[1] / 5;

		glob.update();
		manageEnemies();
		for (Projectile projectile : projectile) {
		 projectile.update();
		 }
		purgeObjects();
		checkCollision();

		 
	}

	double[] difference(double targetX, double lastX, double targetY, double lastY) {
		double[] diff = new double[2];
		diff[0] = targetX - lastX;
		diff[1] = targetY - lastY;
		return diff;

	}

	void draw(Graphics graphic) {

		glob.draw();
		for (int i = 0; i < tailDownArrayList.size(); i++) {
			tailDownArrayList.get(i).draw(graphic);
		}
		for (int i = 0; i < tailUpArrayList.size()-1; i++) {
			tailUpArrayList.get(i).draw(graphic);
		}
		GamePanel.you.draw(graphic);
		for (Projectile projectile : projectile) {
			projectile.draw(graphic);
		}

	}

	 public void manageEnemies() { if (frameCounter % 10 == 0) {

	  projectile.add(new Projectile(Projectile.Randy.nextInt(1000), -40, 25, 25,0));  

	 }
	frameCounter++; }
	 
	void purgeObjects() {
		/*for (int i = 0; i < ObjectManager.projectile.size() - 1; i++) {
			if (Projectile.isInsideCircle((int) ObjectManager.projectile.get(i).x,
					(int) ObjectManager.projectile.get(i).y) == true) {
				ObjectManager.projectile.remove(ObjectManager.projectile.get((int) i));
			}
		}*/
		for (int i = 0; i < projectile.size() - 1; i++) {
			for (int o = 0; o < tailDownArrayList.size() - 1; o++) {
				if(tailDownArrayList.get(o).isInsideCircle((int) projectile.get(i).x, (int) projectile.get(i).y)==false) {	
				projectile.remove(projectile.get(i));
				}
			}
		}
		for (int i = 0; i < projectile.size() - 1; i++) {
			for (int o = 0; o < tailUpArrayList.size() - 1; o++) {
				if(tailUpArrayList.get(o).isInsideCircle((int) projectile.get(i).x, (int) projectile.get(i).y)==false) {	
					projectile.remove(projectile.get(i));
					}			}
		}
		
}

	void checkCollision() {

	}
}