package com.hcl.iterations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Iterations {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,5);
		
//		for(int i=0; i<lst.size();i++) {
//			System.out.println(lst.get(i));
//		}
//		
		
//		Iterator<Integer> i = lst.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//			
//		}
		
//		for (Integer dummy : lst) {
//			System.out.println(dummy);
//			
//		}
		// These all are External iterations
		// Here we are communicationg with object outside the forlopp method again and again
		
		// Inorder to overcome the disadvantage we are using Internal Iterations
		
		// Internal Iterations by using Straem API
		
		
		
		
//		Consumer<Integer> c = new Consumer<Integer>() {
//			
//			@Override
//			public void accept(Integer t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}
//		}; 
//		lst.forEach(c);

		// Lengthy code(boiler code) in order to reduce that we are using lamda expressions 
		// which can be also called as functional programming
		
		lst.forEach(sai -> System.out.println(sai));
		
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1>o2)
					return -1;
				else
				return 1;
			}
		};
		
		lst.sort(c);
		for (Integer dummy : lst) {
			System.out.println(dummy);
		}
		}

}
