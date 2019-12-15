package com.hcl.client;

public class Students {
private int stdid;
private String name;
private String dept;
private int batch;
public int getStdid() {
	return stdid;
}
public void setStdid(int stdid) {
	this.stdid = stdid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public int getBatch() {
	return batch;
}
public void setBatch(int batch) {
	this.batch = batch;
}
@Override
public String toString() {
	return "Students [stdid=" + stdid + ", name=" + name + ", dept=" + dept + ", batch=" + batch + "]";
}

}
