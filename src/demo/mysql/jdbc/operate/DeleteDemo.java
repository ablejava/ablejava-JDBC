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
			//���Statement����
			Statement st = con.createStatement();
			//ִ��sql����ø�������
			int count = st.executeUpdate(sql);
			System.out.println(count + "����Ϣ�ѱ�ɾ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	public static void main(String args[]) throws ParseException{
		DeleteDemo deleteDemo = new DeleteDemo();//ʵ��������
		////����������ѧ�����Ϊ�� 2529  �ļ�¼
		deleteDemo.deleteStudent(2529);
	}
}
