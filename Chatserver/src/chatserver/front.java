package chatserver;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class front extends JFrame {

	private JPanel contentPane;
	public design1 f;
	public int z=0;
	public Timer t2;
	public JButton btnNewButton,btnNewButton_1;
	/**
	 * Launch the application.
	 */
	
	public front() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Join Server");
		
		btnNewButton.setBounds(143, 179, 117, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Create Server");
		
		btnNewButton_1.setBounds(143, 213, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Add image");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(156, 74, 191, 50);
		contentPane.add(lblNewLabel);
	}
	
}