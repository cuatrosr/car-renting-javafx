package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	
	public void setupScenary7() {
	}

	@Test
	void testCar() {
		//Add Brand
		String country = "Alemania";
		int codeB = 1;
		String nameB = "Toyota";
		int refB = 1;
		
		//Add Type
		int quality = 100;
		int codeTv = 2;
		String nameTv = "Deportivo";
		int refTv = 1;
		
		//AddCar
		String model = "A3A";
		String color = "Verde";
		double pricexDay = 80000;
		int codeV = 3;
		String plate = "FXL004";
		boolean dispV = true;
		String photo = "";
		int year = 2021;
		int refV = 0;
		
		Brand newBrand = new Brand(country ,refB, codeB, nameB);
		TypeV newTypeV = new TypeV(quality, refTv, codeTv, nameTv);
		Car newCar = new Car(model, color, newBrand, newTypeV, pricexDay, codeV, plate, dispV, photo, year, refV);
		
		assertEquals(model, newCar.getModel());
		assertEquals(color, newCar.getColor());
		assertEquals(pricexDay, newCar.getPriceXDay());
		assertEquals(codeV, newCar.getCodeV());
		assertEquals(plate, newCar.getPlate());
		assertEquals(dispV, newCar.isDispV());
		assertEquals(photo, newCar.getPhoto());
		assertEquals(year, newCar.getYear());
		assertEquals(refV, newCar.getRefV());
		assertEquals(newBrand, newCar.getBrand());
		assertEquals(newTypeV, newCar.getTypeV());
	}

}
