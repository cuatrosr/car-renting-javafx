package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClientTest {

	  
    public void setupScenary1() {
    }

    @Test
    public void testClient() {
        setupScenary1();

        String name = "David";
        String lastName = "Montaño";
        long id = (long) 21118442;
        int refP = 0;
        int codeP = 2;
        String emailC = "David@gmail.com";
        String phone = "3127312289";
        long phoneC = Long.parseLong(phone);
        String addressC = "Calle 56";
        
        //********* Ciudad **********\\
        int codeCi = 1;
        String nameCi = "Palmira";
        int refCi = 1;
        
        City cityC = new City(codeCi, nameCi, refCi);
        
        Client newClient = new Client(addressC, phoneC, emailC, cityC, codeP, refP, name, lastName, id);
        
        assertEquals(name, newClient.getName());
        assertEquals(lastName, newClient.getLastName());
        assertEquals(id, newClient.getId());
        assertEquals(emailC, newClient.getEmailC());
        assertEquals(phoneC, newClient.getPhoneC());
        assertEquals(addressC, newClient.getAddressC());
        assertEquals(refP, newClient.getRefP());
        assertEquals(codeP, newClient.getCodeP());
        assertEquals(cityC, newClient.getCityC());
    }

}
