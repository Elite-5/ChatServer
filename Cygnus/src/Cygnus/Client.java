//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.

//This class is executed when joining is clicked.
package Cygnus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.Timer;

class Servertra implements Runnable{//for recieving files over connection.
	String a;
	int ch;
	public servertransfer set;
	Servertra(String a,int ch){
		this.a=a;
		this.ch=ch;
	}
	public void run() {
		set=new servertransfer(a,ch);//executing servertransfer class.
	}
}
class chi implements Runnable {
	design f;
	Thread t;
	Socket s;
	String str;
	int k = 0, i = 0,ch;
	BufferedReader br;
	PrintWriter pw;
	String st, name, string,st1;
	String[] array;
	private Servertra se;
	chi(String str4, String name,int ch) {//components needed for new client.
		st = str4;
		this.name = name;
		this.ch=ch;
		t = new Thread(this);
		t.start();
	}
	String emot(String a) {//converting symbols back.
		for(int i=0;i<f.buttonlist1.length;i++) {
			if(a.contains("$#"+i+"#$")) {
				a=a.replace("$#"+i+"#$", f.buttonlist1[i]);
			}
		}
		return a;
	}
	public void run() {
		try {	
			
			entry_decry ed=new entry_decry(st);//convering encrypted IP back to normal.
			st1=st;
			st=ed.convert();
			while (st.compareTo("incorrect")==0) {
				st=JOptionPane.showInputDialog("Enter Correct Id");//continuously asking until coorect id in entered.
				ed=new entry_decry(st);
				st1=st;
				st=ed.convert();
				}
			if (ch==1)
			s=new Socket(st,2002);//for foram.
			else
			s=new Socket(st,2000);///for private chats.
			f = new design(st1,name,ch);//creating window for client.
			f.setResizable(false);
			
			f.btnNewButton1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					se=new Servertra(st,ch);
					Thread t=new Thread(se);//new thread for recieving files.
					t.start();//starting thread.
				}
			});
			
	f.btnNewButton.addActionListener(new ActionListener() {//sending messages from client.
				public void actionPerformed(ActionEvent ee) {
					try {
						str = f.textField.getText();
						pw = new PrintWriter(s.getOutputStream(), true);
						for(int i=0;i<f.buttonlist1.length;i++) {//symbols cannot be changed so it is send using a special way.
							if (str.contains(f.buttonlist1[i])) {
								str=str.replace(f.buttonlist1[i],"$#"+i+"#$");
							}}
						pw.println(str);
						f.textField.setText("");
					} catch (Exception e) {
					}
				}
			});
	
			f.btnNewButton_4.addActionListener(new ActionListener() {//exiting chat.
				public void actionPerformed(ActionEvent ee) {
					try {
						pw = new PrintWriter(s.getOutputStream(), true);
					} catch (IOException e) {}
					pw.println("!@#dispose_client#@!_"+name);//coded message for log out.
					f.dispose();
				}});
			
			f.setVisible(true);
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println(name);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			name = br.readLine();
			f.text.append("Connected" + "\n");
			Timer tt=new Timer(100,new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
				try {
					pw = new PrintWriter(s.getOutputStream(), true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.println("");
				}
			});
			tt.setInitialDelay(0);
			tt.start();//starting timer.
			
			while (true) {
				try {
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					array = br.readLine().split("!@#");
					int x=0;
					if (array.length==1) {
						x=0;
					}
					else
						x=1;
					f.text.setText("");
					f.text.append("Not Connected" + "\n" + "Connected" + "\n");
					if(("!@#"+array[x]).compareTo("!@#dispose_client#@!")==0) {
						f.dispose();
					}
					for (int i = 0; i < array.length; i += 2) {//for displaying message on client.
						if (array[i].contains("New")) {
							f.text.append(array[i] + "\n");
							i -= 1;
						} else if (!(array[i].contains("New")) && !(array[i + 1].contains("New")))
						{
							f.text.append(array[i] + "......." + emot(array[i + 1]) + "\n");
						}

						else {
							f.text.append(array[i] + "......." + emot(array[i + 2]) + "\n");
							i += 1;
						}
					}
				
				} catch (Exception ee) {
				}
			}

		} 
		catch (Exception e) {//if wrong entry then go back to run method above.
			st=JOptionPane.showInputDialog("Enter Correct Id");
			run();
		}
	}
}

public class Client {
	Client(String str3, String name,int ch) {
		new chi(str3, name, ch);
	}
	

}
