package chatserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class screen1 implements Runnable{
	String name;
	design1 f;
	Thread t;
	public Socket s;
	String s1;
	ServerSocket ss;
	PrintWriter pw;
	screen1(design1 f,String name,ServerSocket ss){
		this.f=f;
		this.ss=ss;
		this.name=name;
		
		
	}
	public void run() {
		try {
		s = ss.accept();
		f.btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				try {
					pw = new PrintWriter(s.getOutputStream(), true);
				} catch (IOException e) {
					
				}
				pw.println("!@#dispose_client#@!");
				f.dispose();
			}});
		screen1 s2=new screen1(f,name,ss);
		Thread t1=new Thread(s2);
		t1.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		s1 = br.readLine();
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println(name);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	f.text.append("New client connected " + s1 + "\n");
	msg1 m = new msg1(s, s1, f, name);
	t=new Thread(m);
	t.start();
	}
}
class msg1 implements Runnable {
	Socket s;
	String s1;
	BufferedReader br;
	design1 f;
	String name;

	msg1(Socket s, String s1, design1 f, String name) {
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
				if (string1.contains("_")) {
				String[] string2=string1.split("_");
				if ((string2[0]+"_"+string2[1]).compareTo("!@#dispose_client#@!")==0) {
					string1=" Left";}}
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

class Servercopy1 {

	String str;
	PrintWriter pw;
	public design1 f;
	ServerSocket ss;
	BufferedReader br;
	String st1;
	String name;

	Servercopy1(String id1, final String name) {
		f = new design1(name);
		try {
			
			f.text.append("Waiting for Client" + "\n");
			ss = new ServerSocket(2000);
			ss.setReuseAddress(true);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			final String date = String.valueOf(dtf.format(now));
			f.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						f.text.append("Me......." + f.textField.getText() + "(" + date + ")" + "\n");
						f.textField.setText("");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
			});
			
			
			f.setVisible(true);
			screen1 s=new screen1(f,name,ss);
			Thread t1=new Thread(s);
			t1.start();

		}

		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	}
}
class Server1 {
	Server1(String id1, String name){
		new Servercopy1(id1,name);
	}

}