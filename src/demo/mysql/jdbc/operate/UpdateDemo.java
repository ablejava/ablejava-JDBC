package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import demo.mysql.entity.Student;
import demo.mysql.testByDataSource.MysqlDatasourceFactory;

/**
 * 更新学员信息
 * @author 北大青鸟
 *
 */
public class UpdateDemo  extends MysqlDatasourceFactory {
	public void updateStudent(Student stu){
		Connection con = openConnection();
		String sql = "update student set phone = " + stu.getPhone() + " where studentNo = " + stu.getStudentNo();
		try {
			Statement st = con.createStatement();//获得Statement对象
			int count = st.executeUpdate(sql);//执行sql并获得更新条数
			System.out.println(count + "条信息已被更新");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String args[]) throws ParseException{
		UpdateDemo updateDemo = new UpdateDemo();
		Student stu = new Student(); 
		stu.setStudentNo(1017);	//假设存在学生编号为： 1017  的记录
		stu.setPhone("13866667777");
		updateDemo.updateStudent(stu);
	}
}
