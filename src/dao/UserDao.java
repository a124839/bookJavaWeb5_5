package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import util.UserCon;

public class UserDao {
	
	//�û��˳�����
	public boolean userExist(String username) {
		//��ȡ���ݿ�����Connection����
		Connection conn = UserCon.getConnection();
		String sql = "select id,username,password,gender,tel,photo,email from model2_5_5 where username=?";
		
		
		try {
			//��ȡPreparedStatement����
			PreparedStatement ps = conn.prepareStatement(sql);
			//���û�����ֵ
			ps.setString(1, username);
			//ִ�в�ѯ�����
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				//�����Ч��֤���û�������
				return true;
			}
			//�ͷ�ResultSet��������ݿ��jdbc��Դ
			rs.close();
			//�ͷ�PreparedStatement�����jdbc��Դ
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			UserCon.closeConnection(conn);
		}
		return false;
		
	}
	
	//�����û�����
	public void saveUser(User user) {
		//��ȡ���ݿ�����Connection����
				Connection conn = UserCon.getConnection();
				String sql = "insert into model2_5_5(id,username,password,gender,tel,photo,email) value=(?,?,?,?,?,?)";
				
				try {
					//��ȡPreparedStatement����
					PreparedStatement ps = conn.prepareStatement(sql);
					//��sql����ռλ���������ж�̬��ֵ
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getGender());
					ps.setString(4, user.getTel());
					ps.setString(5, user.getPhoto());
					ps.setString(6, user.getEmail());
					
					//ִ�и��²���
					ps.executeUpdate();
					//�ͷ�PreparedStatement�����jdbc��Դ
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					UserCon.closeConnection(conn);
				}
	}
	
	//�û�ע�᷽��
	public User login(String username,String password) {
		User user = null;
		//��ȡ���ݿ�����Connection����
		Connection conn = UserCon.getConnection();
		String sql = "select id,username,password,gender,tel,photo,email from model2_5_5 where username=? and password=?";
				
				
		try {
			//��ȡPreparedStatement����
			PreparedStatement ps = conn.prepareStatement(sql);
			//��sql����ռλ���������ж�̬��ֵ
			ps.setString(1, username);
			ps.setString(2, password);
			//ִ�в�ѯ�����
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				//ʵ����һ������
				user = new User();
				//���û��������Ը�ֵ
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
			}
			//�ͷ�ResultSet��������ݿ��jdbc��Դ
			rs.close();
			//�ͷ�PreparedStatement�����jdbc��Դ
			ps.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}finally {
				UserCon.closeConnection(conn);
			}
		return user;
	}
}
