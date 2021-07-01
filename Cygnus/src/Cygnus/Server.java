//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.

//next on clicking create button of window of second class. Become server if closed then all clients closes.
package Cygnus;

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
import javax.swing.UnsupportedLookAndFeelException;

class screen implements Runnable{//multithreading used to recieve and send messages.
	String name;
	design f;
	Thread t;
	public Socket s;
	String s1;
	ServerSocket ss;
	screen(design f,String name,ServerSocket ss){//for using in run these variables needed.
		this.f=f;
		this.ss=ss;
		this.name=name;
	}
	public void run() {
		try {
		s = ss.accept();//recieving request from client.
		f.btnNewButton_4.addActionListener(new ActionListener() {
			private PrintWriter pw;
			public void actionPerformed(ActionEvent ee) {//log out button to log out all connections.
				try {
					pw = new PrintWriter(s.getOutputStream(), true);
				} catch (IOException e) {
					
				}
				pw.println("!@#dispose_client#@!");
				f.dispose();
				
			}});
		screen s2=new screen(f,name,ss);
		Thread t1=new Thread(s2);
		t1.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		s1 = br.readLine();//recieving name of client.
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println(name);//sending name of client.
	} catch (Exception e1) {
	}
	f.text.append("New client connected " + s1 + "\n");
	msg m = new msg(s, s1, f, name);
	t=new Thread(m);//new thread started to continuously recieve messages.
	t.start();//started thread.
	}
}

class msg implements Runnable {//thread dealing with recieving messages.
	Socket s;
	String s1;
	BufferedReader br;
	design f;
	String name;
	msg(Socket s, String s1, design f, String name) {//components needed for this thread.
		this.s = s;
		this.s1 = s1;
		this.f = f;
		this.name = name;
	}

	public void run() {//this will constantly send messages.
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
				if (string1.compareTo("")!=0) {//for special keyboard.
					for(int i=0;i<f.buttonlist1.length;i++) {
						if (string1.contains("$#"+i+"#$")) {
							string1=string1.replace("$#"+i+"#$",f.buttonlist1[i]);
						}}
			    f.text.append(s1 + "......." + string1+ "(" + date + ")" + "\n");//display.
				}
			    PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				String string = f.text.getText();
				string = string.replace(".......", "!@#");
				string = string.replace("Me", name);
				string = string.replace("\n", "!@#");
				 for(int i=0;i<f.buttonlist1.length;i++) {
						if (string.contains(f.buttonlist1[i])) {
							string=string.replace(f.buttonlist1[i],"$#"+i+"#$");
						}}
				pw.println(string);//sending message to clients.
			
			} catch (Exception ee) {
			}		
	}
}

class Servercopy {
	String str;
	PrintWriter pw;
	public design f;
	ServerSocket ss;
	BufferedReader br;
	String st1;
	String name;
	private clienttransfer ct;// to tranfer multimedia.
	String emot(String a) {
		for(int i=0;i<f.buttonlist1.length;i++) {
			if(a.contains("$#"+i+"#$")) {
				a=a.replace("$#"+i+"#$", f.buttonlist1[i]);
			}
		}
		return a;
	}
	Servercopy(String id1, final String name,int ch)  {
		entry_decry ed=new entry_decry(id1);
		id1=ed.convert();
		f = new design(id1,name,ch);//for designing front page.
		f.setResizable(false);
		try {
			ct=new clienttransfer(ch);
		} catch (ClassNotFoundException e1) {
			
		} catch (InstantiationException e1) {
			
		} catch (IllegalAccessException e1) {
			
		} catch (UnsupportedLookAndFeelException e1) {
			
		}
		try {
			f.btnNewButton1.addActionListener(new ActionListener()// for diplaying uploader window.
			{
				public void actionPerformed(ActionEvent e)
				{ 
				ct.jFrame.setVisible(true);	
				}
			});
		
			if(ch==1) 
			ss = new ServerSocket(2002);//making server socket for foram.
			else 
			ss=new ServerSocket(2000);//making server socket for private chats.
			
			ss.setReuseAddress(true);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			final String date = String.valueOf(dtf.format(now));//getting date time for message sent time.
			f.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					try {
						str = f.textField.getText();
						f.text.append("Me......." + emot(str) + "(" + date + ")" + "\n");
						f.textField.setText("");//for sendinf server response.
						
					} catch (Exception e) {
					}

				}
			});
			
			f.setVisible(true);
			screen s=new screen(f,name,ss);
			Thread t1=new Thread(s);//new thread to recieve new client.
			t1.start();

		}

		catch (Exception e) {
		}

	}
}
class Server{//server class.
	Server(String id1, String name,int ch){
		new Servercopy(id1,name,ch);
	}

}