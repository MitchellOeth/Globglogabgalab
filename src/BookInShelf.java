import java.awt.Color;
import java.awt.Graphics;

public class BookInShelf extends GameObject{
	static int numBooksInShelf = 0;
	static int numRow = 0;
	int bookType;
	public BookInShelf(double x, double y, int width, int height, int bookType) {
		super(x, y, width, height);
		this.bookType = bookType;
	}
	void update() {
	}
	void draw(Graphics graphic) {
		if (bookType == 0) {
			graphic.drawImage(GamePanel.blueBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 1) {
			graphic.drawImage(GamePanel.redBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 2) {
			graphic.drawImage(GamePanel.greenBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 3) {
			graphic.drawImage(GamePanel.yellowBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 4) {
			graphic.drawImage(GamePanel.purpleBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 5) {
			graphic.drawImage(GamePanel.orangeBookshelfImg, (int) x, (int) y, width, height, null);
		} else if (bookType == 6) {
			graphic.drawImage(GamePanel.greyBookshelfImg, (int) x, (int) y, width, height, null);
		}
	}
}

