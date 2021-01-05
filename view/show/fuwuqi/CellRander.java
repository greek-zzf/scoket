package fuwuqi;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CellRander implements TableCellRenderer {
	/**
	 * ���ñ���ĳһ�еı���ɫ
	 * @param table
	 */
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	public CellRander() {
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = dtcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		int rowCount = table.getRowCount();
		ArrayList<ArrayList<Integer>> index = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lh = new ArrayList<Integer>();
		ArrayList<Integer> yj = new ArrayList<Integer>();
		ArrayList<Integer> zs = new ArrayList<Integer>();
		for(int i=0;i<rowCount;i++) {
				String value1 = (String) table.getValueAt(i, 3);      //��ȡ�豸��״̬����
				if(value1.equals("��������")) {
					lh.add(i);                          //�õ��к�
				}else if(value1.equals("����ӵ��")) {
					yj.add(i);                          //�õ��к�
				}else {
					zs.add(i);
				}
			}
		index.add(lh);
		index.add(yj);
		index.add(zs);
		renderer.setBackground(new Color(192,192,192));
		renderer.setForeground(Color.BLACK);
		int len1 = index.size();
		for(int i =0;i<len1;i++) {
			int len2 = index.get(i).size();											//�޸�
				for(int j=0;j<len2;j++)
				if (i==0 && row == index.get(0).get(j)) {
					renderer.setBackground(new Color(192,192,192));
					renderer.setForeground(Color.green);
				}
				else if (i==1 && row == index.get(1).get(j)) {
					renderer.setBackground(new Color(192,192,192));
					renderer.setForeground(new Color(238,130,238));
				}
				else if (i==2 && row == index.get(2).get(j)) {
					renderer.setBackground(new Color(192,192,192));
					renderer.setForeground(Color.RED);
				}
		}
		return renderer;
	}

}
