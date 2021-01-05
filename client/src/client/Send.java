package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import tool.Message;

public class Send implements Runnable {
	
	private Socket s;
	private ObjectOutputStream oos;
	private String no;
	private String time;
	private String state;
	private String delay;
	private String CPU;
	private Random rand;

	public Send(Socket s) throws IOException {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
			//��ʼ���豸���
			int i;
			rand = new Random();
			no = "A" +rand.nextInt(100);
			while(true) {
				
				i = rand.nextInt(200);
				if(i<65) {
					state = "��������";
				}else if(i<135) {
					state = "����ӵ��";
				}else {
					state = "��������";
				}
				delay = i+"ms";
				CPU = rand.nextInt(90)+"%";
				time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());   //Ҫ�޸ĵĴ���
				Message content = new Message(no, time,state,delay,CPU);
				oos.writeObject(content);
				//�豸10s ����һ�����ݸ�������
				Thread.sleep(10000);
			
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("��������Ѿ��Ͽ�");
		}finally {
			try {
				if (oos != null)
					oos.close();
				if (s != null)
					s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
