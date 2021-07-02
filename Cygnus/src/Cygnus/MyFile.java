//BENNETT UNIVERSITY
//Elite-5
//Sanyam Bothra,Sneha Gupta,Ishita Goyal,Kshitij Gupta and Tanishq Agarwal.
//This class is a supplement of servertransfer class, used to store and access file.
package Cygnus;

public class MyFile {//class name.

    private int id;
    private String name;
    private byte[] data;
    private String fileExtension;

    public MyFile(int id, String name, byte[] data, String fileExtension) {//initialising variables.
        this.id = id;
        this.name = name;
        this.data = data;
        this.fileExtension = fileExtension;
    }

    public void setId(int id) {//setting is.
        this.id = id;
    }

    public void setName(String name) {//setting name.
        this.name = name;
    }

    public void setData(byte[] data) {//setting file in form of bytes.
        this.data = data;
    }

    public void setFileExtension(String fileExtension) {//setting file extension.
        this.fileExtension = fileExtension;
    }

    public int getId() {//getting id.
        return id;
    }

    public String getName() {//getting name.
        return name;
    }

    public byte[] getData() {//getting data in form of bytes.
        return data;
    }

    public String getFileExtension() {//getting file extension.
        return fileExtension;
    }
}
