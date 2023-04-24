import java.io.*;
import java.net.*;
public class dnsserver
{
private static int indexof(String[] array,String str)
{
str=str.trim();
for(int i=0;i<array.length;i++)
{
if(array[i].equals(str))
return i;
}return -1;
}
public static void main(String[] args) throws Exception
{
String[] hosts={"zoho.com","gmail.com","google.com","faceBook.com","instagram.com"};
String[] ip={"172.28.251.59","172.217.11.5","172.217.11.4","31.13.71.36","157.240.208.174"};
System.out.println("press ctrl +c to quit");
while(true)
{
DatagramSocket ServerSocket=new DatagramSocket(1362);
byte[] senddata=new byte[1021];
byte[] receivedata=new byte[1021];
DatagramPacket recvpack=new DatagramPacket(receivedata,receivedata.length);
ServerSocket.receive(recvpack);
String sen=new String(recvpack.getData());
InetAddress ipaddress=recvpack.getAddress();
int port=recvpack.getPort();
String capsent;
System.out.println("request for host"+sen);
if(indexof(hosts,sen)!=-1)
capsent=ip[indexof(hosts,sen)];
else
capsent="Host Not Found";
senddata=capsent.getBytes();
DatagramPacket pack=new DatagramPacket(senddata,senddata.length,ipaddress,port);
ServerSocket.send(pack);
ServerSocket.close();
}
}
}

