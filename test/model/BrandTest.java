package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BrandTest {
	
	public void setupScenary4() {
	}

	@Test
	public void testBrand() {
		String country = "Alemania";
		int codeB = 1;
		String name = "Toyota";
		int refB = 0;
		
		Brand newBrand = new Brand(country ,refB, codeB, name);
		
		assertEquals(country, newBrand.getCountry());
		assertEquals(codeB, newBrand.getCodeA());
		assertEquals(name, newBrand.getNameTB());
		assertEquals(refB, newBrand.getRefB());
		
	}

}
