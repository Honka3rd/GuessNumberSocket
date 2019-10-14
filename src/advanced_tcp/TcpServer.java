package advanced_tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public TcpServer() throws IOException {
		
		// open a port
		ServerSocket serverSkt = new ServerSocket(9088);
		System.out.println("Waiting for connection");
		
		// accept: blocking method, Java waiting for an operation, like this connection
		// block all program until an operation is done
		Socket skt = serverSkt.accept();
		
		System.out.println("Client: " + skt.getInetAddress() + " is connected");
		
		// Buffer: eg client sends data to server
		// 1. client makes a full buffer
		// 2. server sends a acknowledgement
		// 3. after received the acknowledgement, clean the buffer and fill it again
		BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		// server cannot receive data until the buffer is full, flush means receive the data regardless it is full or not
		// Flush the last patch
		PrintWriter out = new PrintWriter(new OutputStreamWriter(skt.getOutputStream()), true);
		
		out.println("Hi clicent");
		System.out.println("Client says: "+in.readLine());
		
		skt.close();
		serverSkt.close();
	}
	

	public static void main(String[] args) {
		try {
			new TcpServer();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
