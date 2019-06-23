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
	glob.update();
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

	
		manageEnemies();
		if (projectile.size() > 0) {
			for (int i = 0; i < projectile.size(); i++) {
				projectile.get(i).update();
				if (projectile.get(i).y > 600) {
					if (projectile.get(i).type == 0) {
						GamePanel.winCounter++;
					}
					projectile.remove(projectile.get(i));
				}
			}
		}
		go();
		purgeObjects();
		if (GamePanel.lives == 0) {
			GamePanel.currentState++;
			GamePanel.lives = 3;
		}
		if (GamePanel.winCounter == 0) {
			GamePanel.currentState++;
			GamePanel.winCounter = 100;
		}
	}

	double[] difference(double targetX, double lastX, double targetY, double lastY) {
		double[] diff = new double[2];
		diff[0] = targetX - lastX;
		diff[1] = targetY - lastY;
		return diff;
	}

	void draw(Graphics graphic) {
GamePanel.you.draw(graphic);
		glob.draw();
		for (int i = 0; i < tailDownArrayList.size(); i++) {
			tailDownArrayList.get(i).draw(graphic);
		}
		for (int i = 0; i < tailUpArrayList.size() - 1; i++) {
			tailUpArrayList.get(i).draw(graphic);
		}
		
		for (Projectile projectile : projectile) {
			projectile.draw(graphic);
		}
	}

	public void manageEnemies() {
		if (frameCounter % 10 == 0) {
			projectile.add(new Projectile(Projectile.Randy.nextInt(1000), -40, 25, 25, 0));
		}
		if (frameCounter % 95 == 0) {
			projectile.add(new Projectile(Projectile.Randy.nextInt(1000), -40, 25, 25, 1));
		}
		if (frameCounter % 600 == 0) {
			projectile.add(new Projectile(Projectile.Randy.nextInt(1000), -40, 25, 25, 2));
		}
		frameCounter++;
	}

	void purgeObjects() {
		if (projectile.size() > 0) {
			for (int o = 0; o < tailDownArrayList.size(); o++) {
				for (int i = 0; i < projectile.size(); i++) {
					if (tailDownArrayList.get(o).isInsideCircle((int) projectile.get(i).x,
							(int) projectile.get(i).y) == false) {
						if (projectile.get(i).type == 0) {
							GamePanel.winCounter--;
						} else if (projectile.get(i).type == 1) {
							if (GamePanel.isInvincible == 0) {
								GamePanel.lives--;
							}
						} else if (projectile.get(i).type == 2) {
							GamePanel.isInvincible = 1;

						}

						projectile.remove(projectile.get(i));

					}
				}
			}

			for (int o = 0; o < tailUpArrayList.size(); o++) {
				for (int i = 0; i < projectile.size(); i++) {
					if (tailUpArrayList.get(o).isInsideCircle((int) projectile.get(i).x,
							(int) projectile.get(i).y) == false) {
						if (projectile.get(i).type == 0) {
							GamePanel.winCounter--;
						} else if (projectile.get(i).type == 1) {
							if (GamePanel.isInvincible == 0) {
								GamePanel.lives--;
							}
						} else if (projectile.get(i).type == 2) {
							GamePanel.isInvincible = 1;

						}
						projectile.remove(projectile.get(i));

					}
				}
			}
		}
	}

	public void go() {
		if ((GamePanel.isInvincible < 240) && (GamePanel.isInvincible > 0)) {
			GamePanel.isInvincible++;
		} else {
			GamePanel.isInvincible = 0;
		}
	}

	void checkCollision() {

	}
}