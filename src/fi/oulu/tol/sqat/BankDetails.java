package fi.oulu.tol.sqat;

public class BankDetails {
	private String address;
	private String city;
	private String pcode;
	private String country;
	private String password;
	
	private String cholder;
	private String ctype;
	private String cnumber;
	private String edate;

	private Person person;
	
	private cvcCheck cvc;
	private Bank bank;
	public BankDetails() {

	}
	public String testAccount(String code) {
		if(cvc.check(code)=="Pass") {
			return bank.transaction(cholder,ctype,cnumber,edate);
			
		}
		else {
			return "Invalid code";
		}
	}
	
	
	//getters
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getPcode() {
		return pcode;
	}

	public String getCountry() {
		return country;
	}
	public String getPassword() {
		return password;
	}
	public String getCholder() {
		return cholder;
	}
	public String getCtype() {
		return ctype;
	}
	public String getCnumber() {
		return cnumber;
	}
	public String getEdate() {
		return edate;
	}
	public Person getPerson() {
		return person;
	}
	//setters
	public int setAddress(String address) {
		if (address.matches("[A-Za-z0-9]+")) {
		this.address = address;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setCity(String lname) {
		if (lname.matches("[A-Za-z]+")) {
			this.city = lname;
			return 0;
			}
			else {
				return 1;
			}
	}
	public int setPcode(String pcode) {
		
		if (pcode.matches("[0-9-]+")) {
			this.pcode = pcode;
			return 0;
			}
			else {
				return 1;
			}
	}

	public int setCountry(String country) {
		if (country.matches("[A-Za-z]+")) {
			this.country = country;
			return 0;
			}
			else {
				return 1;
			}
	}
	public int setPassword(String psw) {

		if(psw != person.getPassword()) {
		this.password = psw;
		return 0;
		}
		else {
			return 1;
		}
		
	}
	public int setCholder(String psw) {
		this.cholder = psw;
		return 0;
	}
	public int setCtype(String psw) {
		this.ctype = psw;
		return 0;
	}
	public int setCnumber(String psw) {
		this.cnumber = psw;
		return 0;
	}
	public int setEdate(String psw) {
		this.edate = psw;
		return 0;
	}
	
	public void setPerson(Person psw) {
		this.person = psw;
	}
	public void setCvc(cvcCheck c) {
		this.cvc = c;
	}
	public void setBank(Bank p) {
		this.bank = p;
	}
	
}