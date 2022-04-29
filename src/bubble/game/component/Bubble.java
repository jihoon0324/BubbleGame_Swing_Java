package bubble.game.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.game.BubbleFrame;
import bubble.game.Moveable;
import bubble.game.service.BackgroundBubbleService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {
	private int x;
	private int y;
//의존성 콤포지션
	private BubbleFrame myContext;
	private Player player;
	private Enemy enemy;
	private BackgroundBubbleService backgroundBubbleService;

	private boolean left;
	private boolean right;
	private boolean up;

// 적군을 맞춘 상태 
	private int state; // 0(물방울) 1 ( 적을 가둔 물방울)
	private ImageIcon bubble; // 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	public Bubble(BubbleFrame myContext) {
		this.myContext = myContext;
		this.enemy = myContext.getEnemy();
		this.player = myContext.getPlayer();
		initObject();
		initSetting();
		// initThread();
	}

	/**
	 * //버블은 하나만 필요하다 private void initThread() { new Thread(()->{
	 * if(player.getPlayerDirection() == PlayerDirection.LEFT) { left(); } else {
	 * right(); }
	 * 
	 * }).start();
	 * 
	 * }
	 **/
	private void initObject() {
		bubble = new ImageIcon("Image/bubble.png");
		bubbled = new ImageIcon("Image/bubbled.png");
		bomb = new ImageIcon("Image/bomb.png");

		backgroundBubbleService = new BackgroundBubbleService(this);

	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;
		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		state = 0;

	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			if (backgroundBubbleService.leftWall()) {
				left = false;
				break;
			}
			if((Math.abs(x -enemy.getX()) <10) &&
					(Math.abs(y -enemy.getY()) >0 &&  Math.abs(y -enemy.getY()) <50 )) {
			System.out.print("충돌 적군");
			if(enemy.getState() ==0) {
				attack();
				break;
			}
			
			
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleService.rightWall()) {
				right = false;
				break;
			}
			if((Math.abs(x -enemy.getX()) <10 ) &&
					(Math.abs(y -enemy.getY()) >0 &&  Math.abs(y -enemy.getY()) <50 )) {
			System.out.print("충돌 적군");
			if(enemy.getState() ==0) {
				attack();
				break;
			}
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
				up = false;
				break;
			}
			
		
			
			try {
				if(state == 0) {
				Thread.sleep(1);	
				}else {
					Thread.sleep(10);		
				}
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		if(state ==0) clearBubble();

	}
	
	@Override
	public void attack() {
	state =1 ;
	enemy.setState(1);
	setIcon(bubbled);
	myContext.remove(enemy);
	myContext.repaint();
	}

	private void clearBubble() {
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			Thread.sleep(5000);
			myContext.remove(this);
			myContext.repaint(); // 메모리에서 없는건 그리지 않는다

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void clearBubbled() {
		new Thread(()->{
			try {
				up =false;
				setIcon(bomb);
				Thread.sleep(1000);
				myContext.remove(this);
				myContext.repaint();
				
			} catch (Exception e) {
		
			}
		}).start();
		
	}

}
