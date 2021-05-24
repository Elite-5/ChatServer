package chatserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.Timer;

class chi implements Runnable {
	design f;
	Thread t;
	Socket s;
	String str;
	int k = 0, i = 0;
	BufferedReader br;
	PrintWriter pw;
	String st, name, string;
	String[] array;

	chi(String str4, String name) {
		st = str4;
		this.name = name;
		f = new design(str4);
		f.setVisible(true);
		f.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				try {
					str = f.textField.getText();
					pw = new PrintWriter(s.getOutputStream(), true);
					pw.println(str);
					f.textField.setText("");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		t = new Thread(this);
		t.start();
		
	}

	public void run() {
		try {
			f.text.append("Not Connected" + "\n");
			entry_decry ed=new entry_decry(st);
			st=ed.convert();
			s = new Socket(st, 2002);
			f.btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						pw = new PrintWriter(s.getOutputStream(), true);
					} catch (IOException e) {}
					pw.println("!@#dispose_client#@!_"+name);
					f.dispose();
				}});
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
							f.text.append(array[i] + "......." + array[i + 1] + "\n");
						}

						else {
							f.text.append(array[i] + "......." + array[i + 2] + "\n");
							i += 1;
						}
					}
				
				} catch (Exception ee) {
				}
			}

		} catch (Exception e) {
		}
	}
}

public class Client {

	Client(String str3, String name) {
		new chi(str3, name);
	}

}
