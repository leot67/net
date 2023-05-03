import java.io.*;
import java.net.*;
import java.util.*;
class Client
{
public static void main(String args[])
{
try
{
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
Socket sckt=new Socket("127.0.0.1",5604);
DataInputStream din=new DataInputStream(sckt.getInputStream());
DataOutputStream dout=new DataOutputStream(sckt.getOutputStream());
System.out.println("Enter the Logical address(IP):");
String str1=in.readLine();
dout.writeBytes(str1+'\n');
String str=din.readLine();
System.out.println("The Physical Address is: "+str);
sckt.close();
}
catch (Exception e)
{
System.out.println(e);
}
}
}
