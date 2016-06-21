package demo.mysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import demo.mysql.util.ConfigManager;



public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected Statement stmt;
	protected ResultSet rs;

	// 获取数据库链接
	public boolean getConnection() {
		String driver = ConfigManager.getInstance().getString("jdbc.driver_class");
		String url = ConfigManager.getInstance().getString("jdbc.connection.url");
		String username = ConfigManager.getInstance().getString("jdbc.connection.username");
		String password = ConfigManager.getInstance().getString("jdbc.connection.password");
		try {
			// (1).Class.forName()加载驱动
			Class.forName(driver);
			// (2).DriverManager.getConnection(数据库url,用户名,密码);onnection1521
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Connection getConnection2(){
		try {
			//初始话上下文
			Context cxt=new InitialContext();
			//获取与逻辑名相关联的数据源对象
			DataSource ds=(DataSource)cxt.lookup("java:comp/env/jdbc/orcl");
			conn=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 增删改
	public int executeUpdate(String sql, Object[] params) {
		int updateRows = 0;
		getConnection();
		try {
			ps=conn.prepareStatement(sql);
			//填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			updateRows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	// 查询
	public ResultSet executeSQL(String sql, Object[] params) {
		try {
			getConnection();
			ps=conn.prepareStatement(sql);
			//填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 关闭资源
	public boolean closeResource() {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
