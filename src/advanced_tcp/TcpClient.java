package advanced_tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	
	public TcpClient() throws UnknownHostException, IOException {
		// specify the server address and a port number
		Socket skt = new Socket("localhost",9088);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(skt.getOutputStream()), true);
		
		System.out.println("Server says: " + in.readLine());
		out.println("Hi server");
		
		in.close();
		out.close();
		skt.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new TcpClient();
		} catch(UnknownHostException ue) {
			ue.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}

}
