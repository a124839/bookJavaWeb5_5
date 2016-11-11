package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 570
 *
 */
public class UserCon {
	//获得数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_java_web?characterEncoding=utf8&useSSL=true","root","root");
			//String sql = "select id,username,password,gender,tel,photo,email from model2_5_5 ";
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库连接
	public static void closeConnection(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
