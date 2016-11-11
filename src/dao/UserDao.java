package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import util.UserCon;

public class UserDao {
	
	//用户退出方法
	public boolean userExist(String username) {
		//获取数据库连接Connection对象
		Connection conn = UserCon.getConnection();
		String sql = "select id,username,password,gender,tel,photo,email from model2_5_5 where username=?";
		
		
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = conn.prepareStatement(sql);
			//对用户对象赋值
			ps.setString(1, username);
			//执行查询结果集
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				//如果无效则证明用户名可用
				return true;
			}
			//释放ResultSet对象的数据库和jdbc资源
			rs.close();
			//释放PreparedStatement对象和jdbc资源
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			UserCon.closeConnection(conn);
		}
		return false;
		
	}
	
	//保存用户方法
	public void saveUser(User user) {
		//获取数据库连接Connection对象
				Connection conn = UserCon.getConnection();
				String sql = "insert into model2_5_5(id,username,password,gender,tel,photo,email) value=(?,?,?,?,?,?)";
				
				try {
					//获取PreparedStatement对象
					PreparedStatement ps = conn.prepareStatement(sql);
					//对sql语句的占位符参数进行动态赋值
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getGender());
					ps.setString(4, user.getTel());
					ps.setString(5, user.getPhoto());
					ps.setString(6, user.getEmail());
					
					//执行更新操作
					ps.executeUpdate();
					//释放PreparedStatement对象和jdbc资源
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					UserCon.closeConnection(conn);
				}
	}
	
	//用户注册方法
	public User login(String username,String password) {
		User user = null;
		//获取数据库连接Connection对象
		Connection conn = UserCon.getConnection();
		String sql = "select id,username,password,gender,tel,photo,email from model2_5_5 where username=? and password=?";
				
				
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = conn.prepareStatement(sql);
			//对sql语句的占位符参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, password);
			//执行查询结果集
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				//实例化一个对象
				user = new User();
				//对用户对象属性赋值
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
			}
			//释放ResultSet对象的数据库和jdbc资源
			rs.close();
			//释放PreparedStatement对象和jdbc资源
			ps.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}finally {
				UserCon.closeConnection(conn);
			}
		return user;
	}
}
