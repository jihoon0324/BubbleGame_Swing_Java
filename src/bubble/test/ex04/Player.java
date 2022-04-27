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

	private final int SPEED = 5;
	private final int JUMSPEED = 2;
	private ImageIcon playerR, playerL;
	
	//벽 충돌 상태 변수
	private boolean leftWallCrach;
	private boolean rightWallCrash;

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();

	}

	private void initBackgroundPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start();
	}

	private void initSetting() {
		x = 70;
		y = 535;
		left = false;
		right = false;
		up = false;
		down = false;
		leftWallCrach= false;
		rightWallCrash=false;

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
		if (up == false && down == false) {
			up = true;
			new Thread(() -> {

				for (int i = 0; i < 130 /JUMSPEED; i++) {
					y = y - (JUMSPEED);
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (Exception e) {
						System.out.println("위쪽 이동중 인터럽트 발생 : " + e.getMessage());
					}
				}
				
				up = false;
				down();
			}).start();
		}
	}

	@Override
	public void down() {
		if (down == false) {
			down = true;
			new Thread(() -> {
				while (down) {
					System.out.println("하강 시작");
					y = y + (JUMSPEED);
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						System.out.println("아래쪽 이동중 인터럽트 발생 : " + e.getMessage());
					}
				}
				down = false;
			}).start();
		}
	}
}
