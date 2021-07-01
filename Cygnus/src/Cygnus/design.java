//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.
//for designing of server and client.

package Cygnus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
@SuppressWarnings("serial")

public class design extends JFrame  {
	private static JFrame frame;
	public JPanel contentPane;
	public JTextField textField;
	public JTextArea text;
	public JScrollPane scrollPane;
	public JButton btnNewButton;
	public JButton btnNewButton1;
	public JButton btnNewButton2;
	private JPanel p;
	private JLabel lblNewLabel_1;
	public JButton buttonlist[],special[];
	public String[] buttonlist1={"π","Σ","σ","Γ","µ","τ","Φ","Θ","Ω","δ","∞","φ","ε","∩",
			   "«","»","ß","±","€","¢","£","¥","©","®","™","√","ⁿ","²","³","½","Ø","⌠","⌡","≥",
			   "≤","≡","∩","∞","😀","😂","😅","😎","🙄","😏","😝","😴","😑","😔","😨","🚀","👍","🙏","😡","☠",
			   "🤦‍","🙋‍"};//characters of keyboard.
	public  JButton spacebar,backspace;//for backspace and spacebar.
	  String[] convert=new  String[100];
	  String[] emoji=new String[20];
	  private int j,e1=1;
	public JButton btnNewButton_4;
	private JLabel label;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	public design(String id,String name,int ch) {//constructor for creating design of server and client.
		setFont(new Font("Harlow Solid Italic", Font.PLAIN, 19));
		setTitle("Cygnus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 580);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		btnNewButton_1 = new JButton("Join Meet");//joining another private server.
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton_1.setBounds(33, 133, 155, 44);
		
		
		btnNewButton_2 = new JButton("Create meet");//creating a server for private chats.
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton_2.setBounds(221, 134, 196, 43);
		
		
		lblNewLabel_1 = new JLabel("Welcome "+name);////name of server or client.
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 0, 642, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Message");//message display.
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel.setBounds(22, 57, 97, 61);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//textfield for entry.
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setIgnoreRepaint(true);
		textField.setBounds(134, 67, 402, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane =  new JScrollPane();//scrollpane.
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(22, 203 ,616, 278);
		scrollPane.getViewport().setBackground(Color.white);
		getContentPane().add(scrollPane);
		
		btnNewButton = new JButton("");//for background.
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setIcon(new ImageIcon("send.jpg"));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(566, 64, 64, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton1 = new JButton("Files");//button for files.
		btnNewButton1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton1.setBounds(22, 491, 219, 39);
		contentPane.add(btnNewButton1);
		
		btnNewButton2 = new JButton("Virtual KeyBoard");//virtual keyboard.
		btnNewButton2.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent e)
			{ 
				frame = new JFrame("virtual specialchar");
				frame.setResizable(false);
				p = new JPanel();
				Color c=new Color(128,128,128);
				 p.setBackground(c);
				frame.getContentPane().add(p);
				textField.setText("");
				buttonlist=new JButton[64];
				special=new JButton[60];
				e1=buttonlist1.length;
				for(j=0;j<e1;j++)
				{   
					special[j]=new JButton(""+buttonlist1[j]);//keyboard buttons.
					special[j].setPreferredSize(new Dimension(60,30));
					special[j].setBackground(Color.BLACK);
				    special[j].setForeground(Color.white);
					p.add(special[j]);
					special[j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton) e.getSource();
							int i;
							for (i=0;i<e1;i++)
								if (bt==special[i])
									break;
							textField.setText(textField.getText()+buttonlist1[i]);
						}
					});
				}
				spacebar=new JButton("spacebar");//spacebar.
				spacebar.setBackground(Color.BLACK);
			    spacebar.setForeground(Color.white);
				p.add(spacebar);
				spacebar.addActionListener(new ActionListener() {//for spacebar.
					public void actionPerformed(ActionEvent e) 
					{
						textField.setText(textField.getText()+" ");
					}
				}
					);
				
				backspace=new JButton("backspace");
				backspace.setBackground(Color.BLACK);
			    backspace.setForeground(Color.white);
				p.add(backspace);
				backspace.addActionListener(new ActionListener() {//for backspace.
						public void actionPerformed(ActionEvent e) 
						{
							String s=textField.getText();
							s=s.substring(0,s.length()-1);
							textField.setText(s);
						}
						}
						);

				frame.setSize(700,300);
				frame.getContentPane().setBackground(Color.black);
				frame.setVisible(true);//making visible keyboard.


			}
		});
		if(ch==1) {//for foram.
			
			btnNewButton_1.addActionListener(new ActionListener() {//for client meet.
				public void actionPerformed(ActionEvent e) {
					String str=JOptionPane.showInputDialog("Enter Joining ID");
					new Client(str,name,0);
				}
			});
			btnNewButton_2.addActionListener(new ActionListener() {//for server meet.
				public void actionPerformed(ActionEvent e) {//finding IP Address.
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
					new Server(str,name,0);
				}
			});
			
	    contentPane.add(btnNewButton_1);//adding button.
		contentPane.add(btnNewButton_2);//adding button.
		}
		btnNewButton2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton2.setBounds(453, 135, 196, 43);
		contentPane.add(btnNewButton2);
		JLabel lblNewLabel_1 = new JLabel("Meeting ID - "+id);//meeting id.
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
		lblNewLabel_1.setBounds(10, 23, 642, 44);
		contentPane.add(lblNewLabel_1);
        btnNewButton_4 = new JButton("Log Out");//log out.
        btnNewButton_4.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(566, 495, 112, 33);
		contentPane.add(btnNewButton_4);
		
		label = new JLabel("");
		label.setBackground(SystemColor.desktop);
		label.setIcon(new ImageIcon("blue.jpg"));//background.
		label.setBounds(0, 0, 690, 541);
		contentPane.add(label);
		text = new JTextArea();
		contentPane.add(text);
		text.setFont(new Font("Monospaced", Font.PLAIN, 20));
		text.setIgnoreRepaint(true);
		text.setBounds(22, 203 ,597, 276);
		text.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(245, 255, 250)));
		text.setEditable(false);
	}

	
	
}
