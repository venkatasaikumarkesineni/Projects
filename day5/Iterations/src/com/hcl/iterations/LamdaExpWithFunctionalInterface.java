package com.hcl.iterations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LamdaExpWithFunctionalInterface {
public static void main(String[] args) {
	List<Integer> lst = Arrays.asList(1,2,3,4,3,8);
	
//	Consumer<Integer> c = new Consumer<Integer>() {
//		
//		@Override
//		public void accept(Integer t) {
//			// TODO Auto-generated method stub
//		System.out.println(t);	
//		}
//	}; 
//	
//	lst.forEach(c);
	// With out lamda expression
	
	Consumer<Integer> c =  
			(t) -> {
			System.out.println(t);	
		};
		
		lst.forEach(c);
		
		
//		Collections.sort(lst, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer a, Integer b) {
//				// TODO Auto-generated method stub
//				if(a>b)
//				return -1;
//				else
//					return 1;
//			}
//		});
//		lst.forEach(c);
		// sorting by using comparator functional interface
		
		Collections.sort(lst,(a,b) -> 
		{
			return a>b?-1:1;
		}
				
		);
		lst.forEach(c);
		// sorting by using comaparator in lamda exp and functional interface
}
}
