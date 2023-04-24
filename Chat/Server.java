import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		String buffer, res;
		try {
			ServerSocket srv = new ServerSocket(8080);
			Scanner s = new Scanner(System.in);
			Socket sckt = srv.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
			PrintWriter out = new PrintWriter(sckt.getOutputStream(), true);
			while ((res = in.readLine()) != null) {
				System.out.println("Client Response: " + res);
				System.out.print("Enter message: ");
				buffer = s.nextLine();
				out.println(buffer);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
