package org.sim.beans;

public class Address {
private int dno;
private String streetName;
private String loc;
public Address() {
	
}
public Address(int dno, String streetName, String loc) {
	super();
	this.dno = dno;
	this.streetName = streetName;
	this.loc = loc;
}
public int getDno() {
	return dno;
}
public void setDno(int dno) {
	this.dno = dno;
}
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}

}
