package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import demo.mysql.testByDataSource.MysqlDatasourceFactory;

/**
 * ȡ��ָ���꼶�Լ�ָ����Ŀ��ǰ����ѧ��
 * @author ��������
 *
 */
public class QueryDemo extends MysqlDatasourceFactory{

	public void queryStudent(int subjectNo, int gradeId){
		Connection con = openConnection();
		String query="select s.StudentNo, s.StudentName,r.StudentResult,su.subjectName,g.gradeName " +
				"from student s, result r, subject su, Grade g " +
				"where s.studentNo = r.studentNo and r.subjectNo=su.subjectNo " +
				"and su.subjectNo=? " +
				"and s.gradeId=g.gradeId and g.gradeId=? " +
				"order by r.studentResult DESC " +
				"Limit 0,5";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, subjectNo);
			ps.setInt(2, gradeId);
			//ִ�в�ѯ��䲢��ý����
			ResultSet rs = ps.executeQuery();
			
			System.out.println("��ѯ��Ϣ���£�");
			System.out.println("ѧԱ���\tѧԱ����\tѧԱ�ɼ�\t���Կ�Ŀ\t�����꼶");
			//��������������
			while(rs.next()){
				int studentNo = rs.getInt("StudentNo");
				String stuName = rs.getString("studentName");
				int stuResult = rs.getInt("StudentResult");
				String subjectName = rs.getString("subjectName");
				String gradeName = rs.getString("gradeName");
				
				System.out.println(studentNo + "\t" + stuName + "\t" + stuResult + "\t" + subjectName + "\t" + gradeName);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws ParseException{
		QueryDemo queryDemo = new QueryDemo();
		queryDemo.queryStudent(1,1);
	}
	
}
