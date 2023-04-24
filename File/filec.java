import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
public class filec{
public static void main(String args[])throws Exception{
Socket socket=new Socket(InetAddress.getByName("localhost"),5000);
byte[]Contents=new byte[10000];
FileOutputStream FOS=new FileOutputStream("e:\\echos.java");
BufferedOutputStream bos=new BufferedOutputStream(FOS);
InputStream is=socket.getInputStream();
int bytesRead=0;
while((bytesRead=is.read(Contents))!=-1)
bos.flush();
socket.close();
System.out.println("File saved successfully!");
}}
