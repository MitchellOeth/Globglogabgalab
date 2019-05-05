import java.awt.Graphics;

public class Tail extends GameObject {
	public Tail(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {

	}
//y=abs(sqrt((x-500)^2+160000));
	void draw(Graphics graphic) {
	for(int i=ObjectManager.tail.size()-1; i>=0; i--) {	
	//if mousex is less than 500, follow mousex+i. if more, 
	//graphic.fillOval(GamePanel.mouseX, ObjectManager.tail.get(i).y, ObjectManager.tail.get(i).width, ObjectManager.tail.get(i).height);
		}	
	}
}