package chatserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class clienttransfer {

    clienttransfer() {

        
        final File[] fileToSend = new File[1];


        JFrame jFrame = new JFrame("Client");
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
        
        JButton jbDownloadFile = new JButton("Download File");
		jbDownloadFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new servertransfer();
			}
		});
        jbDownloadFile.setBackground(Color.PINK);
        jbDownloadFile.setPreferredSize(new Dimension(180, 50));
        jbDownloadFile.setFont(new Font("Arial", Font.BOLD, 20));

        
        jpButton.add(jbSendFile);
        jpButton.add(jbChooseFile);
        jpButton.add(jbDownloadFile);

        
        jbChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("Choose a file to send.");
                if (jFileChooser.showOpenDialog(null)  == JFileChooser.APPROVE_OPTION) {
                    fileToSend[0] = jFileChooser.getSelectedFile();
                    jlFileName.setText("The file you want to send is: " + fileToSend[0].getName());
                }
            }
        });


        
        jbSendFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileToSend[0] == null) {
                    jlFileName.setText("Please choose a file to send first!");
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());
                        Socket socket = new Socket("localhost", 1235);
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        String fileName = fileToSend[0].getName();
                        byte[] fileNameBytes = fileName.getBytes();
                        byte[] fileBytes = new byte[(int)fileToSend[0].length()];
                        fileInputStream.read(fileBytes);
                        dataOutputStream.writeInt(fileNameBytes.length);
                        dataOutputStream.write(fileNameBytes);
                        dataOutputStream.writeInt(fileBytes.length);
                        dataOutputStream.write(fileBytes);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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