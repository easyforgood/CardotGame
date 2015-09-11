package GPX;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class EndLine {
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
	private int rectWidth=900;
	private int rectHeight=20;

	public EndLine() {
		y = 80;
		x = 30;
	}

	public void Draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, rectWidth, rectHeight);
		y += 10;
	}
	public void DrawBlock(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, rectWidth, rectHeight);
	}
}
