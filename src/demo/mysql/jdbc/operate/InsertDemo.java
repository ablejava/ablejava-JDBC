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
 * ����ѧԱ��Ϣ
 * @author ��������
 *
 */
public class InsertDemo extends MysqlDatasourceFactory {

	public void addStudent(Student stu){
		Connection con = openConnection();
		//ʹ���ʺ�ռλ����дSQL
		String sql = "INSERT INTO `student` " +
				"(`StudentNo`, `LoginPwd`, `StudentName`, `Sex`, `GradeId`, `Phone`, `Address`, `BornDate`, `Email`, `IdentityCard`) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO student " +
				"(StudentNo, LoginPwd, StudentName, Sex, GradeId, Phone, Address,"
				+ " BornDate, Email, IdentityCard) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			//���PrepareStatement����
			ps = con.prepareStatement(sql2);
			//ʹ��PreparedStatement������Sql�е��ʺ�ռλ���������
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
			//ִ��insert sql���
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("�����������ͻ��������ִ�г���ԭ����������ڲ�������������Ѿ�������ѧԱ����");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws ParseException{
		InsertDemo insertDemo = new InsertDemo();
		Student stu = new Student();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String bornDate = "1984-2-27 00:00:00";
		// �������������һ�� 1100 ~ 8899  ����λѧ�����  
		stu.setStudentNo(new Random().nextInt(8899)+1100);
		stu.setLoginPwd("123456");
		stu.setStudentName("�ɿ�����");
		stu.setSex(2);
		stu.setGradeId(2L);
		stu.setPhone("13812341234");
		stu.setAddress("������ƽ");
		stu.setDate(new Date(sdf.parse(bornDate).getTime()));
		stu.setEmail("stu33@bdqn.com");
		stu.setIdentityCard("627088002234652");
		
		insertDemo.addStudent(stu);
	}
}
