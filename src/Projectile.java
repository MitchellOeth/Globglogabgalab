import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Projectile extends GameObject {
int xSpeed;
int ySpeed;
int type;
static Random Randy = new Random();
	public Projectile(double x, double y, int width, int height, int type) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		ySpeed=Randy.nextInt(5)+5;
		xSpeed=(int) ((500-x)/(Randy.nextInt(30)+20));
		this.type=type;
	}
	
	void update(){
	x+=xSpeed;
	y+=ySpeed;
	if(x<0||x>1090) {
		xSpeed=xSpeed*-1;
	}
	}
	
	void draw(Graphics graphic) {
		graphic.setColor(Color.WHITE);
		graphic.fillRect((int) x, (int) y, width, height);
	}

}
