package fuwuqi;

import javax.swing.*;
import java.awt.*;

public class MyEditor extends DefaultCellEditor {
	public MyEditor() {
		super(new JTextField());
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
												 int row, int column) {
		//获得默认表格单元格控件
		JTextField editor = (JTextField) super.getTableCellEditorComponent(table, value, isSelected,
				row, column);
		editor.setHorizontalAlignment(JLabel.CENTER);
		return editor;
	}
}
