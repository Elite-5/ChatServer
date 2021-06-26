package chatserver;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
@SuppressWarnings("serial")

public class design extends JFrame  {
	private static JFrame frame;
	private JPanel contentPane;
	public JTextField textField;
	public JTextArea text;
	public JScrollPane scrollPane;
	public JButton btnNewButton;
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
	
			
	public design(String id) {
		setFont(new Font("Harlow Solid Italic", Font.PLAIN, 19));
		setTitle("Cygnus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 588);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel.setBounds(22, 57, 97, 61);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setIgnoreRepaint(true);
		textField.setBounds(134, 67, 402, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane =  new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text = new JTextArea();
		text.setFont(new Font("Monospaced", Font.PLAIN, 20));
		text.setIgnoreRepaint(true);
		text.setBounds(90, 120 ,300, 200);
		text.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(245, 255, 250)));
		text.setEditable(false);
		scrollPane.setBounds(33, 202 ,616, 278);
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.setViewportView(text);
		getContentPane().add(scrollPane);
		
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
		
		btnNewButton1 = new JButton("Attach");
		btnNewButton1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton1.setBounds(33, 133, 241, 44);
		contentPane.add(btnNewButton1);
		
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
		btnNewButton2.setBounds(453, 135, 196, 43);
		contentPane.add(btnNewButton2);
		JLabel lblNewLabel_1 = new JLabel("Meeting ID - "+id);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
		lblNewLabel_1.setBounds(12, 0, 642, 44);
		contentPane.add(lblNewLabel_1);
        btnNewButton_4 = new JButton("Log Out");
        btnNewButton_4.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		btnNewButton_4.setBounds(566, 495, 112, 33);
		contentPane.add(btnNewButton_4);
		
		label = new JLabel("");
		label.setBackground(SystemColor.desktop);
		label.setIcon(new ImageIcon("blue.jpg"));
		label.setBounds(0, 0, 690, 541);
		contentPane.add(label);
	}

	
	
}
