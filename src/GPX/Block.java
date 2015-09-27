package GPX;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Block {
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
	public int getRectWidth(){
		return rectWidth;
	}

	Random rdm_x = new Random();// 敌人只需让x坐标为随机的
	private int rectWidth=70;
	private int rectHeight=30;

	public Block() {
		y = 80;
		x = rdm_x.nextInt(500) + 201;
	}

	public void Draw(Graphics g,int a) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, rectWidth, rectHeight);
		y += 10+a;
	}
	public void DrawBlock(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, rectWidth, rectHeight);
	}
}
