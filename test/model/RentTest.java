package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class RentTest {
	
	public void setupScenary6() {
	}

	@Test
	void testRent() {
		int codeR = 6;
		int ticket = 1;
		String finitialString = "27/05/2021";
		String FfinalString = "10/06/2021";
		LocalDate Finitial = LocalDate.parse(finitialString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate Ffinal = LocalDate.parse(FfinalString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Duration diff = Duration.between(Finitial.atStartOfDay(), Ffinal.atStartOfDay());
		int days = (int) diff.toDays();
		Status status = Status.DEFERRED;
		int delay = 0;
		int mult = 0;
		double priceXDay = 80000;
		int priceTotal = (int) ((int) days*priceXDay);
		
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
		double pricexDay = priceXDay;
		int codeV = 3;
		String plate = "FXL004";
		boolean dispV = true;
		String photo = "";
		int year = 2021;
		int refV = 1;
		
		//Add Client
        String name = "David";
        String lastName = "Montaño";
        long id = (long) 21118442;
        int refP = 1;
        int codeP = 5;
        String emailC = "David@gmail.com";
        String phone = "3127312289";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        //Add City
        int codeCi = 4;
        String nameCi = "Palmira";
        int refCi = 1;
        
        
        //CreateObjects
		Brand newBrand = new Brand(country ,refB, codeB, nameB);
		TypeV newTypeV = new TypeV(quality, refTv, codeTv, nameTv);
		Car newCar = new Car(model, color, newBrand, newTypeV, pricexDay, codeV, plate, dispV, photo, year, refV);
        City cityC = new City(codeCi, nameCi, refCi);
        Client newClient = new Client(addressC, phoneC, emailC, cityC, codeP, refP, name, lastName, id);
        Rent newRent = new Rent(codeR, ticket, newClient, newCar, Finitial, Ffinal, days, status, delay, mult, priceTotal);

        assertEquals(codeR, newRent.getCodeR());
        assertEquals(ticket, newRent.getTicket());
        assertEquals(newClient, newRent.getClientR());
        assertEquals(newCar, newRent.getCarR());
        assertEquals(Finitial, newRent.getFinitial());
        assertEquals(Ffinal, newRent.getFfinal());
        assertEquals(days, newRent.getDays());
        assertEquals(status, newRent.getStatus());
        assertEquals(delay, newRent.getDelay());
        assertEquals(mult, newRent.getMult());
        assertEquals(priceTotal, newRent.getPriceTotal());
	}

}
