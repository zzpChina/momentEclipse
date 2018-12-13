package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dBCPUtlils.DBCPUtils;
import model.User;

/**
 * 用户操作类
 * @author zzpComputer
 *
 */
public class UserDao {
	
	//查询用户
	public static User findUserByUnameAndPassword(String uname,String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBCPUtils.getConn();
			String sql="select * from user where uname=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBCPUtils.closeAll(conn, ps, rs);
		}
		return null;
	}
	
	//查询用户(用户名)
		public static User findUserByUname(String uname) {
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try {
				conn=DBCPUtils.getConn();
				String sql="select * from user where uname=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uname);
				rs=ps.executeQuery();
				while(rs.next()) {
					return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				DBCPUtils.closeAll(conn, ps, rs);
			}
			return null;
		}
	
	//增加用户
	public static boolean insertUser(String uname,String pwd,String sex) {
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try {
			conn=DBCPUtils.getConn();
			String sql="insert into user(head,uname,password,sex) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "img/head1.png");
			ps.setString(2, uname);
			ps.setString(3, pwd);
			ps.setString(4, sex);
			int num=ps.executeUpdate();
			if(num>0) {
				System.out.println(uname);
				MoodDao.setNewCoustomerMoods(uname);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}finally {
			DBCPUtils.closeAll(conn, ps);
		}
		return false;
		
	}

}
