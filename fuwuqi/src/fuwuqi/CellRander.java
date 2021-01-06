package fuwuqi;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class CellRander implements TableCellRenderer {
    /**
     * 设置表格的某一行的背景色
     *
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
        for (int i = 0; i < rowCount; i++) {
            String value1 = (String) table.getValueAt(i, 3);      //获取设备的状态数据
            if (value1.equals("网络良好")) {
                lh.add(i);                          //得到行号
            } else if (value1.equals("网络拥挤")) {
                yj.add(i);                          //得到行号
            } else {
                zs.add(i);
            }
        }
        index.add(lh);
        index.add(yj);
        index.add(zs);
        renderer.setBackground(new Color(192, 192, 192));
        renderer.setForeground(Color.BLACK);
        int len1 = index.size();
        for (int i = 0; i < len1; i++) {
            int len2 = index.get(i).size();                                            //修改
            for (int j = 0; j < len2; j++) {
                if (i == 0 && row == index.get(0).get(j)) {
                    renderer.setBackground(new Color(192, 192, 192));
                    renderer.setForeground(Color.green);
                } else if (i == 1 && row == index.get(1).get(j)) {
                    renderer.setBackground(new Color(192, 192, 192));
                    renderer.setForeground(new Color(238, 130, 238));
                } else if (i == 2 && row == index.get(2).get(j)) {
                    renderer.setBackground(new Color(192, 192, 192));
                    renderer.setForeground(Color.RED);
                }
            }
        }
        return renderer;
    }

}
