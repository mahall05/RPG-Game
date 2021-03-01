import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static void init() {
		SpriteSheet ss = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_sheet.png"));
		
		player = ss.grabImage(0, 0, width, height);
		dirt = ss.grabImage(width, 1, width, height);
		grass = ss.grabImage(width*2, 1, width, height);
		stone = ss.grabImage(width*3, 1, width, height);
		tree = ss.grabImage(0, height, width, height);
		
	}

}
