package chatserver;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class front extends JFrame {

	private JPanel contentPane;
	public design1 f;
	public int z=0;
	public Timer t2;
	/**
	 * Launch the application.
	 */
	
			private String str1;
			private String str2;
			private Socket s;
			private BufferedReader br;
			private String str;
			private PrintWriter pw;
			
	public front() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Join Server");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
			//needs multithreading to solve multiple try
				
				
				str1=JOptionPane.showInputDialog("Enter address of Server");
				str1="localhost";
				str2=JOptionPane.showInputDialog("Enter employee ID");
				try {
					s=new Socket(str1,2000);
					pw=new PrintWriter(s.getOutputStream(),true);
					pw.println(str2);
					while (true){
						br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						str=br.readLine();
						if (str!=null)
							break;
						}
					if (str.compareTo("1")==0) {
						design1 dd=new design1(str2);
						dd.setVisible(true);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    				    LocalDateTime now = LocalDateTime.now();  
    					String date=String.valueOf(dtf.format(now));
						dd.btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									pw=new PrintWriter(s.getOutputStream(),true);
									pw.println(str2+":"+dd.textField.getText()+"("+date+")"+"\n");
									dd.textField.setText("");
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								
							}
						});
						dd.btnNewButton_4.addActionListener(new ActionListener() {
							

							public void actionPerformed(ActionEvent e) {
								dd.dispose();}});
						br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						str="1";
						Timer t1=new Timer(1000,new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
								dd.text.setText("");
								int i=0;
								String str5 = br.readLine();
								
								while (i<Integer.parseInt(str5)) { 
								str=br.readLine();
								dd.text.append(str+"\n");
								i++;}}
								catch (Exception e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
							}
						});
						t1.setInitialDelay(0);
						t1.start();

					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username");
					}
				
				} 
				 catch (Exception e1) {
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(null, "Invalid Server");
				}
			}
		});
		btnNewButton.setBounds(143, 179, 117, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Server");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				str2=JOptionPane.showInputDialog("Enter employee ID");

				f=new design1(str2);
     			f.contentPane.add(f.btnNewButton_3);
     			f.setVisible(true);
     			try {
     			 	Class.forName("com.mysql.cj.jdbc.Driver");
     			 	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
     				String s="create table if not exists "+str2+"1"+"(user varchar(50),message varchar(1000),time varchar(50))";			
     				PreparedStatement p=cn.prepareStatement(s);
     				p.executeUpdate();
     				cn.close();
    		}

     			catch(Exception ee) {
     				JOptionPane.showMessageDialog(null, ee.getMessage());
     			}
     			
     			new Server1(str2);
				f.btnNewButton.addActionListener(new ActionListener() {
     				public void actionPerformed(ActionEvent e) {
     					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
     					 LocalDateTime now = LocalDateTime.now();  
     					 String date=String.valueOf(dtf.format(now)); 
     					try {
     					Class.forName("com.mysql.cj.jdbc.Driver");
							Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
							String s="insert into "+str2+"1(user,message,time) values(\""+str2+"\""+",\""+f.textField.getText()+"\","+"\""+date+"\")";
							PreparedStatement p=cn.prepareStatement(s);
							p.executeUpdate();
							f.textField.setText("");}
     					catch(Exception ee) {JOptionPane.showMessageDialog(null, ee.getMessage());}
     				}
     			});
				t2=new Timer(100,new ActionListener() {
     				public void actionPerformed(ActionEvent e) {
     					Connection cn;
             			String s1;
             		
     					try {
     					cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
     					if(z==0) {
	     				s1="select * from "+str2+"1";
	     				PreparedStatement p = cn.prepareStatement(s1);
	     				ResultSet rs=p.executeQuery();
	     				f.text.setText("");
	     				while(rs.next()!=false) 
	     					f.text.append(rs.getString(1)+":"+rs.getString(2)+"("+rs.getString(3)+")"+"\n");
     					}
     					else {
     						t2.stop();
     					}
	     				}
             			catch(Exception ee) {
								JOptionPane.showMessageDialog(null, ee.getMessage());
						}
				
     				}
     			});
     			t2.setInitialDelay(0);
     			t2.start();
				f.btnNewButton_4.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						f.dispose();
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
							String s1="drop table "+str2;
							PreparedStatement p=cn.prepareStatement(s1);
							p.executeUpdate();
							cn.close();
							Class.forName("com.mysql.cj.jdbc.Driver");
						    cn=DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
							s1="drop table "+str2+"1";
							p=cn.prepareStatement(s1);
							p.executeUpdate();
							cn.close();
							z=1;
						}
						catch(Exception ee) {System.out.println(ee.getMessage());}
					}
				});
         			f.btnNewButton_3.addActionListener(new ActionListener() {
         				private String candidate;
         				private String[] clist;
         				private Connection cn;

         				public void actionPerformed(ActionEvent e) {
         					
                 			
         					candidate=JOptionPane.showInputDialog("Enter IDs separated by ,");
         					clist=candidate.split(",");
         					for (int i=0;i<clist.length;i++) {
         						try {
         							Class.forName("com.mysql.cj.jdbc.Driver");
         							cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
         							String s="create table if not exists "+str2+"(user varchar(50))";
         							String s1="insert into "+str2+"(user) values(\""+clist[i]+"\")";
         							PreparedStatement p=cn.prepareStatement(s);
         							p.executeUpdate();
         							PreparedStatement p1=cn.prepareStatement(s1);
         							p1.executeUpdate();
         							cn.close();
         							}
         							catch(Exception ee) {
         								JOptionPane.showMessageDialog(null, ee.getMessage());
         						}
         					}
         				}
         			});
     
				
	     			
             			
             			
             			
             			
			}
		});
		
		btnNewButton_1.setBounds(143, 213, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Add image");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(156, 74, 191, 50);
		contentPane.add(lblNewLabel);
	}
	
}