package bank.model;

public class Register {
	
	private int accNo;
	private String fName;
	private String uName;
	private String password;
	private float accBal;
	public Register() {
		
	}

	public Register(int accNo, String fName, String uName, String password, float accBal) {
		super();
		this.accNo = accNo;
		this.fName = fName;
		this.uName = uName;
		this.password = password;
		this.accBal = accBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
	

}
