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
			//初始化设备编号
			int i;
			rand = new Random();
			no = "A" +rand.nextInt(100);
			while(true) {
				
				i = rand.nextInt(200);
				if(i<65) {
					state = "网络良好";
				}else if(i<135) {
					state = "网络拥挤";
				}else {
					state = "网络阻塞";
				}
				delay = i+"ms";
				CPU = rand.nextInt(90)+"%";
				time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());   //要修改的代码
				Message content = new Message(no, time,state,delay,CPU);
				oos.writeObject(content);
				//设备10s 发送一次数据给服务器
				Thread.sleep(10000);
			
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("与服务器已经断开");
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
