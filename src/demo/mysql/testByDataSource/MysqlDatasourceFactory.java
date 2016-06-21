package demo.mysql.testByDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatasourceFactory {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * 子类可以修改url、username以及pwd的值
	 */
	private String url ="jdbc:mysql://192.168.9.223:3306/test_2016?useUnicode=true&characterEncoding=utf-8";
	private String username = "root";
	private String pwd = "ablejava";
	
	protected Connection openConnection(){
		Connection con = null;
		try {
			//装载数据库驱动
			Class.forName(DRIVER);
			//建立数据库连接
			con = DriverManager.getConnection(url,username,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
