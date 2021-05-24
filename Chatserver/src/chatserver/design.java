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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
	
	public  JButton spacebar,backspace;
	  String[] convert=new  String[100];
	  String[] emoji=new String[20];
	  private int j,e1=1;
	public JButton btnNewButton_4;
			
	public design(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 47, 60, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 50, 309, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane =  new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text = new JTextArea();
		text.setBounds(90, 120 ,300, 200);
		text.setBorder((Border) new LineBorder(Color.BLACK));
		text.setEditable(false);
		scrollPane.setBounds(90, 120 ,300, 200);
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.getViewport().add(text);
		add(scrollPane);
		
		btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(310, 80, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton1 = new JButton("Attach");
		btnNewButton1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new clienttransfer();
			}
		});
		btnNewButton1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton1.setBounds(10, 80, 89, 23);
		contentPane.add(btnNewButton1);
		
		btnNewButton2 = new JButton("Virtual KeyBoard");
		btnNewButton2.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent e)
			{ 


				frame = new JFrame("virtual specialchar");
				p = new JPanel();
				 p.setBackground(Color.black);
				frame.add(p);
				textField.setText("");
				buttonlist=new JButton[64];
				special=new JButton[60];
				String[] buttonlist1={"π","Σ","σ","Γ","µ","τ","Φ","Θ","Ω","δ","∞","φ","ε","∩",
			   "«","»","ß","±","€","¢","£","¥","©","®","™","√","ⁿ","²","³","½","Ø","⌠","⌡","≥",
			   "≤","≡","∩","∞","😀","😂","😅","😎","🙄","😏","😝","😴","😑","😔","😨","🚀","👍","🙏","😡","☠",
			   "🤦‍","🙋‍"};
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
		btnNewButton2.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton2.setBounds(150, 80, 150, 23);
		contentPane.add(btnNewButton2);
		
		JLabel lblNewLabel_1 = new JLabel("Meeting ID - "+id);
		lblNewLabel_1.setBounds(34, 0, 365, 25);
		contentPane.add(lblNewLabel_1);
        btnNewButton_4 = new JButton("Log Out");
		
		btnNewButton_4.setBounds(200, 11, 89, 23);
		contentPane.add(btnNewButton_4);
	}

	
	protected void servertransfer() {
		// TODO Auto-generated method stub
		
	}
}