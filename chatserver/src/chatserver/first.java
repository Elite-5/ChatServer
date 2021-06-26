package chatserver;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class first extends JFrame {
    private static first fr;
	private JPanel contentPane;
	
	public first() {
		setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 580);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.setSize(new Dimension(50, 50));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Private Room");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBounds(52, 406, 227, 51);
		contentPane.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		JButton btnNewButton_1 = new JButton("Forum");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(414, 405, 227, 51);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(0, 206, 209));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("cygnus1.jpg"));
		label_1.setBounds(70, 33, 620, 359);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("black.jpg"));
		label.setBounds(0, 0, 690, 542);
		contentPane.add(label);
		btnNewButton_1.addActionListener(new ActionListener() {
			front frame;
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
				frame = new front();
				frame.setVisible(true);
				frame.btnNewButton.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent e) {
						String name=JOptionPane.showInputDialog("Enter Username");
						String str=JOptionPane.showInputDialog("Enter Joining ID");
						frame.dispose();
						new Client1(str,name);
									}
								});
				frame.btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name=JOptionPane.showInputDialog("Enter Username");
						frame.dispose();
						String str=null;
						try {
						ProcessBuilder b=new ProcessBuilder("cmd.exe","/c","ipconfig");
						b.redirectErrorStream(true);
						Process p=b.start();
						BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						while(true){
						str=br.readLine();
						
						if (str.contains("IPv4 Address")) 
						{
						str=str.substring(39,str.length());
						break;
						}}}
						catch(Exception ee){}
						
						new Server1(str,name);
					}
				});
				
			}
		});
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
						frame.dispose();
						new Client(str,name);
					}
				});
				
				frame.btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						String name=JOptionPane.showInputDialog("Enter Username");
						String str=null;
						try {
						ProcessBuilder b=new ProcessBuilder("cmd.exe","/c","ipconfig");
						b.redirectErrorStream(true);
						Process p=b.start();
						BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						while(true){
						str=br.readLine();
						
						if (str.contains("IPv4 Address")) {
						str=str.substring(39,str.length());
						break;
						}}}
						catch(Exception ee){}
						new Server(str,name);
					}
				});
			}
		});
		
	}
	public static void main(String[] args) {
		
		fr=new first();
		fr.setVisible(true);
	
}
}
