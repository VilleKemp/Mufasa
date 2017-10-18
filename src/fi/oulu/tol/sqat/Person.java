package fi.oulu.tol.sqat;

public class Person {
	private String fname;
	private String lname;
	private String uname;
	private String password;
	private String country;
	private String bday;
	private String phone;
	private String email;
	
	private CountryList countries;
	public Person() {
		countries = new CountryList();
	}
	//getters
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getUname() {
		return uname;
	}
	public String getPassword() {
		return password;
	}
	public String getCountry() {
		return country;
	}
	public String getBday() {
		return bday;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	//setters
	public int setFname(String fname) {
		if (validateName(fname)==0) {
		this.fname = fname;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setLname(String lname) {
		if (validateName(lname)==0) {
		this.lname = lname;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setUname(String uname) {
		if (validateUname(uname)==0) {
		this.uname = uname;
		return 0;
		}
		else {
			return 1;
		}
	}
	
	public int setPassword(String psw) {
		if (validatePassword(psw)==0) {
		this.password = psw;
		return 0;
		}
		else {
			return 1;
		}
	}
	
	public int setCountry(String country) {
		if (validateCountry(country)==0) {
		this.country = country;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setBday(String bday) {
		
		if (validateBday(bday)==0) {
		this.bday = bday;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setPhone(String phone) {
		if (validatePhone(phone)==0) {
		this.phone = phone;
		return 0;
		}
		else {
			return 1;
		}
	}
	public int setEmail(String email) {
		this.email = email;
		return 0;
	}
	
	// validation 
	public int validateName(String name ){
		//return 0 if name is valid
		boolean valid = name.matches("[A-Za-z]+");
		if (valid == true) {
		return 0;
		}
		else {
			return 1;
		}
	}
	
	public int validateUname(String uname ){
		//return 0 if name is valid
		int _count=0;
		boolean valid = uname.matches("[A-Za-z_]+");
		for(int i = 0, n = uname.length() ; i < n ; i++) { 
		    if(uname.charAt(i)=='_') {
		    	_count=_count+1;
		    			    } 
		}				
		if (valid == true && uname.length()<= 15 && _count <2) {
		return 0;
		}
		else {
			return 1;
		}
	}
	
	public int validatePassword(String pwd) {
		//return 0 if valid
		if (pwd.length()>=8) {
		return 0;
		}
		else {
			return 1;
		}
	}
	public int validateCountry(String c) {
		//return 0 if valid
		
		for (String s : countries.getCountries()) {
			//System.out.print(s);
			
            if(s ==c){
                return 0;
            }
        }
		return 1;
	}
	
	public int validateBday(String bday) {
		//age check not done
		
		if (bday.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
		return 0;
		}
		else {
			return 1;
		}
	}
	public int validatePhone(String p) {
		//assumes number that is 9 to 15 digits
		boolean valid = p.matches("\\d{9,15}");
		if (valid) {
		return 0;
		}
		else {
			return 1;
		}
	}	
	
	
	

}