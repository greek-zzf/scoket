package server;

import java.io.ObjectInputStream;
import java.net.Socket;

import tool.Message;

public class SeverThread extends Thread {
	private Socket s = null;
	private ObjectInputStream ois;
	public SeverThread(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			Thread.sleep(2000);
			ois = new ObjectInputStream(s.getInputStream());		
			while(true) {
				Message ms=(Message)ois.readObject();
				//在数据库中插入监控的机器发来的消息
				new DataBase().insertStatement(ms.getNo(), ms.getCPU(),
						ms.getDelay(),ms.getState(),ms.getTime());
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("与客户端连接已断开");
		}finally {
			try {
				if(ois!=null)
					ois.close();
				if(s!=null)
					s.close();				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
