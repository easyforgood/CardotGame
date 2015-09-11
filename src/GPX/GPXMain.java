package GPX;

import javax.swing.JFrame;

public class GPXMain extends JFrame {
    public GPXMain()
    {
    	GPXWin win=new GPXWin();
    	this.add(win);
    	this.setSize(1000,800);
    	this.setLocation(100,0);
    	this.setTitle("高智能方程式");
    	this.setVisible(true);
    }
	public static void main(String[] args) {
		new GPXMain();
	}

}
