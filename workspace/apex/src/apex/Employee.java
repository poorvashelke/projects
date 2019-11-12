package apex;

public class Employee {
	int empNo, zipcode, phone, hra;
	String empName, addr, state, designation, email;
	float basic, bonus;
	
	public Employee(int empNo, int zipcode, int phone, int hra, String empName, String addr, String state, String designation, String email, float basic, float bonus) {
		this.empNo = empNo;
		this.zipcode = zipcode;
		this.phone = phone;
		this.hra = hra;
		this.empName = empName;
		this.addr = addr;
		this.state = state;
		this.designation = designation;
		this.email = email;
		this.bonus = bonus;
	}
	
	private float getBasic() {
		return basic;
	}

	private void setBasic(float basic) {
		this.basic = basic;
	}

	private int getEmpNo() {
		return empNo;
	}

	private void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	private int getZipcode() {
		return zipcode;
	}

	private void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	private int getPhone() {
		return phone;
	}

	private void setPhone(int phone) {
		this.phone = phone;
	}

	private int getHra() {
		return hra;
	}

	private void setHra(int hra) {
		this.hra = hra;
	}

	private String getEmpName() {
		return empName;
	}

	private void setEmpName(String empName) {
		this.empName = empName;
	}

	private String getAddr() {
		return addr;
	}

	private void setAddr(String addr) {
		this.addr = addr;
	}

	private String getState() {
		return state;
	}

	private void setState(String state) {
		this.state = state;
	}

	private String getDesignation() {
		return designation;
	}

	private void setDesignation(String designation) {
		this.designation = designation;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private float getBonus() {
		return bonus;
	}

	private void setBonus(float bonus) {
		this.bonus = bonus;
	}

	private float salary(int basic, int hra, float bonus) {
		float salary;
		salary = basic + hra + ((bonus / 100) * basic);
		return salary;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
