//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.

package Cygnus;
//This class forms next window for first.This contain creating and joining options.

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class second extends JFrame {
	private JPanel contentPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	second(){
		setTitle("Cygnus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Join Room");//button for joining room.
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(212, 381, 264, 82);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Create Room");//button for creating room.
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBounds(212, 292, 264, 76);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("cygnus2.jpg"));//background image logo one.
		label.setBounds(168, 59, 326, 164);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("black.jpg"));//cover up background.
		label_2.setBounds(0, 0, 689, 541);
		contentPane.add(label_2);
}	
}
