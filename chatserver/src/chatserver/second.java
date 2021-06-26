package chatserver;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class second extends JFrame {
	private JPanel contentPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	
	second(){
		setTitle("Cygnus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Join Room");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBounds(212, 396, 264, 67);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Create Room");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(212, 301, 264, 67);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		
		
	
		label.setIcon(new ImageIcon("cygnus2.jpg"));
		label.setBounds(168, 59, 326, 164);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(380, 0, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("black.jpg"));
		label_2.setBounds(0, 0, 689, 541);
		contentPane.add(label_2);
}	
}
