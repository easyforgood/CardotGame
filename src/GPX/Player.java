package GPX;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Player extends CarPlayer {
	protected BufferedImage img;

	public Player() {
		super();
		try {
			this.img = ImageIO.read(new File("D:/pic/Player.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		a=0;
		x = 400;
		y = 550;
	}

	// 画player的方法
	public void Draw(Graphics g) {
		g.drawImage(img, this.x, this.y, null);
	}

	// 只能左，右，上移动
	public void Move(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
