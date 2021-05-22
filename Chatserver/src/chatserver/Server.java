package chatserver;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Timer;

import java.io.*;
import java.awt.event.*;

class msg implements Runnable {
	Socket s;
	String s1;
	BufferedReader br;
	design f;
	String name;

	msg(Socket s, String s1, design f, String name) {
		this.s = s;
		this.s1 = s1;
		this.f = f;
		this.name = name;
	}

	public void run() {
		while (true)

			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String date = String.valueOf(dtf.format(now));
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String string1=br.readLine();
				if (string1.compareTo("")!=0)
			    f.text.append(s1 + "......." + string1+ "(" + date + ")" + "\n");
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				String string = f.text.getText();
				string = string.replace(".......", "!@#");
				string = string.replace("Me", name);
				string = string.replace("\n", "!@#");
				pw.println(string);

			} catch (Exception ee) {
				System.out.println(ee.getMessage() + "hi");
			}
			
	}

}

public class Server {

	String str;
	PrintWriter pw;
	public design f;
	String s1;
	public Socket s;
	ServerSocket ss;
	Thread t;
	BufferedReader br;
	String st1;
	String name;

	Server(String id1, final String name) {
		f = new design(id1);
		try {
			
			f.text.append("Waiting for Client" + "\n");
			ss = new ServerSocket(2002);
			ss.setReuseAddress(true);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			final String date = String.valueOf(dtf.format(now));
			f.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						str = f.textField.getText();
						f.text.append("Me......." + f.textField.getText() + "(" + date + ")" + "\n");
						f.textField.setText("");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
			});
			f.setVisible(true);
			while(true) {
					try {
						
						s = ss.accept();
						BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						s1 = br.readLine();
						PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
						pw.println(name);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					f.text.append("New client connected " + s1 + "\n");
					msg m = new msg(s, s1, f, name);
					t=new Thread(m);
					t.start();
					
				}
			
			
			
		}

		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		new Server("localhost", "Server");
	}
}
