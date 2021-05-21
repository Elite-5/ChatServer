package chatserver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.nio.*;
import java.util.*;
@SuppressWarnings("serial")
public class specialchar extends JFrame  implements ActionListener
{  
	 private static JFrame frame;
	JButton buttonlist[],special[];
	
	 JButton spacebar,backspace;
	 JTextField text;
	  String[] convert=new  String[100];
	  String[] emoji=new String[20];
	private JPanel p;
	int x=1,e;

	public void key(JPanel p)
	{   
		this.p = p;
		text=new JTextField(26);
		text.setBackground(Color .black);
		text.setForeground(Color.white);
		 Font bigFont = text.getFont().deriveFont(Font.PLAIN, 30f);
		text.setFont(bigFont);
		text.setVisible(true);
		p.add(text);
		buttonlist=new JButton[64];
		special=new JButton[60];
		String[] buttonlist={"π","Σ","σ","Γ","µ","τ","Φ","Θ","Ω","δ","∞","φ","ε","∩",
	   "«","»","ß","±","€","¢","£","¥","©","®","™","√","ⁿ","²","³","½","Ø","⌠","⌡","≥",
	   "≤","≡","∩","∞","😀","😂","😅","😎","🙄","😏","😝","😴","😑","😔","😨","🚀","👍","🙏","😡","☠",
	   "🤦‍","🙋‍"};
		e=buttonlist.length;
//		String rocket="\uD83D\uDE80";
//		System.out.println(rocket);
//		System.out.println("\u001B31;"+rocket);

		for(int i=0,j=0;i<e;i++,j++)
		{   
			special[j]=new JButton(""+buttonlist[j]);
			special[j].setBackground(Color.BLACK);
		    special[j].setForeground(Color.white);
	//	    special[j].setPreferredSize(new Dimension(100, 100));
		//    special[j].setFont(new Font("Arial", Font.PLAIN, 10));
			p.add(special[j]);
			special[j].addActionListener(this);
		}
		spacebar=new JButton("spacebar");
		spacebar.setBackground(Color.BLACK);
	    spacebar.setForeground(Color.white);
		p.add(spacebar);
		spacebar.addActionListener(this);
		backspace=new JButton("backspace");
		backspace.setBackground(Color.BLACK);
	    backspace.setForeground(Color.white);
		p.add(backspace);
		backspace.addActionListener(this);;
		
	}	
	   @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ae)
		{    if(ae.getSource()==spacebar)
			text.setText(text.getText()+" ");
		else if(ae.getSource()==backspace)
		{String s=text.getText();
		s=s.substring(0,s.length()-1);
		text.setText(s);
		}
		 
		else
		   for(int i=0,j=0;i<e;j++,i++)
		  {   
		  	  if(ae.getSource()==special[j])
		  	  text.setText(""+text.getText()+special[j].getLabel());

		 }
		}


		public specialchar()
			{ 
			frame = new JFrame("virtual specialchar");
			p = new JPanel();
			 p.setBackground(Color.black);
			frame.add(p);
			key(p);
			frame.setSize(700,300);
			frame.getContentPane().setBackground(Color.black);
			frame.setVisible(true);
			
			}
			public static void main(String s[])
			{
				specialchar keys= new specialchar();
			}
}