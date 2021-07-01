//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.
//for sending files its an uploader.
package Cygnus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Serv implements Runnable{//for recieving file.
	File[] fileToSend;
	Socket[] socket;
	int i,k;
	Serv(File[] fileToSend,int i,Socket[] socket,int k){
		this.fileToSend=fileToSend;
		this.i=i;
		this.socket=socket;
		this.k=k;
	}
	public void run() {//sending bytes of files.
		try {
		for (int l=0;l<k;l++) {
		FileInputStream fileInputStream = new FileInputStream(fileToSend[i-1].getAbsolutePath());
		DataOutputStream dataOutputStream = new DataOutputStream(socket[l].getOutputStream());
        String fileName = fileToSend[i-1].getName();
        byte[] fileNameBytes = fileName.getBytes();
        byte[] fileBytes = new byte[(int)fileToSend[i-1].length()];
        fileInputStream.read(fileBytes);
        dataOutputStream.writeInt(fileNameBytes.length);
        dataOutputStream.write(fileNameBytes);
        dataOutputStream.writeInt(fileBytes.length);
        dataOutputStream.write(fileBytes);}
		} catch (IOException e) {
		}
	}
} 
class acc implements Runnable{
	ServerSocket ss;
	Socket[] socket;
	public int k=0;
	acc(ServerSocket ss){
		this.ss=ss;
		socket=new Socket[100];
	}
	public void run() {
		while(true) {
			try {
				socket[k]=ss.accept();
				k+=1;
			} catch (IOException e) {
			}
		}
	}
}
public class clienttransfer {//for sending to clients.
	public ServerSocket ss;
	int i=0;
	private acc s1;
	public JFrame jFrame;
    clienttransfer(int ch) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        final File[] fileToSend = new File[100];
        jFrame = new JFrame("Uploader");
        jFrame.setResizable(false);
        jFrame.setBackground(Color.CYAN);
        jFrame.setSize(563, 493);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlTitle = new JLabel("File Transfer");
        jlTitle.setForeground(Color.WHITE);
        jlTitle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jlTitle.setBackground(Color.WHITE);
        jlTitle.setBounds(205, 0, 176, 59);
        jlTitle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        final JLabel jlFileName = new JLabel("               Choose a file to send");//button for choosing file to send.
        jlFileName.setForeground(Color.WHITE);
        jlFileName.setBackground(Color.WHITE);
        jlFileName.setBounds(12, 103, 524, 74);
        jlFileName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
        jlFileName.setBorder(null);
        jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
        if(ch==1)
        ss = new ServerSocket(1235);
        else
        ss = new ServerSocket(1234);
        ss.setReuseAddress(true);
        } catch (Exception ex) {
        }
        s1=new acc(ss);
        Thread t1=new Thread(s1);//new thread for acceptiing client.
        t1.start();//starting thread.
        jFrame.getContentPane().setLayout(null);
        jFrame.getContentPane().add(jlTitle);
        jFrame.getContentPane().add(jlFileName);
        JButton jbSendFile = new JButton("Send File");//sending file on connection button.
        jbSendFile.setForeground(Color.BLACK);
        jbSendFile.setBorder(UIManager.getBorder("Button.border"));
        jbSendFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jbSendFile.setBounds(81, 343, 150, 50);
        jFrame.getContentPane().add(jbSendFile);
   
                jbSendFile.setBackground(Color.CYAN);
                jbSendFile.setPreferredSize(new Dimension(150, 50));
                jbSendFile.setFont(new Font("Arial", Font.BOLD, 20));
                JButton jbChooseFile = new JButton("Choose File");
                jbChooseFile.setForeground(Color.BLACK);
                jbChooseFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jbChooseFile.setBounds(344, 343, 150, 50);
                jFrame.getContentPane().add(jbChooseFile);
                jbChooseFile.setBackground(Color.CYAN);
                
                      jbChooseFile.setPreferredSize(new Dimension(150, 50));
                      jbChooseFile.setFont(new Font("Arial", Font.BOLD, 20));
                      
                      JLabel label_1 = new JLabel("");//background.
                      label_1.setBackground(Color.WHITE);
                      label_1.setBounds(81, 103, 284, 74);
                      jFrame.getContentPane().add(label_1);
                      
                      JLabel label_2 = new JLabel("");//cover background.
                      label_2.setIcon(new ImageIcon("blue.jpg"));
                      label_2.setBounds(0, 0, 584, 467);
                      jFrame.getContentPane().add(label_2);
                      jbChooseFile.addActionListener(new ActionListener() {
                          @Override
                       public void actionPerformed(ActionEvent e) {
                                JFileChooser jFileChooser = new JFileChooser();
                                jFileChooser.setDialogTitle("Choose a file to send.");
                                if (jFileChooser.showOpenDialog(null)  == JFileChooser.APPROVE_OPTION) {
                                   fileToSend[i] = jFileChooser.getSelectedFile();
                                   jlFileName.setText("File selected: \n" + fileToSend[i].getName());
                                   i+=1;
                                   if (i==100) {
                                        i=0;
                                       } } }
                              });
                jbSendFile.addActionListener(new ActionListener() {//downloading file.
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (fileToSend[0] == null) {
                            jlFileName.setText("Please choose a file to send first!");
                        } else {
                                Serv m=new Serv(fileToSend,i,s1.socket,s1.k);
                                Thread t=new Thread(m);//new thread to send to all file.
                                t.start();//starting thread.
                      }
                    }
                });
    }
	

}