package fi.oulu.tol.sqat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
public class MufasaTests {
	Person person;
	CountryList countrylist;
	BankDetails bankdetails;
	Bank bank;
	cvcCheck cvc;
	@Before
	public void setup(){
		person = new Person();
		bankdetails = new BankDetails();
		
		//Mock create
		bank = EasyMock.createMock(Bank.class);
		cvc = EasyMock.createMock(cvcCheck.class);
	}

	@Test
	public void test_mufasa_bank_transaction_pass(){
		//mock setup
		EasyMock.expect(bank.transaction("Ville", "VISA", "0000", "12/11/2000")).andReturn("Pass");
		
		
		EasyMock.expect(cvc.check("123")).andReturn("Pass");
		
		EasyMock.replay(cvc);
		EasyMock.replay(bank);
		//create valid bankdetails to be used in transaction
		
		assertEquals(0,bankdetails.setCholder("Ville"));
		assertEquals(0,bankdetails.setCtype("VISA"));
		assertEquals(0,bankdetails.setCnumber("0000"));
		assertEquals(0,bankdetails.setEdate("12/11/2000"));
		bankdetails.setCvc(cvc);
		bankdetails.setBank(bank);
		
		
		assertEquals("Pass",bankdetails.testAccount("123"));
		
		
	}
	@Test
	public void test_mufasa_bank_transaction_fail(){
		//mock setup
		
		EasyMock.expect(bank.transaction("Tauno", "MasterCard", "1111", "12/11/2000")).andReturn("Fail");
		
		EasyMock.expect(cvc.check("123")).andReturn("Pass");
		
		EasyMock.replay(cvc);
		EasyMock.replay(bank);
		//create valid bankdetails to be used in transaction
		
		assertEquals(0,bankdetails.setCholder("Tauno"));
		assertEquals(0,bankdetails.setCtype("MasterCard"));
		assertEquals(0,bankdetails.setCnumber("1111"));
		assertEquals(0,bankdetails.setEdate("12/11/2000"));
		bankdetails.setCvc(cvc);
		bankdetails.setBank(bank);
		
		
		assertEquals("Fail",bankdetails.testAccount("123"));
		
		
	}	
	
	@Test
	public void test_bankdetails_legit() {
		assertEquals(0,bankdetails.setAddress("Kuja42"));
		assertEquals("Kuja42",bankdetails.getAddress());	
		
		assertEquals(0,bankdetails.setCity("Oulu"));
		assertEquals("Oulu",bankdetails.getCity());
		
		assertEquals(0,bankdetails.setPcode("00-2"));
		assertEquals("00-2",bankdetails.getPcode());
		
		assertEquals(0,bankdetails.setCountry("Finland"));
		assertEquals("Finland",bankdetails.getCountry());
		Person testperson = new Person();
		
		testperson.setPassword("Salasana");
		bankdetails.setPerson(testperson);
		
		assertEquals(0,bankdetails.setPassword("Salasana1"));
		assertEquals("Salasana1",bankdetails.getPassword());
		
		assertEquals(0,bankdetails.setCholder("I"));
		assertEquals("I",bankdetails.getCholder());
		
		assertEquals(0,bankdetails.setCtype("VISA"));
		assertEquals("VISA",bankdetails.getCtype());
		
		assertEquals(0,bankdetails.setCnumber("12345"));
		assertEquals("12345",bankdetails.getCnumber());
		
		assertEquals(0,bankdetails.setEdate("11/11/1111"));
		assertEquals("11/11/1111",bankdetails.getEdate());
	}
	
	@Test
	public void test_person_legit() {		
		assertEquals(0,person.setFname("Tauno"));
		assertEquals("Tauno",person.getFname());
		
		assertEquals(0,person.setLname("Testaaja"));
		assertEquals("Testaaja",person.getLname());
		
		assertEquals(0,person.setFname("Tauno"));
		assertEquals("Tauno",person.getFname());
		
		assertEquals(0,person.setUname("Tauno_"));
		assertEquals("Tauno_",person.getUname());
		
		assertEquals(0,person.setPassword("salasana"));
		assertEquals("salasana",person.getPassword());
		
		assertEquals(0,person.setCountry("Finland"));
		assertEquals("Finland",person.getCountry());
		
		assertEquals(0,person.setBday("11/11/1111"));
		assertEquals("11/11/1111",person.getBday());
		
		assertEquals(0,person.setPhone("050123456789"));
		assertEquals("050123456789",person.getPhone());
		
		assertEquals(0,person.setEmail("Tauno@mail.com"));
		assertEquals("Tauno@mail.com",person.getEmail());
	}

}