package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import exception.Email;
import exception.Reference;

class RentingCarTest {
	
	RentingCar rc;
	
	public RentingCar setupScenary8() {
		RentingCar rcs = new RentingCar();
		return rcs;
	}
	
	public void setupScenary9() {
		rc = new RentingCar();
		
		String name = "Gabriel";
		String lastName = "Suárez";
		long id = (long) 1006325694;	
		int refP = 0;
		int codeP = 1;
		double vComision = 0;
		int nSold = 0;
		String password = "gabriels";
		String username = "gabsua";
		
		rc.addEmployee(username, password, nSold, vComision, codeP, refP, name, lastName, id);
	}
	
	public void setupScenary10() {
		rc = new RentingCar();
		
		int codeCi = 1;
		String nameCi = "Palmira";
		int refCi = 0;
		
		rc.addCity(codeCi, nameCi, refCi);
	}
	
	public void setupScenary11() throws Email {
		rc = new RentingCar();
		
		int codeCi = 1;
		String nameCi = "Palmira";
		int refCi = 0;
		
		rc.addCity(codeCi, nameCi, refCi);
		
        String name = "David";
        String lastName = "MontaÃ±o";
        long id = (long) 21118442;
        int refP = 0;
        int codeP = 2;
        String emailC = "David@gmail.com";
        String phone = "3127312289";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
	}
	
	public void setupScenary12() {
		rc = new RentingCar();
		
		String country = "Alemania";
		int codeB = 1;
		String name = "Toyota";
		int refB = 0;
		
		rc.addBrand(country, refB, codeB, name);
	}
	
	public void setupScenary13() {
		rc = new RentingCar();
		
		int quality = 100;
		int codeTv = 1;
		String nameTv = "Deportivo";
		int refTv = 0;
		
		rc.addTypeV(quality, refTv, codeTv, nameTv);
	}
	
	public void setupScenary14() {
		rc = new RentingCar();
		
		String country = "Alemania";
		int codeB = 1;
		String nameB = "Toyota";
		int refB = 1;
		
		int quality = 100;
		int codeTv = 2;
		String nameTv = "Deportivo";
		int refTv = 1;
		
		String model = "A3A";
		String color = "Verde";
		double pricexDay = 80000;
		int codeV = 3;
		String plate = "FXL004";
		boolean dispV = true;
		String photo = "";
		int year = 2021;
		
		rc.addBrand(country, refB, codeB, nameB);
		rc.addTypeV(quality, refTv, codeTv, nameTv);
		rc.addCar(model, color, rc.getListBrand().get(0), rc.getListTypeV().get(0), pricexDay, codeV, plate, dispV, photo, year);
	}
	
	public void setupScenary15() throws Email {
		rc = new RentingCar();
		
		try {
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
			
			//Add Client
	        String name = "David";
	        String lastName = "MontaÃ±o";
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
	        
	        
	        //Create Objects
	        rc.addBrand(country, refB, codeB, nameB);
	        rc.addTypeV(quality, refTv, codeTv, nameTv);
	        rc.addCar(model, color, rc.getListBrand().get(0), rc.getListTypeV().get(0), pricexDay, codeV, plate, dispV, photo, year);
	        rc.addCity(codeCi, nameCi, refCi);
	        rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
	        rc.addRent(codeR, ticket, rc.getListClients().get(0), rc.getFirstC(), Finitial, Ffinal, days, status, delay, mult, priceTotal);
		} catch (NullPointerException e) {
		}
	}


	@Test
	public void testRentingCar() {	
		RentingCar rct = setupScenary8();
		
		assertNotNull(rct);
		assertNull(rct.getFirstC());
		assertNull(rct.getFirstE());
		assertNull(rct.getRootNameC());
		assertNull(rct.getRootNameE());
		assertNotNull(rct.getListCities());
		assertNotNull(rct.getListClients());
		assertNotNull(rct.getListTypeV());
		assertNotNull(rct.getListBrand());
		assertNotNull(rct.getShowRootCar());
		assertNotNull(rct.getShowRootName());
		assertNotNull(rct.getListRent());
	}
	
	@Test
	public void testAddEmp() {
		setupScenary9();
		
		String name = "David";
		String lastName = "Montaño";
		long id = (long) 2118442;	
		int refP = 0;
		int codeP = 2;
		double vComision = 0;
		int nSold = 0;
		String password = "davidm";
		String username = "davmon";
		
		rc.addEmployee(username, password, nSold, vComision, codeP, refP, name, lastName, id);

		assertNotNull(rc.getFirstE());
		assertNotNull(rc.getFirstE().getNext());
	}
	
	@Test
	public void testLoginEmployee() {
		setupScenary9();
		
		String password = "gabriels";
		String username = "gabsua";
		
		boolean next = rc.loginEmployee(username, password);
		
		assertTrue(next);
	}
	
	@Test
	public void testAddCity1() {
		setupScenary10();
		
		int codeCi = 2;
		String nameCi = "Tulua";
		int refCi = 0;
		
		boolean added = rc.addCity(codeCi, nameCi, refCi);
		
		assertTrue(added);
		assertEquals(rc.getListCities().size(), 2);
	}
	
	@Test
	public void testAddCity2() {
		setupScenary10();
		
		int codeCi = 2;
		String nameCi = "Palmira";
		int refCi = 0;
		
		boolean added = rc.addCity(codeCi, nameCi, refCi);
		
		assertFalse(added);
		assertEquals(rc.getListCities().size(), 1);
	}
	
	@Test
	public void testUpdateCity1() {	
		setupScenary10();
		
		String nameCi = "Tulua";
		
		boolean update = rc.uptadeCity(rc.getListCities().get(0).getCodeCi(), nameCi);
		
		assertTrue(update);
		assertEquals(nameCi, rc.getListCities().get(0).getNameCi());
	}
	
	@Test
	public void testUpdateCity2() {
		setupScenary10();
		
		String nameCi = "Palmira";
		
		boolean update = rc.uptadeCity(rc.getListCities().get(0).getCodeCi(), nameCi);
		
		assertFalse(update);
		assertEquals(nameCi, rc.getListCities().get(0).getNameCi());
	}
	
	@Test
	public void testRemoveCity1() throws Reference {
		setupScenary10();
		
		rc.removeCity(rc.getListCities().get(0).getCodeCi());
		
		assertTrue(rc.getListCities().isEmpty());
	}
	
	@Test
	public void testRemoveCity2() {
		setupScenary10();
		
		try {
			rc.removeCity(rc.getListCities().get(0).getCodeCi());
		} catch (Reference e) {
			assertEquals(1, rc.getListCities().size());
		}
	}

	@Test
	public void testAddClient1() throws Email {
		setupScenary11();
		
        String name = "Gabriel";
        String lastName = "Suarez";
        long id = (long) 1006325694;
        int refP = 0;
        int codeP = 3;
        String emailC = "gasuarez2002@gmail.com";
        String phone = "3226227443";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        boolean added = rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
        
        assertTrue(added);
        assertEquals(2, rc.getListClients().size());
        assertEquals(rc.getListCities().get(0), rc.getListClients().get(1).getCityC());
        assertEquals(codeP, rc.getListClients().get(1).getCodeP());
	}
	
	@Test
	public void testAddClient2() throws Email {
		setupScenary11();
		
        String name = "Gabriel";
        String lastName = "Suarez";
        long id = (long) 21118442;
        int refP = 0;
        int codeP = 3;
        String emailC = "gasuarez2002@gmail.com";
        String phone = "3226227443";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        boolean added = rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
        
        assertFalse(added);
        assertEquals(1, rc.getListClients().size());
	}
	
	@Test
	public void testAddClient3() {
		try {
			setupScenary11();
			
			String name = "Gabriel";
	        String lastName = "Suarez";
	        long id = (long) 1006325694;
	        int refP = 0;
	        int codeP = 3;
	        String emailC = "Gabrielgmail.com";
	        String phone = "3226227443";
	        long phoneC = Long.parseLong(phone);
	        String addressC = "Calle 56";
	        
	        boolean added = rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
	        
	        assertFalse(added);
		} catch (Email e) {
			assertEquals(1, rc.getListClients().size());
		}
	}
	
	@Test
	public void testUpdateClient1() throws Email {
		setupScenary11();
		
        String name = "Luis";
        String phone = "3226227443";
        long phoneC = Long.parseLong(phone);
        
        Client updateC = rc.getListClients().get(0);
        
        boolean update = rc.uptadeClient(updateC.getAddressC(), phoneC, updateC.getEmailC(), 
        		updateC.getCityC(), updateC.getCodeP(), name, updateC.getLastName(), updateC.getId());
        
       assertTrue(update);
       assertEquals(name, rc.getListClients().get(0).getName());
       assertEquals(phoneC, rc.getListClients().get(0).getPhoneC());
       
		
		
	}
	
	@Test
	public void testUpdateClient2() throws Email {
		setupScenary11();
		
		//New Client
		String name = "Gabriel";
        String lastName = "Suarez";
        long id = (long) 1006325694;
        int refP = 0;
        int codeP = 3;
        String emailC = "gasuarez2002@gmail.com";
        String phone = "3226227443";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        rc.addClient(addressC, phoneC, emailC, rc.getListCities().get(0), codeP, refP, name, lastName, id);
        
		
		
		long idS = 1006325694;
		
		Client updateC = rc.getListClients().get(0);
		
		boolean update = rc.uptadeClient(updateC.getAddressC(), updateC.getPhoneC(), updateC.getEmailC(), 
        		updateC.getCityC(), updateC.getCodeP(), updateC.getName(), updateC.getLastName(), idS);
		
		assertFalse(update);
	}
	
	@Test
	public void testUpdateClient3() {
		try {
			setupScenary11();
			
			String emailC = "Gabrielgamail.com";
	
			Client updateC = rc.getListClients().get(0);
			boolean update = rc.uptadeClient(updateC.getAddressC(), updateC.getPhoneC(), emailC, 
	        		updateC.getCityC(), updateC.getCodeP(), updateC.getName(), updateC.getLastName(), updateC.getId());
			assertFalse(update);
			assertNotEquals(emailC, rc.getListClients().get(0).getEmailC());
		} catch (Email e) {		
		}
	}
	
	@Test
	public void testRemoveClient1() throws Email, Reference {
		setupScenary11();
		
		rc.removeClient(rc.getListClients().get(0).getCodeP());
		
		assertTrue(rc.getListClients().isEmpty());
	}
	
	@Test
	public void tesRemoveClient2() throws Email {
		setupScenary11();
		
		rc.getListClients().get(0).setRefP(1);
		
		try {
			rc.removeClient(rc.getListClients().get(0).getCodeP());
		} catch (Reference e) {
			assertEquals(1, rc.getListClients().size());
		}
	}

	@Test
	public void testAddBrand1() {	
		setupScenary12();
		
		int codeB = 2;
		String nameB = "Nissan";
		String country = "EEUU";
		int refB = 0;
		
		boolean added = rc.addBrand(country, refB, codeB, nameB);
		
		assertTrue(added);
		assertEquals(2, rc.getListBrand().size());
		assertEquals(codeB, rc.getListBrand().get(1).getCodeA());
	}
	
	@Test
	public void testAddBrand2() {
		setupScenary12();
		
		String country = "Alemania";
		int codeB = 2;
		String name = "Toyota";
		int refB = 0;
		
		boolean added = rc.addBrand(country, refB, codeB, name);
		
		assertFalse(added);
		assertEquals(1, rc.getListBrand().size());
	}
	
	@Test
	public void testUpdateBrand1() {
		setupScenary12();
		
		String country = "España";
		
		boolean update = rc.uptadeBrand(rc.getListBrand().get(0).getCodeA(), rc.getListBrand().get(0).getNameTB(), country);
		
		assertTrue(update);
		assertEquals(country, rc.getListBrand().get(0).getCountry());
	}
	
	@Test
	public void testUpdateBrand2() {
		setupScenary12();
		
		String country = "Alemania";
		String name = "Toyota";
		
		boolean update = rc.uptadeBrand(rc.getListBrand().get(0).getCodeA(), name, country);
		
		assertFalse(update);
	}
	
	@Test
	public void testRemoveBrand1() throws Reference {	
		setupScenary12();
		
		int code = rc.getListBrand().get(0).getCodeA();
		
		rc.removeBrand(code);
		
		assertTrue(rc.getListBrand().isEmpty());
	}
	
	@Test
	public void testRemoveBrand2() {
		setupScenary12();
		
		rc.getListBrand().get(0).setRefB(1);
		int code = rc.getListBrand().get(0).getCodeA();
		
		try {
			rc.removeBrand(code);
		} catch (Reference e) {
			assertEquals(1, rc.getListBrand().size());
		}
	}

	@Test
	public void testAddType1() {
		setupScenary13();
		
		int quality = 150;
		int codeTv = 2;
		String nameTv = "4x4";
		int refTv = 0;
		
		boolean added = rc.addTypeV(quality, refTv, codeTv, nameTv);
		
		assertTrue(added);
		assertEquals(2, rc.getListTypeV().size());
		assertEquals(2, rc.getListTypeV().get(1).getCodeA());
	}
	
	@Test
	public void testAddType2() {
		setupScenary13();
		
		int quality = 100;
		int codeTv = 2;
		String nameTv = "Deportivo";
		int refTv = 0;
		
		boolean added = rc.addTypeV(quality, refTv, codeTv, nameTv);
		
		assertFalse(added);
		assertEquals(1, rc.getListTypeV().size());
	}
	
	@Test
	public void testUpdateType1() {
		setupScenary13();
		
		int quality = 180;
		String nameTv = "Campero";
		int code = rc.getListTypeV().get(0).getCodeA();
		
		boolean update = rc.uptadeTypeV(code, nameTv, quality);
		
		assertTrue(update);
		assertEquals(quality, rc.getListTypeV().get(0).getQuality());
		assertEquals(nameTv, rc.getListTypeV().get(0).getNameTB());
	}
	
	@Test
	public void testUpdateType2() {
		setupScenary13();
		
		int quality = 100;
		String nameTv = "Deportivo";
		int code = rc.getListTypeV().get(0).getCodeA();
		
		boolean update = rc.uptadeTypeV(code, nameTv, quality);
		
		assertFalse(update);
	}
	
	@Test
	public void testRemoveType1() throws Reference {
		setupScenary13();
		
		int code = rc.getListTypeV().get(0).getCodeA();
		
		rc.removTypeV(code);
		
		assertTrue(rc.getListTypeV().isEmpty());
	}
			
	@Test
	public void testRemoveType2() {
		setupScenary13();
		
		int code = rc.getListTypeV().get(0).getCodeA();
		
		try {
			rc.removTypeV(code);
		} catch (Reference e) {
			assertEquals(1, rc.getListTypeV().size());
		}
	}
	
	@Test
	public void testAddCar1() {	
		setupScenary14();
		
		String model = "A3A200";
		String color = "Gris";
		double pricexDay = 70000;
		int codeV = 4;
		String plate = "PBD27C";
		boolean dispV = true;
		String photo = "";
		int year = 2017;
		
		boolean added = rc.addCar(model, color, rc.getListBrand().get(0), rc.getListTypeV().get(0), pricexDay, codeV, plate, dispV, photo, year);
		
		assertTrue(added);
		assertNotNull(rc.getFirstC().getNext());
		assertEquals(rc.getFirstC().getPrev().getCodeV(), 4);
		assertEquals(rc.getFirstC().getNext().getCodeV(), 4);
	}
	
	@Test
	public void testAddCar2() {
		setupScenary14();
		
		String model = "A3A200";
		String color = "Gris";
		double pricexDay = 70000;
		int codeV = 4;
		String plate = "FXL004";
		boolean dispV = true;
		String photo = "";
		int year = 2017;
		
		boolean added = rc.addCar(model, color, rc.getListBrand().get(0), rc.getListTypeV().get(0), pricexDay, codeV, plate, dispV, photo, year);
		
		assertFalse(added);
		assertEquals(rc.getFirstC().getNext(), rc.getFirstC());
		assertEquals(rc.getFirstC().getPrev(), rc.getFirstC());
	}
	
	@Test
	public void testUpdateCar1() {
		setupScenary14();
		
		String plate = "PBD27C";
		Car updateCar = rc.getFirstC();
		
		boolean update = rc.uptadeCar(updateCar.getCodeV(), updateCar.getModel(), updateCar.getColor(), updateCar.getBrand(),
				updateCar.getTypeV(), updateCar.getPriceXDay(), plate, updateCar.isDispV(), updateCar.getPhoto(), updateCar.getYear());
		
		assertTrue(update);
		assertEquals(plate, rc.getFirstC().getPlate());
	}
		
	@Test
	public void testUdateCar2() {
		setupScenary14();
		
		//New Car
		String model = "A3A200";
		String color = "Gris";
		double pricexDay = 70000;
		int codeV = 4;
		String plate = "PBD27C";
		boolean dispV = true;
		String photo = "";
		int year = 2017;
		
		rc.addCar(model, color, rc.getListBrand().get(0), rc.getListTypeV().get(0), pricexDay, codeV, plate, dispV, photo, year);

		
		String plateS = "PBD27C";
		Car updateCar = rc.getFirstC();
		
		boolean update = rc.uptadeCar(updateCar.getCodeV(), updateCar.getModel(), updateCar.getColor(), updateCar.getBrand(),
				updateCar.getTypeV(), updateCar.getPriceXDay(), plateS, updateCar.isDispV(), updateCar.getPhoto(), updateCar.getYear());
		
		assertFalse(update);
	}
	
	@Test
	public void testRemoveCar1() throws Reference {
		setupScenary14();
		
		int code = rc.getFirstC().getCodeV();
		
		rc.removeCar(code);
		
		assertNull(rc.getFirstC());
	}
	
	@Test
	public void testRemoveCar2() {
		setupScenary14();
		
		int code = rc.getFirstC().getCodeV();
		rc.getFirstC().setRefV(1);
		
		try {
			rc.removeCar(code);
		} catch (Reference e) {
			assertNotNull(rc.getFirstC());
		}
	}
	
	@Test
	public void testAddRent1() throws Email {	
		setupScenary15();
		try {
			int codeR = 7;
			int ticket = 2;
			String finitialString = "27/05/2021";
			String FfinalString = "08/06/2021";
			LocalDate Finitial = LocalDate.parse(finitialString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate Ffinal = LocalDate.parse(FfinalString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Duration diff = Duration.between(Finitial.atStartOfDay(), Ffinal.atStartOfDay());
			int days = (int) diff.toDays();
			Status status = Status.DEFERRED;
			int delay = 0;
			int mult = 0;
			double priceXDay = 80000;
			int priceTotal = (int) ((int) days*priceXDay);
			
			boolean added = rc.addRent(codeR, ticket, rc.getListClients().get(0), rc.getFirstC(), Finitial, Ffinal, days, status, delay, mult, priceTotal);
		
			assertTrue(added);
			assertEquals(2, rc.getListRent().size());
			assertNotNull(rc.getListRent().get(0).getCarR());
			assertNotNull(rc.getListRent().get(0).getClientR());
			
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void testAddRent2() throws Email {
		setupScenary15();
		try {
			int codeR = 7;
			int ticket = 2;
			String finitialString = "27/05/2021";
			String FfinalString = "08/06/2021";
			LocalDate Finitial = LocalDate.parse(finitialString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate Ffinal = LocalDate.parse(FfinalString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Duration diff = Duration.between(Finitial.atStartOfDay(), Ffinal.atStartOfDay());
			int days = (int) diff.toDays();
			Status status = Status.DEFERRED;
			int delay = 0;
			int mult = 0;
			double priceXDay = 80000;
			int priceTotal = (int) ((int) days*priceXDay);
			
			boolean added = rc.addRent(codeR, ticket, rc.getListClients().get(0), null, Finitial, Ffinal, days, status, delay, mult, priceTotal);
		
			assertFalse(added);
			assertEquals(1, rc.getListRent().size());
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void testAddRent3() throws Email {
		setupScenary15();
		try {
			int codeR = 7;
			int ticket = 2;
			String finitialString = "27/05/2021";
			String FfinalString = "08/06/2021";
			LocalDate Finitial = LocalDate.parse(finitialString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate Ffinal = LocalDate.parse(FfinalString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Duration diff = Duration.between(Finitial.atStartOfDay(), Ffinal.atStartOfDay());
			int days = (int) diff.toDays();
			Status status = Status.DEFERRED;
			int delay = 0;
			int mult = 0;
			double priceXDay = 80000;
			int priceTotal = (int) ((int) days*priceXDay);
			
			boolean added = rc.addRent(codeR, ticket, null, rc.getFirstC(), Finitial, Ffinal, days, status, delay, mult, priceTotal);
		
			assertFalse(added);
			assertEquals(1, rc.getListRent().size());
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void testAddRent4() throws Email {
		setupScenary15();
	
		try {
			int codeR = 7;
			int ticket = 2;
			String finitialString = "27/05/2021";
			String FfinalString = "08/06/2021";
			LocalDate Finitial = LocalDate.parse(finitialString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate Ffinal = LocalDate.parse(FfinalString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Duration diff = Duration.between(Finitial.atStartOfDay(), Ffinal.atStartOfDay());
			int days = (int) diff.toDays();
			Status status = Status.DEFERRED;
			int delay = 0;
			int mult = 0;
			double priceXDay = 80000;
			int priceTotal = (int) ((int) days*priceXDay);
			
			boolean added = rc.addRent(codeR, ticket, null, null, Finitial, Ffinal, days, status, delay, mult, priceTotal);
		
			assertFalse(added);
			assertEquals(1, rc.getListRent().size());
		} catch (NullPointerException e) {
		}
	}
}
