package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import demo.mysql.testByDataSource.MysqlDatasourceFactory;

public class DeleteDemo extends MysqlDatasourceFactory{

	public void deleteStudent(int studentNO){
		Connection con = openConnection(); 
		String sql = "delete from student " + " where studentNo = " + studentNO; 
		try {
			//获得Statement对象
			Statement st = con.createStatement();
			//执行sql并获得更新条数
			int count = st.executeUpdate(sql);
			System.out.println(count + "条信息已被删除");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	public static void main(String args[]) throws ParseException{
		DeleteDemo deleteDemo = new DeleteDemo();//实例化本类
		////这里假设存在学生编号为： 2529  的记录
		deleteDemo.deleteStudent(2529);
	}
}
