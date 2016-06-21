package demo.mysql.jdbc.operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import demo.mysql.testByDataSource.MysqlDatasourceFactory;

/**
 * 取出指定年级以及指定科目的前五名学生
 * @author 北大青鸟
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
			//执行查询语句并获得结果集
			ResultSet rs = ps.executeQuery();
			
			System.out.println("查询信息如下：");
			System.out.println("学员编号\t学员姓名\t学员成绩\t考试科目\t考试年级");
			//遍历结果集并输出
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
