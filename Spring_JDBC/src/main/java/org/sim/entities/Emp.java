package org.sim.entities;

public class Emp {
private int eno;
private String name;
private String address;
public Emp() {
	// TODO Auto-generated constructor stub
}
public Emp(int eno, String name, String address) {
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
