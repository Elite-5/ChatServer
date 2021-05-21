package chatserver;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
class accep implements Runnable{
ServerSocket ss;
Socket s;
BufferedReader br;
String str,str2="0";
PrintWriter pw;
Thread t;
String a;
private Connection cn;
private int f;

accep(String a){
	this.a=a;
    t=new Thread(this);
   t.start();
   
}

public void run(){
try{
ss=new ServerSocket(2000);
s= ss.accept();
	    while (true){
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			str=br.readLine();
			if (str!=null)
				break;
			}
	    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
				String s1="select * from "+a;
				PreparedStatement p=cn.prepareStatement(s1);
				ResultSet rs=p.executeQuery();
				f=0;
				
				while(rs.next()!=false) {
					if (rs.getString(1).compareTo(str)==0) {
						f=1;
						break;}
				}
				 if(f==1) {
				    	str2="1";
				    }
				    pw=new PrintWriter(s.getOutputStream(),true);
					pw.println(str2);
				cn.close();
				Timer t1=new Timer(1000,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
						
						String s1="select * from "+a+"1";
						PreparedStatement p=cn.prepareStatement(s1);
						ResultSet rs1=p.executeQuery();
						String s2="select count(user) from "+a+"1";
						PreparedStatement p1=cn.prepareStatement(s2);
						ResultSet rs2=p1.executeQuery();
						pw=new PrintWriter(s.getOutputStream(),true);
						rs2.next();
						pw.println(rs2.getString(1));
						while(rs1.next()!=false) {
						pw=new PrintWriter(s.getOutputStream(),true);
						pw.println(rs1.getString(1)+":"+rs1.getString(2)+"("+rs1.getString(3)+")");}
						cn.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				t1.setInitialDelay(0);
				t1.start();
				
				while (true) {
					br=new BufferedReader(new InputStreamReader(s.getInputStream()));
					str=br.readLine();
					String[] str1 = {str.substring(0,str.indexOf(":")),str.substring(str.indexOf(":")+1)};
			
					cn = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=root&password=India@123");
					String s="insert into "+a+"1(user,message,time) values(\""+str1[0]+"\""+",\""+str1[1].substring(0,str1[1].indexOf("("))+"\","+"\""+str1[1].substring(str1[1].indexOf("("),str1[1].length()-1)+"\")";
					p=cn.prepareStatement(s);
						p.executeUpdate();
				}
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
			}
	   
	}catch(Exception ee) {
           System.out.println(ee.getMessage());}
}}

public class Server1{
Server1(String a) {
	
	     new accep(a);       
}
}





