package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 */
public class Server {
	public Server(){
		try {
			ServerSocket ss = new ServerSocket(29999);
			while(true) {
				Socket s = ss.accept();
				new SeverThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
//		new Server();
	}
}
