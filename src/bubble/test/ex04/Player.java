package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Moveable {

	private int x;
	private int y;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private final int SPEED = 3;
	private final int JUMSPEED = 2;
	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();

	}

	private void initBackgroundPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start();
	}

	private void initSetting() {
		x = 55;
		y = 535;
		left = false;
		right = false;
		up = false;
		down = false;

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
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);// 0.1 sec
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

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
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();

	}

	// left+up , right +up
	@Override
	public void up() {
		up = true;
      new Thread(()->{
    	  for(int i=0 ; i<130 /JUMSPEED;i++) {
    		  y=y-JUMSPEED;
    		  setLocation(x, y);
    		  try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	  }
    	  
    	  up=false;
    	  down();
    	  
    	  
    	  
      }).start();

	}

	@Override
	public void down() {

		down = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMSPEED; i++) {
				y = y + JUMSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			
			down = false;
			

		}).start();

	}

}
