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
	}

	private void initObject() {
		bubble = new ImageIcon("Image/bubble.png");
		bubbled = new ImageIcon("Image/bubbled.png");
		bomb = new ImageIcon("Image/bomb.png");

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
	
		
	}

	@Override
	public void right() {

		
	}

	@Override
	public void up() {
		
		
	}

}
