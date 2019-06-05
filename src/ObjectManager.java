import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	int f;
	BigGlob glob;
	public static int tailA = 0;
	static ArrayList<Tail> tail = new ArrayList<Tail>();
	static ArrayList<Projectile> projectile = new ArrayList<Projectile>();

	int frameCounter = 0;
	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}
	
	void update() {
		GamePanel.you.update();
		tail.get(0).update(GamePanel.mouseX, (int) BigGlob.globY, GamePanel.mouseX, (int) BigGlob.globY);
		for (tailA = 1;  tailA < tail.size()-1; tailA++) {
				tail.get(tailA).update(tail.get(tailA-1).x,tail.get(tailA-1).y,tail.get(tailA+1).x,tail.get(tailA+1).y);
		}
		
	glob.update();
	manageEnemies();
	purgeObjects();
	checkCollision();
	for(Projectile proj:projectile) {
		proj.update();
	}
	}

	void draw(Graphics graphic) {
		
			glob.draw();
		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).draw(graphic);
		}
		GamePanel.you.draw(graphic);
		for(Projectile projectile :projectile) {
			projectile.draw(graphic);
		}
	
	}

	public void manageEnemies() {
		if(f%15==0) {
			System.out.println("Yeet skeet, ur a beat, will you kiss my stinky feet?");
		projectile.add(new Projectile(Projectile.Randy.nextInt(1000),-10,10,10,0));
		}
		f++;
	}

	void purgeObjects() {

	}

	void checkCollision() {

	}
}