package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;



import demo.mysql.entity.Student;
import demo.mysql.testByDataSource.MysqlDatasourceFactory;
/**
 * 插入学员信息
 * @author 北大青鸟
 *
 */
public class InsertDemo extends MysqlDatasourceFactory {

	public void addStudent(Student stu){
		Connection con = openConnection();
		//使用问号占位符编写SQL
		String sql = "INSERT INTO `student` " +
				"(`StudentNo`, `LoginPwd`, `StudentName`, `Sex`, `GradeId`, `Phone`, `Address`, `BornDate`, `Email`, `IdentityCard`) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO student " +
				"(StudentNo, LoginPwd, StudentName, Sex, GradeId, Phone, Address,"
				+ " BornDate, Email, IdentityCard) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			//获得PrepareStatement对象
			ps = con.prepareStatement(sql2);
			//使用PreparedStatement对象，向Sql中的问号占位符填充数据
			ps.setInt(1, stu.getStudentNo());
			ps.setString(2, stu.getLoginPwd());
			ps.setString(3, stu.getStudentName());
			ps.setInt(4, stu.getSex());
			ps.setLong(5, stu.getGradeId());
			ps.setString(6, stu.getPhone());
			ps.setString(7, stu.getAddress());
			ps.setDate(8, stu.getDate());
			ps.setString(9, stu.getEmail());
			ps.setString(10, stu.getIdentityCard());
			//执行insert sql语句
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("如果是主键冲突，请重新执行程序，原因可能是由于产生的随机主键已经存在于学员表中");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws ParseException{
		InsertDemo insertDemo = new InsertDemo();
		Student stu = new Student();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String bornDate = "1984-2-27 00:00:00";
		// 这里随机生成了一个 1100 ~ 8899  的四位学生编号  
		stu.setStudentNo(new Random().nextInt(8899)+1100);
		stu.setLoginPwd("123456");
		stu.setStudentName("巧克利特");
		stu.setSex(2);
		stu.setGradeId(2L);
		stu.setPhone("13812341234");
		stu.setAddress("北京昌平");
		stu.setDate(new Date(sdf.parse(bornDate).getTime()));
		stu.setEmail("stu33@bdqn.com");
		stu.setIdentityCard("627088002234652");
		
		insertDemo.addStudent(stu);
	}
}
