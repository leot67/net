import java.util.*;
import java.net.*;
import java.io.*;

public class HTTP {
	public static void main(String args[]) {
		try {
			Socket sckt = new Socket("www.sunnetwork.in", 80);
			PrintWriter s_out = new PrintWriter(sckt.getOutputStream(), true);
			BufferedReader s_in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
			s_out.println("GET / HTTP/1.1\r\nHost: www.sunnetwork.in\r\n\r\n");
			String input;
			while ((input = s_in.readLine()) != null) {
				System.out.println(input);
			}
			s_out.close();
			sckt.close();
		} catch(Exception e) {
			System.err.println("Error in code!!");
		}
	}
}
