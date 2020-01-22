package com.hcl.streams;

import java.util.Arrays;
import java.util.List;

public class Stream3 {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,5,10,6,88);
		
		int z = lst.stream().filter(Stream3::method).findFirst().orElse(0);
		System.out.println(z);
	}
	
	public static boolean method(int i) {
		return i%5==0;
	}
// here the number of iterations has been reduced and 
	//it use to filter up to only and it wont waste the time on by filtering unused num.  
}
