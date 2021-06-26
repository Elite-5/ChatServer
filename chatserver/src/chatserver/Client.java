package chatserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.Timer;
class Servertra implements Runnable{
	String a;
	public servertransfer set;
	Servertra(String a){
		this.a=a;
	}
	public void run() {
		set=new servertransfer(a);
	}
}
class chi implements Runnable {
	design f;
	Thread t;
	Socket s;
	String str;
	int k = 0, i = 0;
	BufferedReader br;
	PrintWriter pw;
	String st, name, string,st1;
	String[] array;
	private Servertra se;
	chi(String str4, String name) {
		st = str4;
		this.name = name;
		
		t = new Thread(this);
		t.start();
		
	}
	String emot(String a) {
		for(int i=0;i<f.buttonlist1.length;i++) {
			if(a.contains("$#"+i+"#$")) {
				a=a.replace("$#"+i+"#$", f.buttonlist1[i]);
			}
		}
		return a;
	}
	public void run() {
		try {	
			
			entry_decry ed=new entry_decry(st);
			st1=st;
			st=ed.convert();
			while (st.compareTo("incorrect")==0) {
				st=JOptionPane.showInputDialog("Enter Correct Id");
				ed=new entry_decry(st);
				st1=st;
				st=ed.convert();
				}
			s=new Socket(st,2002);
			f = new design(st1);
			f.text.append("Not Connected" + "\n");
			se=new Servertra(st);
			Thread t=new Thread(se);
			t.start();
			f.btnNewButton1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				
				}
			});
			
	f.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						str = f.textField.getText();
						pw = new PrintWriter(s.getOutputStream(), true);
						for(int i=0;i<f.buttonlist1.length;i++) {
							if (str.contains(f.buttonlist1[i])) {
								str=str.replace(f.buttonlist1[i],"$#"+i+"#$");
							}}
						pw.println(str);
						f.textField.setText("");
					} catch (Exception e) {
					}
				}
			});
			f.btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						pw = new PrintWriter(s.getOutputStream(), true);
					} catch (IOException e) {}
					pw.println("!@#dispose_client#@!_"+name);
					f.dispose();
				}});
			f.setVisible(true);
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println(name);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			name = br.readLine();
			f.text.append("Connected" + "\n");
			Timer tt=new Timer(1000,new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
				try {
					pw = new PrintWriter(s.getOutputStream(), true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.println("");}
			});
			tt.start();
			while (true) {
				try {
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					array = br.readLine().split("!@#");
					f.text.setText("");
					f.text.append("Not Connected" + "\n" + "Connected" + "\n");
					if(("!@#"+array[1]).compareTo("!@#dispose_client#@!")==0) {
						f.dispose();
					}
					for (int i = 1; i < array.length; i += 2) {
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
		catch (Exception e) {
			st=JOptionPane.showInputDialog("Enter Correct Id");
			run();
		}
	}
}

public class Client {

	Client(String str3, String name) {
		new chi(str3, name);
	}
	public static void main(String ar[]) {
		new Client("wqk.wrq.qjj.qst.q","client");
	}

}
