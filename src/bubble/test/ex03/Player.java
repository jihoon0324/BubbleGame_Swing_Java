package bubble.test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();

	}

	private void initSetting() {
		x = 55;
		y = 535;
		left =false;
		right= false;
		up =false;
		down= false;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void initObject() {
		playerR = new ImageIcon("image/PlayerR.png");
		playerL = new ImageIcon("image/PlayerL.png");

	}

	@Override
	public void left() {
		new Thread(()-> {
			setIcon(playerL);
			x= x-1;
			setLocation(x, y);
			
		}).start();	
	

	}

	@Override
	public void right() {
//	new Thread(new Runnable() {
		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
			
//		}
//	}).start();
		
	new Thread(()-> {
		
		
	}).start();	
		
		
		setIcon(playerR);
		x= x+1;
		setLocation(x, y);

	}

	@Override
	public void up() {
		y= y - 120;
		setLocation(x, y);

	}

	@Override
	public void down() {
	

	}

}
