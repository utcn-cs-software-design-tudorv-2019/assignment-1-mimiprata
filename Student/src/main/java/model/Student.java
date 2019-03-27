package model;

public class Student {
	private int idstudent;
	private String name;
	private String cnp;
	private String address;
	private String email;
	private String password;
	private  int idgroup;
	public Student() {
		
	}
	public Student (int idstudent, String name, String cnp, String address, String email, String password, int idgroup) {
		this.idstudent=idstudent;
		this.name=name;
		this.cnp=cnp;
		this.address=address;
		this.email=email;
		this.password=password;
		this.idgroup=idgroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp=cnp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public int getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}
	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", name=" + name + ", CNP=" + cnp + ", address=" + address + ", email="+email + ",group = "+idgroup + "]";
	}
	
}
