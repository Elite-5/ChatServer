package chatserver;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class front extends JFrame {

	private JPanel contentPane;
	public design1 f;
	public int z=0;
	public Timer t2;
	public JButton btnNewButton,btnNewButton_1;
	private JLabel label;
	private JLabel label_1;
	/**
	 * Launch the application.
	 */
	
	public front() {
		setTitle("Cygnus\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Join Server");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		
		btnNewButton.setBounds(212, 396, 264, 67);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Create Server");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		
		btnNewButton_1.setBounds(212, 301, 264, 67);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("cygnus2.jpg"));
		label.setBounds(168, 59, 326, 164);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("black.jpg"));
		label_1.setBounds(0, 0, 690, 541);
		contentPane.add(label_1);
	}
}