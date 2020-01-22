package com.hcl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Streams2 {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(11, 15, 25, 33, 55, 40);

		// when you want to add the numbers which are divisible by only 5

		// External Iterations
		int res = 0;
		for (int i : lst) {
			if (i % 5 == 0) {
				res = res + i;
			}
		}
		System.out.println(res);
		
		
		// But when we will go for internal iterations by using FILTER code will get reduced alot
	
	   // Internal Iteration
	
		
		Predicate<Integer> f = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				if(t%5==0) {
					return true;	
				}
				else {
					return false;
				}
				
			}
		};
		System.out.println(lst.stream()
				              .filter(f)
				              .reduce(0,(c,e) -> c+e));
	
		
		// same code in a single line
		List<Integer> lstt = Arrays.asList(11, 15, 25, 33, 55, 40);
	System.out.println(lstt.stream()
			               .filter(i -> i%5==0)
			               .reduce(0, (c,e)-> c+e));
	}

}
