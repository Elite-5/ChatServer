package chatserver;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class second extends JFrame {
	private JPanel contentPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	second(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("join");
		btnNewButton.setBounds(161, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("create");
		btnNewButton_1.setBounds(161, 194, 89, 23);
		contentPane.add(btnNewButton_1);
}}
