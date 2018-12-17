package dBCPUtlils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * DBCP工具类
 * 
 * @author zzpComputer
 *
 */
public class DBCPUtils {
	// 创DBCP数据源
	private static DataSource ds = null;
	static {
		try {
			Properties pro = new Properties();
			InputStream in = new DBCPUtils().getClass().getClassLoader().getResourceAsStream("dp.properties");
			pro.load(in);
			// 数据源
			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeAll(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
