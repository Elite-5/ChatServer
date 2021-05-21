package chatserver;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class first extends JFrame {
    private static first fr;
	private JPanel contentPane;
	
	public first() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("private");
		btnNewButton.addActionListener(new ActionListener() {
			second frame;
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
				frame=new second();
				frame.setVisible(true);
				frame.btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name=JOptionPane.showInputDialog("Enter Username");
						String str=JOptionPane.showInputDialog("Enter Joining ID");
						str="localhost";
						frame.dispose();
						new Client(str,name);
					}
				});
				
				frame.btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//String name=JOptionPane.showInputDialog("Enter Username");
						frame.dispose();
						
					}
				});
			}
		});
		btnNewButton.setBounds(161, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("foram");
		btnNewButton_1.addActionListener(new ActionListener() {
			front frame;
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
				frame = new front();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(161, 194, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
	public static void main(String[] args) {
		
		fr=new first();
		fr.setVisible(true);
	
}
}
