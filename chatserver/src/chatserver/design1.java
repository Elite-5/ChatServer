package chatserver;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class design1 extends JFrame {
	private static JFrame frame;
	public JPanel contentPane;
	public JTextField textField;
	public JTextArea text;
	public JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	public JButton btnNewButton_3;
	public String str,s1;
	public JButton btnNewButton1;
	public JButton btnNewButton2;
	private JPanel p;
	public JButton buttonlist[],special[];
	public String[] buttonlist1={"\u03C0","Σ","σ","Γ","µ","τ","Φ","Θ","Ω","δ","∞","φ","ε","∩",
			   "«","»","ß","±","€","¢","£","¥","©","®","™","√","ⁿ","²","³","½","Ø","⌠","⌡","≥",
			   "≤","≡","∩","∞","😀","😂","😅","😎","🙄","😏","😝","😴","😑","😔","😨","🚀","👍","🙏","😡","☠",
			   "🤦‍","🙋‍"};;
	public  JButton spacebar,backspace;
	  String[] convert=new  String[100];
	  String[] emoji=new String[20];
	  private int j,e1=1;
	public JButton btnNewButton_4;
	private JLabel label;
	public design1(final String name,String id) {
		setTitle("Cygnus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 580);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel.setBounds(22, 57, 97, 61);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setIgnoreRepaint(true);
		textField.setBounds(134, 67, 402, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		text = new JTextArea();
		text.setBounds(33, 202, 616, 278);
		contentPane.add(text);
		text.setFont(new Font("Monospaced", Font.PLAIN, 20));
		text.setEditable(false);
		btnNewButton = new JButton("");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setIcon(new ImageIcon("send.jpg"));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(566, 64, 64, 44);
		contentPane.add(btnNewButton);
		btnNewButton2 = new JButton("Virtual KeyBoard");
		btnNewButton2.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent e)
			{ 


				frame = new JFrame("virtual specialchar");
				p = new JPanel();
				Color c=new Color(128,128,128);
				 p.setBackground(c);
				frame.getContentPane().add(p);
				textField.setText("");
				buttonlist=new JButton[64];
				special=new JButton[60];
				e1=buttonlist1.length;
//				String rocket="\uD83D\uDE80";
//				System.out.println(rocket);
//				System.out.println("\u001B31;"+rocket);

				for(j=0;j<e1;j++)
				{   
					special[j]=new JButton(""+buttonlist1[j]);
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
				spacebar=new JButton("spacebar");
				spacebar.setBackground(Color.BLACK);
			    spacebar.setForeground(Color.white);
				p.add(spacebar);
				spacebar.addActionListener(new ActionListener() {
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
				backspace.addActionListener(new ActionListener() {
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
				frame.setVisible(true);
				
				

			}
		});
		
		btnNewButton2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton2.setBounds(453, 135, 196, 42);
		contentPane.add(btnNewButton2);
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(566, 64, 64, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Join Meet");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=JOptionPane.showInputDialog("Enter Joining ID");
				new Client(str,name);
			}
		});
		btnNewButton_1.setBounds(33, 133, 155, 44);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Create meet");
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=null;
				try {
				ProcessBuilder b=new ProcessBuilder("cmd.exe","/c","ipconfig");
				b.redirectErrorStream(true);
				Process p=b.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				while(true){
				str=br.readLine();
				if (str==null){break;}
				if (str.contains("IPv4 Address"))
				str=str.substring(39,str.length());
				}}
				catch(Exception ee){}
				new Server(str,name);
			}
		});
		btnNewButton_2.setBounds(221, 134, 196, 43);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("Welcome "+name);
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 0, 642, 33);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		btnNewButton_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		btnNewButton_4.setBounds(566, 495, 112, 33);
		contentPane.add(btnNewButton_4);
		JLabel lblNewLabel_2 = new JLabel("Meeting Id-"+id);
		lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 38, 467, 25);
		contentPane.add(lblNewLabel_2);
		label = new JLabel("");
		label.setIcon(new ImageIcon("blue.jpg"));
		label.setBounds(0, 0, 690, 541);
		contentPane.add(label);
		
		
		 
	}
}
