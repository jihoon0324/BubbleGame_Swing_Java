package bubble.test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame
{
	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
	    initObject();
		initSetting();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap= new JLabel(new ImageIcon("image/backgroundMap.png"));
		
		// JFRAME 안에 있는 Jpanel 안에  JLabel 이 그려진다
	   //	backgroundMap= new JLabel("테스트");
	//	backgroundMap.setSize(100,100);
	//	backgroundMap.setLocation(300,300);
		// 	add(backgroundMap);
		
		//Jpanel 을 JLabel로 변경 
		setContentPane(backgroundMap);
		player = new Player();
		add(player);
		
	}
	private void initSetting() {
		setSize(1000,640);
		// absoulte 레이아웃(자유롭게 그림을 그릴수 있다)
		getContentPane().setLayout(null);
		// 창이 가운데 뜨게 만든다
		setLocationRelativeTo(null);
		// 창 종료시(x 버튼) 프로세싱(JVM) 종료	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
