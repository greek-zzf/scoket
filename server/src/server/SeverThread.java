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
				//�����ݿ��в����صĻ�����������Ϣ
				new DataBase().insertStatement(ms.getNo(), ms.getCPU(),
						ms.getDelay(),ms.getState(),ms.getTime());
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("��ͻ��������ѶϿ�");
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
