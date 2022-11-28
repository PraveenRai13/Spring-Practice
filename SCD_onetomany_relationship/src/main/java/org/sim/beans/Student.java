package org.sim.beans;

import java.util.Set;

public class Student {
private int sid;
private String name;
private String address;
Set<Subject> subjects;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
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
public Set<Subject> getSubjects() {
	return subjects;
}
public void setSubjects(Set<Subject> subjects) {
	this.subjects = subjects;
}

}
