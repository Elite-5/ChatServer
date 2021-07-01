//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.
// for recieving file from server.

package Cygnus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class servertransfer {
    static ArrayList<MyFile> myFiles = new ArrayList<>();//all files recieved stored in array.
	public JFrame jFrame;
   @SuppressWarnings("resource")
servertransfer(String id,int ch){
	   try
	   {
        int fileId = 0;
        jFrame = new JFrame("Server");//window for recieving file.
        jFrame.setResizable(false);
        jFrame.setBackground(Color.CYAN);
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setBounds(0, 59, 382, 294);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jFrame.getContentPane().setLayout(null);


        JLabel jlTitle = new JLabel("File Receiver...");//title for recieving.
        jlTitle.setForeground(Color.WHITE);
        jlTitle.setBounds(88, 0, 217, 59);
        jlTitle.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 30));
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jFrame.getContentPane().add(jlTitle);
        jFrame.getContentPane().add(jScrollPane);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("fit.jpg"));//image for background.
        label.setBounds(0, 0, 382, 59);
        jFrame.getContentPane().add(label);
        jFrame.setVisible(true);
        Socket socket;
        if(ch==1) {
        socket = new Socket(id,1235);}//socket for file sending for foram.
        else {
        socket = new Socket(id,1234);//socket for file transfer of private chat.
        }
        while (true) {//for continuously recieving file.
            try {
            	DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                int fileNameLength = dataInputStream.readInt();
              if (fileNameLength > 0) {
                    byte[] fileNameBytes = new byte[fileNameLength];
                    dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length);
                    String fileName = new String(fileNameBytes);
                    int fileContentLength = dataInputStream.readInt();
                    if (fileContentLength > 0) {
                        byte[] fileContentBytes = new byte[fileContentLength];
                        dataInputStream.readFully(fileContentBytes, 0, fileContentBytes.length);
                   
                        JPanel jpFileRow = new JPanel();
                        jpFileRow.setLayout(new BoxLayout(jpFileRow, BoxLayout.X_AXIS));
                        JLabel jlFileName = new JLabel(fileName);
                        jlFileName.setFont(new Font("Arial", Font.BOLD, 20));
                        jlFileName.setBorder(new EmptyBorder(10,0, 10,0));
                        if (getFileExtension(fileName).equalsIgnoreCase("txt")) {
                            jpFileRow.setName((String.valueOf(fileId)));
                            jpFileRow.addMouseListener(getMyMouseListener());
                            jpFileRow.add(jlFileName);
                            jPanel.add(jpFileRow);
                            jFrame.validate();
                        } else {
                            jpFileRow.setName((String.valueOf(fileId)));
                            jpFileRow.addMouseListener(getMyMouseListener());
                            jpFileRow.add(jlFileName);
                            jPanel.add(jpFileRow);
                            jFrame.validate();
                        }

                        myFiles.add(new MyFile(fileId, fileName, fileContentBytes, getFileExtension(fileName)));//adding files in array. 
                        fileId++;
                       
                    }
                    
                    
                }
        
            } catch (IOException e) {
            }
        }
	   }
	   catch(Exception exe) {
	   }
	   
    }

  
    public static String getFileExtension(String fileName) {//for extension of file.
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            return fileName.substring(i + 1);
        } else {
            return "No extension found.";
        }
    }
    public static MouseListener getMyMouseListener() {//checking where is mouse pointer to click.
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel jPanel = (JPanel) e.getSource();
                int fileId = Integer.parseInt(jPanel.getName());
                for (MyFile myFile : myFiles) {
                    if (myFile.getId() == fileId) {
                        JFrame jfPreview = createFrame(myFile.getName(), myFile.getData(), myFile.getFileExtension());//file downloader.
                        jfPreview.setVisible(true);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {//method overridden.

            }

            @Override
            public void mouseReleased(MouseEvent e) {//method overridden.

            }

            @Override
            public void mouseEntered(MouseEvent e) {//method overridden.

            }

            @Override
            public void mouseExited(MouseEvent e) {//method overridden.

            }
        };
    }

    public static JFrame createFrame(final String fileName, final byte[] fileData, String fileExtension) {//window for file downloader.

        final JFrame jFrame = new JFrame("File Downloader");
        jFrame.setSize(400, 400);
        jFrame.setResizable(false);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));


        JLabel jlTitle = new JLabel("File Downloader");
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlTitle.setFont(new Font("Arial", Font.BOLD, 25));
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));

        JLabel jlPrompt = new JLabel("Are you sure you want to download " + fileName + "?");//name of file that is downloaded.
        jlPrompt.setFont(new Font("Arial", Font.BOLD, 20));
        jlPrompt.setBorder(new EmptyBorder(20,0,10,0));
        jlPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jbYes = new JButton("Yes");
        jbYes.setPreferredSize(new Dimension(150, 75));
        jbYes.setFont(new Font("Arial", Font.BOLD, 20));


        JButton jbNo = new JButton("No");
        jbNo.setPreferredSize(new Dimension(150, 75));
        jbNo.setFont(new Font("Arial", Font.BOLD, 20));


        JLabel jlFileContent = new JLabel();
        jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel jpButtons = new JPanel();
        jpButtons.setBorder(new EmptyBorder(20, 0, 10, 0));
        jpButtons.add(jbYes);
        jpButtons.add(jbNo);

        if (fileExtension.equalsIgnoreCase("txt")) {//checking if it is text file or not.
            jlFileContent.setText("<html>" + new String(fileData) + "</html>");
        } else {
            jlFileContent.setIcon(new ImageIcon(fileData));
        }


        jbYes.addActionListener(new ActionListener() {//for downloading.
            private String str;

			@Override
            public void actionPerformed(ActionEvent e) {//finding path of Downloads in device and doing so.
            	try {
					ProcessBuilder b=new ProcessBuilder("cmd.exe","/c","echo %CD%");
					b.redirectErrorStream(true);
					Process p=b.start();
					BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					
					str=br.readLine();
					str=str.substring(0,str.indexOf("eclipse"));
					str+="Downloads";
					}
					catch(Exception ee){}
                File fileToDownload = new File(str+"\\"+fileName);//saving file.
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileToDownload);
                    fileOutputStream.write(fileData);
                    fileOutputStream.close();
                    jFrame.dispose();
                } catch (IOException ex) {
                }

            }
        });

        
        jbNo.addActionListener(new ActionListener() {//for not downloading.
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });

        jPanel.add(jlTitle);
        jPanel.add(jlPrompt);
        jPanel.add(jlFileContent);
        jPanel.add(jpButtons);
        jFrame.getContentPane().add(jPanel);
        return jFrame;//returning window.

    }
    
}
