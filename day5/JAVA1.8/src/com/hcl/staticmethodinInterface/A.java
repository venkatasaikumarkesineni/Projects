package com.hcl.staticmethodinInterface;

public class A implements I {
public static void main(String[] args) {
	I.show();
}
}

// Here there is no need to create object of static methods 
// up to 1.7 we are not able to create static method in Interface

// Note  : from java 1.8 we can create a static method in an Interface