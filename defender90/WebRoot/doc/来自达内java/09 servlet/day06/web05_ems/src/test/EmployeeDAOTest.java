package test;

import dao.EmployeeDAO;

public class EmployeeDAOTest {
	public static void testDelete() throws Exception{
		EmployeeDAO dao = new EmployeeDAO();
		dao.delete(2);
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		testDelete();
	}

}
