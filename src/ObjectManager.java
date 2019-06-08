import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	int f;
	BigGlob glob;
	public static int tailDown = 0;
	public static int tailUp = 0;

	static ArrayList<Tail> tailDownArrayList = new ArrayList<Tail>();
	static ArrayList<TailUp> tailUpArrayList = new ArrayList<TailUp>();
	static ArrayList<Projectile> projectile = new ArrayList<Projectile>();

	int frameCounter = 0;
	ObjectManager(BigGlob glob) {
		this.glob = glob;
		glob = new BigGlob(450, 350, 100, 100);
	}
	
	void update() {
		GamePanel.you.update();
		//tail.get(0).update(GamePanel.mouseX, (int) BigGlob.globY, GamePanel.mouseX, (int) BigGlob.globY);
		tailDownArrayList.get(0).update(GamePanel.mouseX-50, GamePanel.mouseY-50, GamePanel.mouseX-50, GamePanel.mouseY-50);
		tailUpArrayList.get(0).update(GamePanel.mouseX-50, GamePanel.mouseY-50, GamePanel.mouseX-50, GamePanel.mouseY-50);
		

		for (tailDown = 1;  tailDown < tailDownArrayList.size()-1; tailDown++) {
			tailDownArrayList.get(tailDown).update(tailDownArrayList.get(tailDown-1).x,tailDownArrayList.get(tailDown-1).y,tailDownArrayList.get(tailDown+1).x,tailDownArrayList.get(tailDown+1).y);
		}
		for (tailUp = 1;  tailUp < tailUpArrayList.size()-1; tailUp++) {
			tailUpArrayList.get(tailUp).update(tailUpArrayList.get(tailUp-1).x,tailUpArrayList.get(tailUp-1).y,tailUpArrayList.get(tailUp+1).x,tailUpArrayList.get(tailUp+1).y);
	}
		
		//tailUpArrayList.get(tailUpArrayList.size()-1).x = (GamePanel.mouseX-500)*1.25+450;
		
	//	tailUpArrayList.get(tailUpArrayList.size()-1).y = tailDownArrayList.get(tailUpArrayList.size()-1).y-200;

		//update(tailDownArrayList.get(tailUpArrayList.size()-1).x, GamePanel.mouseY-350-tailDownArrayList.get(tailUpArrayList.size()-1).y,tailDownArrayList.get(tailUpArrayList.size()-1).x, GamePanel.mouseY-350-tailDownArrayList.get(tailUpArrayList.size()-1).y);
	glob.update();
	manageEnemies();
	purgeObjects();
	checkCollision();
	
	for(Projectile projectile:projectile) {
		projectile.update();
	}
	}

	void draw(Graphics graphic) {
		
			glob.draw();
		for (int i = 0; i < tailDownArrayList.size(); i++) {
			tailDownArrayList.get(i).draw(graphic);
		}
		for (int i = 0; i < tailUpArrayList.size(); i++) {
			tailUpArrayList.get(i).draw(graphic);
		}
		GamePanel.you.draw(graphic);
		//for(Projectile projectile :projectile) {
		//	projectile.draw(graphic);
		//}
	
	}

	public void manageEnemies() {
		projectile.add(new Projectile(Projectile.Randy.nextInt(1000),-40,25,25,0));
	}
	void purgeObjects() {

	}

	void checkCollision() {

	}
}