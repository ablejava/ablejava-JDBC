package demo.mysql.dao;

import java.sql.Date;

public interface EmpDao {
	/**
	 * ��ѯ
	 */
	public void empList();

	/**
	 * ���
	 */
	public void add(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno);

	/**
	 * ɾ��
	 */
	public void delete(int empno);
	/**
	 * �޸�
	 */
	public void update(int empno,String ename);

}
