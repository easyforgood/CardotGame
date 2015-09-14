package GPX;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Road {
	// 两个图片，定时互换
	File file1 = new File("D:/pic/HorseRoad1.jpg");
	File file2 = new File("D:/pic/HorseRoad2.jpg");
	private BufferedImage imgRoad;
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	private int y;

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Road() {
		x = 200;
		y = 80;
	}

	// 画自己
	public void Draw(Graphics g, int flag) {
		if (flag == 1) {
			try {
				imgRoad = ImageIO.read(file1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(imgRoad, this.x, this.y, null);
		}
		if (flag == 2) {
			try {
				imgRoad = ImageIO.read(file2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(imgRoad, this.x, this.y, null);
		}
	}
}
