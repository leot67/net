import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class files{
public static void main(String args[])throws Exception{
ServerSocket SSock=new ServerSocket(5000);
Socket socket=SSock.accept();
InetAddress IA=InetAddress.getByName("localhost");
File File=new File("e:\\echos.java");
FileInputStream Fis=new FileInputStream(File);
BufferedInputStream bis=new BufferedInputStream(Fis);
OutputStream OS=socket.getOutputStream();
byte[]contents;
long FileLength=File.length();
long Current=0;
long start=System.nanoTime();
while(Current!=FileLength){
int size=10000;
if(FileLength-Current>=size)
Current+=size;
else{
size=(int)(FileLength-Current);
Current=FileLength;
}
contents=new byte[size];
bis.read(contents,0,size);
OS.write(contents);
System.out.println("Sending File...."+(Current*100)/FileLength+"%Complete!");}
OS.flush();
socket.close();
SSock.close();
System.out.println("File sent successfully!");}}
