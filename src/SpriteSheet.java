import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		return sheet.getSubimage((col*32)-32, (row*32)-32, width, height);
	}

}
