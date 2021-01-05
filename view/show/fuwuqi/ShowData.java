package fuwuqi;

import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ShowData extends JFrame {
	private static JTable table;
	private JScrollPane scrollPane;
	private RefreshData rd;
	CellRander dctr= new CellRander( );
	
	public ShowData() {
		rd = new RefreshData();
		table = new JTable(rd);
		//���ñ����ʽ
//		table.setDefaultEditor(Object.class, new MyEditor());     //��䲻�����ò�֪��Ϊʲô
		table.setDefaultRenderer(Object.class, dctr);
		table.setRowHeight(30);
		table.setFont(new Font("Menu.font", Font.BOLD, 15));
		scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new EmptyBorder(5,5,5,5));
		this.add(scrollPane);
		this.setSize(800, 600);
		this.setLocation(300, 150);
	//	this.pack();
		this.setTitle("���ϵͳ");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//��������
	public void refresh() {
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rd = new RefreshData();
			table.setModel(rd);
//			table.setDefaultRenderer(Object.class, dctr);
		}
	}
	public static void main(String[] args) {
		ShowData sd =  new ShowData();
		sd.refresh();		
	}
}
