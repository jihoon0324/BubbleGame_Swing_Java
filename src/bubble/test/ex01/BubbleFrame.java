package bubble.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.DefaultComboBoxModel;

public class BubbleFrame extends JFrame {
		public BubbleFrame() {
			setSize(1000,640);
			getContentPane().setLayout(null);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(64, 52, 138, 47);
			getContentPane().add(btnNewButton);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"ab", "b", "c", "d"}));
			comboBox.setBounds(0, 296, 239, 47);
			getContentPane().add(comboBox);
			//그림을 그려라
			setVisible(true);
		}
	
		
	public static void main(String[] args) {
		new BubbleFrame();

	}
}
