package fuwuqi;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;

public class RefreshData extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<String> columnName;
	private Vector<Vector<String>> tableData;
	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet result = null;
	
	public RefreshData() {
		this.connect();
	}
	@Override
	public int getRowCount() {
		return this.tableData.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return (this.tableData.get(rowIndex)).get(columnIndex);    //有改动
	}
	
	public String getColumnName(int index) {
		return (String)this.columnName.get(index);
	}
	
	public void connect() {
		//列名
		columnName = new Vector<String>();
		columnName.add("设备编号");
		columnName.add("CPU使用率");
		columnName.add("网络延时");
		columnName.add("网络状态");
		columnName.add("发送时间");
		tableData = new Vector<Vector<String>>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?"
					+ "serverTimezone=UTC","root","LAM0613lam");//改成自己的密码
			ps = conn.prepareStatement("select * from message");
			result = ps.executeQuery();
			result.last();
			while(result.previous()) {
				Vector<String> row  =new Vector<String>();
				row.add(result.getString(1));
				row.add(result.getString(2));
				row.add(result.getString(3));
				row.add(result.getString(4));
				row.add(result.getString(5));
				tableData.add(row);
			}
			
		}catch(Exception e){
			//TODO
		}finally {
			
				try {
					if(result!=null)
						result.close();
					if(ps!=null)
						ps.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
