package GPX;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Player extends KeyAdapter {
   private BufferedImage img;
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
   public Player()
   {
	   try {
		img=ImageIO.read(new File("D:/pic/Player.jpg"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	   x=400;y=550;
   }
   //画player的方法
   public void Draw(Graphics g)
   {
	   g.drawImage(img, this.x,this.y,null);
   }
   //只能左，右，上移动
   public void Move(int x,int y)
   {
	   this.x+=x;
	   this.y+=y;
   }
}
