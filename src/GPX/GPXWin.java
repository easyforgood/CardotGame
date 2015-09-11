package GPX;

//敌人图片均为120*55
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GPXWin extends JPanel implements ActionListener, KeyListener,
		Runnable {
	// 玩家分数
	private int score;
	private int roadLen;
	// 这个变量是用来轮流显示两张马路图片的
	private int Road_Flag = 1;
	Road road = new Road();
	JButton startGame = new JButton("开始");
	JButton stopGame = new JButton("结束");
	Player player;
	int speed=100;
	EndLine endline=null;
	// 游戏线程
	Thread nThread;
	Block block = new Block();
	BufferedImage gameover;
	File gameover_file = new File("D:/pic/gameover.jpg");
	boolean isBlock = false;

	public GPXWin() {
		this.roadLen = 200;
		this.score = 0;
		try {
			gameover = ImageIO.read(gameover_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = new Player();
		this.add(startGame);
		this.add(stopGame);
		startGame.addActionListener(this);
		stopGame.addActionListener(this);
		this.addKeyListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("您的分数是:" + score, 30, 30);
		roadLen -= 1;
		if (roadLen == 0){
			endline=new EndLine();
			roadLen--;
		}
		if(!Check_Hit()){
			repaint();
			g.drawImage(gameover, 200, 80, null);
			return;
		}
		
		g.drawRect(30, 80, 900, 600);
		road.Draw(g, Road_Flag);
		player.Draw(g);
		if (!check_Block()) {
			isBlock = true;
			this.block = null;
			this.block = new Block();
			speed=300;
		} else {
			speed=100;
			isBlock = false;
			
		}
		block.Draw(g);
		if(endline !=null){
			endline.Draw(g);
			
		}
		
		Check_Limit();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		/*
		 * case KeyEvent.VK_UP: this.player.Move(0, -5); break; case
		 * KeyEvent.VK_DOWN: this.player.Move(0, 5); break;
		 */
		case KeyEvent.VK_LEFT:
			this.player.Move(-5, 0);
			break;
		case KeyEvent.VK_RIGHT:
			this.player.Move(5, 0);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGame) {
			nThread = new Thread(this);
			nThread.start();
			this.requestFocus();
			repaint();
		}
		if (e.getSource() == stopGame) {
			System.exit(0);
		}
	}

	// 这个方法用来检测敌人是否出屏幕
	private void Check_Limit() {
		if (this.block.getY() + 100 >= 680) {
			this.block = null;
			this.block = new Block();
		}
	}

	// 判定相撞
	private boolean Check_Hit() {
		// 四种情况判定
		/*
		 * boolean
		 * left_up=enemy.getY()+120>player.getY()&&enemy.getX()+55>player
		 * .getX()&&enemy.getY()<player.getY()&&enemy.getX()<player.getX();
		 * boolean
		 * right_up=enemy.getX()>player.getX()&&enemy.getX()<player.getX(
		 * )+53&&enemy
		 * .getY()+120>player.getY()&&enemy.getY()+120<player.getY()+109;
		 * boolean
		 * left_down=enemy.getX()+55>player.getX()&&enemy.getX()+55<player
		 * .getX()
		 * +53&&player.getY()+109>enemy.getY()&&player.getY()+109<enemy.getY
		 * ()+120; boolean
		 * right_down=player.getX()+53>enemy.getX()&&player.getX(
		 * )+53<enemy.getX(
		 * )+55&&player.getY()+109>enemy.getY()&&player.getY()+109
		 * <enemy.getY()+120; if(left_up||right_up||left_down||right_down) {
		 * nThread.stop(); enemy=null; player=null; road=null; return false; }
		 */
		if(endline==null)
			return true;
		if (endline.getY() > 550){
			return false;
		}
		return true;
			
	}

	private boolean check_Block() {
		if (block.getY() > 500) {
			if (block.getX() + block.getRectWidth() < player.getX()
					|| block.getX() > player.getX() + 55) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void run() {
		while (true) {
			this.score += 10;
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isBlock == true) {
				repaint();
				
			} else {
				switch (Road_Flag){
				case 1:Road_Flag = 2;break;
				case 2:Road_Flag=1;break;
				default:Road_Flag=1;
				}

				repaint();
			}
			
		}
	}
}
