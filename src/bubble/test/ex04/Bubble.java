package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {
	private int x;
	private int y;

	private Player player;
	private BackgroundBubbleService backgroundBubbleService;

	private boolean left;
	private boolean right;
	private boolean up;

// 적군을 맞춘 상태 
	private int state; // 0(물방울) 1 ( 적을 가둔 물방울)
	private ImageIcon bubble; // 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}
//버들은 하나만 필요하다
	private void initThread() {
	 new Thread(()->{
		 if(player.getPlayerDirection() == PlayerDirection.LEFT) {
			 left();
		 } else {
			 right();
		 }
		 
	 }).start();
		
	}

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
		setSize(50,50);
		state =0;

	}

	@Override
	public void left() {
		left=true;
	 for(int i=0; i<400 ;i++) {
		 x --;
		 setLocation(x,y);
		 if(backgroundBubbleService.leftWall()) {
			 left= false;
			 break;
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
		right =true;
		for(int i=0; i<400 ;i++) {
			 x ++;
			 setLocation(x,y);
			 if(backgroundBubbleService.rightWall()) {
				 right= false;
				 break;
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
		up=true;
		while(up) {
			 y --;
			 setLocation(x,y);
			 if(backgroundBubbleService.topWall()) {
				 up =false;
				 break;
			 }
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
		 }
		clearBubble();
		
		
	}
	private void clearBubble() {
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
