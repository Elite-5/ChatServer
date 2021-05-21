package chatserver;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class design1 extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextArea text;
	public JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	public JButton btnNewButton_3;
	public String str,s1;
	public JButton btnNewButton_4;
	
	public design1(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 47, 60, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 50, 309, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		text = new JTextArea();
		text.setBounds(31, 117, 368, 133);
		contentPane.add(text);
		text.setEditable(false);
		btnNewButton = new JButton("Send");
		
		
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(313, 86, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Join Meet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str=JOptionPane.showInputDialog("Enter Joining ID");
				str="localhost";
				new Client(str,name);
			}
		});
		btnNewButton_1.setBounds(55, 88, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Create meet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//need cmd
				
				
				new Server("localhost",name);
			}
		});
		btnNewButton_2.setBounds(186, 88, 93, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("Welcome "+name);
		lblNewLabel_1.setBounds(36, 22, 363, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_4 = new JButton("Log Out");
		
		btnNewButton_4.setBounds(200, 11, 89, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_3 = new JButton("Setting");
		btnNewButton_3.setBounds(335, 0, 89, 23);
		 
	}
}
