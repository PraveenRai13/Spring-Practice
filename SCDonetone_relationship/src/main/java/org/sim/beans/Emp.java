package org.sim.beans;

public class Emp {
	private int eno;
	private String name;
	private Address address;
	public Emp() {
	}
	public Emp(int eno, String name, Address address) {
		super();
		this.eno = eno;
		this.name = name;
		this.address = address;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}