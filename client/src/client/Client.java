package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public Client() {
		Socket s;
		try {
			s = new Socket("127.0.0.1",29999);
			new Thread(new Send(s)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
	}
}
