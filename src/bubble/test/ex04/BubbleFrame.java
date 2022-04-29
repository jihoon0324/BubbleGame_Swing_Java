package bubble.test.ex04;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BubbleFrame extends JFrame {
	private BubbleFrame myContext= this;
	private JLabel backgroundMap;
	private Player player;
	private Enemy enemy;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
				if(!player.isLeft() && !player.isLeftWallCrach()){
					 player.left();
				}
                   
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight() && !player.isRightWallCrash()) {
						  player.right();
					}
					 
					break;
				case KeyEvent.VK_UP:
					if(!player.isUp() && !player.isDown()) {
					   player.up();
					}
					break;
				case KeyEvent.VK_SPACE:
		//		Bubble bubble = new Bubble(myContext);
		//		add(bubble);
					player.attack();
					break;
			

				}

			}
			
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
				 player.setLeft(false);
                   
					break;
				case KeyEvent.VK_RIGHT:
				player.setRight(false);
					 
					break;
				
			

				}
				
				
			}
			
			
		});

	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		setContentPane(backgroundMap);
		player = new Player(myContext);
		add(player);
		enemy = new Enemy(myContext);
        add(enemy);
        new BGM();
	}

	private void initSetting() {
		setSize(1000, 640);

		getContentPane().setLayout(null);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
