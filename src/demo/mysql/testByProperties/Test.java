package demo.mysql.testByProperties;

import demo.mysql.dao.EmpDao;
import demo.mysql.dao.impl.EmpDaoImpl;

public class Test {

	public static void main(String[] args) {
		EmpDao empDao = new EmpDaoImpl();
		empDao.empList();
	}

}
