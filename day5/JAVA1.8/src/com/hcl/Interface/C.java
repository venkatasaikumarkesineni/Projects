package com.hcl.Interface;

public class C extends A implements I{
  public static void main(String[] args) {
	C  obj = new C();
	obj.show();
}
}
/// Here Class has more priority than interface 
// so we are getting output from the class.