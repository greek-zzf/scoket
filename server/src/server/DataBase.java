package server;

import java.sql.*;

public class DataBase {
	private String url;
	private String user;
	private String password;
	private String sql;
	Connection conn;
	PreparedStatement ppst;
	
	public void init() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		user = "root";
		password = "........";
		sql = "insert into message values(?,?,?,?,?)";
	}
	
	public void insertStatement(String no,String CPU,String delay,
			String state,String time) {
		try {
			this.init();
			conn = DriverManager.getConnection(url,user,password);
			ppst = conn.prepareStatement(sql);
			ppst.setString(1, no);
			ppst.setString(2, CPU);
			ppst.setString(3,delay);
			ppst.setString(4, state);
			ppst.setString(5, time);
			ppst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(ppst!=null) {
						ppst.close();
				}
			} catch(Exception e){
					e.printStackTrace();
				}
		}
	}
	
}
