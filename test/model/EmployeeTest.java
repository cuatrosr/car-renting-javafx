package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	public void setupScenary2() {
	}
	
	@Test
	public void testEmployee() {
		String name = "Gabriel";
		String lastName = "Suárez";
		long id = (long) 1006325694;	
		int refP = 0;
		int codeP = 1;
		double vComision = 0;
		int nSold = 0;
		String password = "gabriels";
		String username = "gabsua";
		
		Employee newEmployee = new Employee(username, password, nSold, vComision, codeP, refP, name, lastName, id);
		
		assertEquals(name, newEmployee.getName());
		assertEquals(lastName, newEmployee.getLastName());
		assertEquals(id, newEmployee.getId());
		assertEquals(refP, newEmployee.getRefP());
		assertEquals(codeP, newEmployee.getCodeP());
		assertEquals(vComision, newEmployee.getVComision());
		assertEquals(nSold, newEmployee.getNSold());
		assertEquals(password, newEmployee.getPassword());
		assertEquals(username, newEmployee.getUsername());
	}
}
