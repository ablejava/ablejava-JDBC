package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import demo.mysql.entity.Student;
import demo.mysql.testByDataSource.MysqlDatasourceFactory;

/**
 * ����ѧԱ��Ϣ
 * @author ��������
 *
 */
public class UpdateDemo  extends MysqlDatasourceFactory {
	public void updateStudent(Student stu){
		Connection con = openConnection();
		String sql = "update student set phone = " + stu.getPhone() + " where studentNo = " + stu.getStudentNo();
		try {
			Statement st = con.createStatement();//���Statement����
			int count = st.executeUpdate(sql);//ִ��sql����ø�������
			System.out.println(count + "����Ϣ�ѱ�����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String args[]) throws ParseException{
		UpdateDemo updateDemo = new UpdateDemo();
		Student stu = new Student(); 
		stu.setStudentNo(1017);	//�������ѧ�����Ϊ�� 1017  �ļ�¼
		stu.setPhone("13866667777");
		updateDemo.updateStudent(stu);
	}
}
