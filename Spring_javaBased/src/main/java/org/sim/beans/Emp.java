package org.sim.beans;

public class Emp {
private int eno;
private String name;
private String loc;
public Emp() {
	// TODO Auto-generated constructor stub
}
public Emp(int eno, String name, String loc) {
	super();
	this.eno = eno;
	this.name = name;
	this.loc = loc;
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
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}

}
