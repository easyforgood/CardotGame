package GPX;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy extends CarPlayer{
  
Random rdm_x=new Random();//敌人只需让x坐标为随机的
   Random rdm_car=new Random();//车的类型也是随机的
   //有四个敌人，随机产生
   File file1=new File("D:/pic/enemy1.jpg");
   File file2=new File("D:/pic/enemy2.jpg");
   File file3=new File("D:/pic/enemy3.jpg");
   File file4=new File("D:/pic/enemy4.jpg");
   private BufferedImage imgEnemy;
   public Enemy()
   {
	   y=550;
	   x=rdm_x.nextInt(500)+201;
	   //随机产生一种车
	   switch (rdm_car.nextInt(4)) 
	   {
	       case 0:
		try {
			imgEnemy=ImageIO.read(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		      break;
	       case 1:
		try {
			imgEnemy=ImageIO.read(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    	break;
	       case 2:
	    	   try {
	   			imgEnemy=ImageIO.read(file3);
	   		} catch (IOException e) {
	   			e.printStackTrace();
	   		}
	    	break;
	       case 3:
	    	   try {
	   			imgEnemy=ImageIO.read(file4);
	   		} catch (IOException e) {
	   			e.printStackTrace();
	   		}
	    	   break;
	       default:
		      break;
	   }
   }
   public void Draw(Graphics g)
   {
	   g.drawImage(imgEnemy,x,this.y,null);
   }
}
