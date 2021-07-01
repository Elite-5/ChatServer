
//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.


//Welcome to Cygnus-The ChatServer, this project is based on socket programming using java.Computers needed to be connected by same network. 
//It uses awt and swing component for UI.
//It can be used to chat with any number of people until server is working, a client can have atmost two connections at a time.
//It also can be used to transfer media and also have a keyboard dedicated to special symbols.


package Cygnus;//package name.
//imports required.
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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Cursor;
//this is front page of project containing button for private chats and foram.
@SuppressWarnings("serial")//To suppress warning.
public class first extends JFrame {//main class.
    private static first fr;//main frame front window.
	private JPanel contentPane;//panel.
	
	public first() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {//constructor of first class throwing exception for special designing using UIManager.
		//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");//look.
		setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 580);
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.setSize(new Dimension(50, 50));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Private Room");//private room button and properties for private chats.
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(52, 392, 227, 65);
		contentPane.add(btnNewButton);
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		JButton btnNewButton_1 = new JButton("Forum");//Foram button and properties for organizations.
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(414, 392, 227, 64);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(0, 206, 209));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("cygnus1.jpg"));//Background image.
		label_1.setBounds(70, 33, 620, 359);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("black.jpg"));//Background image.
		label.setBounds(0, 0, 690, 542);
		contentPane.add(label);
		
		btnNewButton_1.addActionListener(new ActionListener() {//Foram button for foram path and its coding.
			second frame;
			public void actionPerformed(ActionEvent e) {
				fr.dispose();//disposing first window.
				frame = new second();
				frame.setResizable(false);
				frame.setVisible(true);
				frame.btnNewButton.addActionListener(new ActionListener() {//next window with reference of second class for joining meeting. 
					public void actionPerformed(ActionEvent e) {
						String name=JOptionPane.showInputDialog("Enter Username");
						String str=JOptionPane.showInputDialog("Enter Joining ID");
						frame.dispose();
						new Client(str,name,1);//client creation.
									}
								});
				frame.btnNewButton_1.addActionListener(new ActionListener() {//foram creating ,button of second class.
					public void actionPerformed(ActionEvent e) {
						String name=JOptionPane.showInputDialog("Enter Username");
						frame.dispose();
						String str=null;
						try {
						ProcessBuilder b=new ProcessBuilder("cmd.exe","/c","ipconfig");
						b.redirectErrorStream(true);
						Process p=b.start();
						BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						while(true){//IP address needed for connection cmd using java to find IP address.
						str=br.readLine();
						
						if (str.contains("IPv4 Address")) 
						{
						str=str.substring(39,str.length());
						break;
						}}}
						catch(Exception ee){}	
						new Server(str,name,1);//Server creation.
					}
				});
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {//private button path and coding.
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
						new Client(str,name,0);//client creation.
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
						
						while(true){//IP Address for cmd ,refer line 95.
						str=br.readLine();
						
						if (str.contains("IPv4 Address")) {
						str=str.substring(39,str.length());
						break;
						}}}
						catch(Exception ee){}
						new Server(str,name,0);//server creation.
					}});
				}
		});	
	}
	//Main class of project.
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		fr=new first();
		fr.setResizable(false);//to prevent size change.
		fr.setVisible(true);//to make it visible.
}
}
