package demo.mysql.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import demo.mysql.dao.BaseDao;
import demo.mysql.dao.EmpDao;

public class EmpDaoImpl extends BaseDao implements EmpDao {
	/**
	 * ��ѯ
	 */
	public void empList() {
		try {
			// (3).����statement ����ִ��sql
			String sql = "select * from emp";
			Object[] params = {};
			ResultSet rs = this.executeSQL(sql, params);
			// ��������
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}

	}

	/**
	 * ���
	 */
	public void add(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno){
		
		try {
		
		//(3).����statement ����ִ��sql
		String sql="insert into emp values(?,?,?,?,?,?,?,?)";
		Object[] params={empno,ename,job,mgr,new java.sql.Timestamp(hireDate.getTime()),sal,comm,deptno};
		 int i=this.executeUpdate(sql, params);
		 if(i>0){
			 System.out.println("�������ųɹ�");
		 }
		}finally{
			this.closeResource();
		}
		
	}

	/**
	 * ɾ��
	 */
	public void delete(int empno){
		
		try {
		String sql="delete from emp where empno=?";
		Object[] params={empno};
		  int i=this.executeUpdate(sql, params);
		 if(i>0){
			 System.out.println("ɾ����Ϣ�ɹ�");
		 }
		}finally{
			this.closeResource();
		}
		
	}

	/**
	 * �޸�
	 */
	public void update(int empno,String ename){
		
		try {
			
		String sql="update emp set ename=? where empno=?";
		Object[] params={ename,empno};
		 
		 int i=this.executeUpdate(sql, params);
		 if(i>0){
			 System.out.println("�޸���Ϣ�ɹ�");
		 }
		}finally{
			this.closeResource();
		}
	}
}
