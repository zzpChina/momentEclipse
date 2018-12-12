package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dBCPUtlils.DBCPUtils;
import model.User;

/**
 * 朋友圈数据操作类
 * @author zzpComputer
 *
 */
public class MoodDao {
	//获取动态
	public static String getMoods(String uname) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBCPUtils.getConn();
			String sql="select pyqMood from usermood where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getString("pyqMood");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.closeAll(conn,ps,rs);
		}
		return "";
	}
	//通过群组获取
	public static List<User> getUsersByGroup(String groupNum) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<>();
		
		try {
			conn=DBCPUtils.getConn();
			String sql="select uname from usermood where groupNum=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, groupNum);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(UserDao.findUserByUname(rs.getString("uname")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.closeAll(conn,ps,rs);
		}
		return list;
	}
	//插入动态
		public static boolean setNewCoustomerMoods(String uname) {
			Connection conn=null;
			PreparedStatement ps=null;
			
			try {
				conn=DBCPUtils.getConn();
				String sql="insert into usermood(uname,pyqMood) values(?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, "");
				ps.setString(3, "");
				int updateNum=ps.executeUpdate();
				
				if(updateNum>0) {
					return true;
				}else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBCPUtils.closeAll(conn, ps);
			}
			return false;
			
		}
		//
		//私有修改动态
		public static boolean setMoods(String uname,String newMoods) {
			Connection conn=null;
			PreparedStatement ps=null;
			
			try {
				conn=DBCPUtils.getConn();
				String sql="update usermood set pyqMood=? where uname=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, newMoods);
				ps.setString(2, uname);
				int updateNum=ps.executeUpdate();
				
				if(updateNum>0) {
					return true;
				}else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBCPUtils.closeAll(conn, ps);
			}
			return false;
		}
		
		//群组修改动态
		public static boolean setMoods(String uname,String newMoods,String groupNum) {
			Connection conn=null;
			PreparedStatement ps=null;
			
			try {
				conn=DBCPUtils.getConn();
				String sql="update usermood set pyqMood=? where groupNum=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, newMoods);
				ps.setString(2, groupNum);
				int updateNum=ps.executeUpdate();
				
				if(updateNum>0) {
					return true;
				}else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBCPUtils.closeAll(conn, ps);
			}
			return false;
		}
		public static String getGroupNum(String uname) {
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try {
				conn=DBCPUtils.getConn();
				String sql="select groupNum from usermood where uname=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uname);
				rs=ps.executeQuery();
				while(rs.next()) {
					return rs.getString("groupNum").trim();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBCPUtils.closeAll(conn, ps, rs);
			}
			return "";
		}
}
