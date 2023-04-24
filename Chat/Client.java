import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		String buffer, res;
		try {
			Socket sckt = new Socket(InetAddress.getLocalHost(), 8080);
			Scanner s = new Scanner(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
			PrintWriter out = new PrintWriter(sckt.getOutputStream(), true);
			System.out.print("Enter message: ");
			buffer = s.nextLine();
			out.println(buffer);
			while ((res = in.readLine()) != null) {
				System.out.println("Response: " + res);
				System.out.print("Enter message: ");
				buffer = s.nextLine();
				out.println(buffer);
			}
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
