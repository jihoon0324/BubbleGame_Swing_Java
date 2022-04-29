package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enemy extends JLabel implements Moveable {
	
	private BubbleFrame myContext;

	private int x;
	private int y;
	
	//적군의 방향 
    private EnemyDirection enemyDirection;
	//적군 위치 
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	
	private int state ; // 0(살아있는상태) 1 ( 갇혀있는 상태)
	// 적군 속도 
	private final int SPEED = 3;
	private final int JUMSPEED = 1;
	private ImageIcon enemyR, enemyL;
	


	public Enemy(BubbleFrame myContext) {
		this.myContext= myContext;
		initObject();
		initSetting();
		initBackgroundEnemyService();

	}

	private void initBackgroundEnemyService() {
		//new Thread(new BackgroundEnemyService(this)).start();
	}

	private void initSetting() {
		x = 480;
		y = 178;
		left = false;
		right = false;
		up = false;
		down = false;
		state= 0;
	
		enemyDirection = EnemyDirection.LEFT;
		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void initObject() {
		enemyR = new ImageIcon("image/enemyR.png");
		enemyL = new ImageIcon("image/enemyL.png");

	}
	

	

	
	

	@Override
	public void left() {
		enemyDirection = EnemyDirection.LEFT;
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(enemyL);
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
		enemyDirection = EnemyDirection.RIGHT;
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(enemyR);
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
