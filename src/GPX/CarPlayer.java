package GPX;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

public class CarPlayer extends KeyAdapter{
	
	protected int x;
	//���ٶ�
	protected int a;
	
	

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	protected int y;

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void Move(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
