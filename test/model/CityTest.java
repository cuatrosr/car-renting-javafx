package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CityTest {
	
	public void setupScenary3() {
	}

	@Test
	public void testCity() {
		int codeCi = 1;
		String nameCi = "Palmira";
		int refCi = 0;
		
		City newCity = new City(codeCi, nameCi, refCi);
		
		assertEquals(codeCi, newCity.getCodeCi());
		assertEquals(nameCi, newCity.getNameCi());
		assertEquals(refCi, newCity.getRefCi());
	}

}
