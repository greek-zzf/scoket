package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Start {

	JFrame f;
	JButton start,end;
	JPanel panel;
	public void init() {
		f = new JFrame("设备");

		start = new JButton("开机");
		start.setBackground(Color.WHITE);

		end = new JButton("关机");
		end.setBackground(Color.WHITE);

		panel  = new JPanel();
		panel.setLayout(new FlowLayout(1,10,30));
		start.setPreferredSize(new Dimension(150,50));
		end.setPreferredSize(new Dimension(150,50));
		panel.add(start);
		panel.add(end);
		panel.setBackground(Color.BLACK);
		f.setSize(400, 150);
		f.add(panel);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocation(300, 150);
		f.setDefaultCloseOperation(0);

		ActionListener btnListener = e->{
			try {
				if(e.getActionCommand()=="开机") {
					//	start.setEnabled(false);
					new Client();
					start.setEnabled(false);
				}else {
					System.exit(0);
				}
			}catch(Exception e1) {

			}
		};
		start.addActionListener(btnListener);
		end.addActionListener(btnListener);
	}

	public static void main(String[] args) {
		new Start().init();

	}
}