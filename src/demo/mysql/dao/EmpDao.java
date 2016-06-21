package demo.mysql.dao;

import java.sql.Date;

public interface EmpDao {
	/**
	 * ²éÑ¯
	 */
	public void empList();

	/**
	 * Ìí¼Ó
	 */
	public void add(int empno,String ename,String job,int mgr,Date hireDate,double sal,double comm,int deptno);

	/**
	 * É¾³ý
	 */
	public void delete(int empno);
	/**
	 * ÐÞ¸Ä
	 */
	public void update(int empno,String ename);

}
