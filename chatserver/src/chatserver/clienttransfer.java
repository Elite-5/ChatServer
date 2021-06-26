package chatserver;

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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
class Serv implements Runnable{
	File[] fileToSend;
	Socket[] socket;
	int i,k;
	Serv(File[] fileToSend,int i,Socket[] socket,int k){
		this.fileToSend=fileToSend;
		this.i=i;
		this.socket=socket;
		this.k=k;
	}
	public void run() {
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
				e.printStackTrace();
			}
		}
	}
}
public class clienttransfer {
	public ServerSocket ss;
	int i=0;
	private acc s1;
	public JFrame jFrame;
    clienttransfer() {
    	
        
        File[] fileToSend = new File[100];


        jFrame = new JFrame("Uploader");
        jFrame.setBackground(Color.CYAN);
        jFrame.setSize(450, 450);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JLabel jlTitle = new JLabel("File Transfer");
        jlTitle.setFont(new Font("Arial", Font.BOLD, 25));
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        final JLabel jlFileName = new JLabel("Choose a file to send..");
        jlFileName.setFont(new Font("Arial", Font.BOLD, 20));
        jlFileName.setBorder(new EmptyBorder(50, 0, 0, 0));
        jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JPanel jpButton = new JPanel();
        jpButton.setBorder(new EmptyBorder(75, 0, 10, 0));
        JButton jbSendFile = new JButton("Send File");

        jbSendFile.setBackground(Color.PINK);
        jbSendFile.setPreferredSize(new Dimension(150, 50));
        jbSendFile.setFont(new Font("Arial", Font.BOLD, 20));
        JButton jbChooseFile = new JButton("Choose File");
        jbChooseFile.setBackground(Color.PINK);
  
        jbChooseFile.setPreferredSize(new Dimension(150, 50));
        jbChooseFile.setFont(new Font("Arial", Font.BOLD, 20));

        
        jpButton.add(jbSendFile);
        jpButton.add(jbChooseFile);

        
        jbChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("Choose a file to send.");
                if (jFileChooser.showOpenDialog(null)  == JFileChooser.APPROVE_OPTION) {
                    fileToSend[i] = jFileChooser.getSelectedFile();
                    jlFileName.setText("The file you want to send is: " + fileToSend[i].getName());
                    i+=1;
                    if (i==100) {
                    	i=0;
                    }
                }
            }
        });
        try {
        ss = new ServerSocket(1235);
        ss.setReuseAddress(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        s1=new acc(ss);
        Thread t1=new Thread(s1);
        t1.start();
        jbSendFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileToSend[0] == null) {
                    jlFileName.setText("Please choose a file to send first!");
                } else {
                        Serv m=new Serv(fileToSend,i,s1.socket,s1.k);
                        Thread t=new Thread(m);
                        t.start();
              }
            }
        });
        
        

        jFrame.add(jlTitle);
        jFrame.add(jlFileName);
        jFrame.add(jpButton);
        jFrame.setVisible(true);
    }
    protected void servertransfer() {
		
		
	}
	public static void main(String [] args)
    {
    	new clienttransfer();
    }

}