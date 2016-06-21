package demo.mysql.testByDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Test {

	public static void main(String[] args) {
		try {
			MysqlDatasourceFactory m=new MysqlDatasourceFactory();
			System.out.println(m.openConnection());
			// 建立连接
			Connection conn = m.openConnection();
			String sql = "select * from emp";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 int empno = rs.getInt("EMPNO");
				 String ename = rs.getString("ENAME");
				 String job = rs.getString("JOB");
				 int mgr = rs.getInt("MGR");
				 Timestamp time = rs.getTimestamp("HIREDATE");
				 int sal = rs.getInt("SAL");
				 double comm = rs.getInt("COMM");
				 int deptno = rs.getInt("DEPTNO");
				 System.out.println(empno + "\t" + ename + "\t" + job + "\t"
							+ mgr + "\t" + time + "\t" + sal + "\t" + comm + "\t"
							+ deptno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
