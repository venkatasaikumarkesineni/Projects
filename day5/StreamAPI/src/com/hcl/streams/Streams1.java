package com.hcl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class Streams1 {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,4,2,5,1,8);
		
		Stream<Integer> s = lst.stream();
		
		Stream<Integer> s1 = s.map(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}

		});
		
		//s1.forEach(System.out::println);
		
		Integer reduce = s1.reduce(0,new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				// TODO Auto-generated method stub
				return i+j;
			}
		});
		System.out.println(reduce);
		
		// same solution but by using lamda expresssion
		List<Integer> lstt = Arrays.asList(1,4,2,5,1,8);
		
		System.out.println(lstt.stream().map(i->i*2).reduce(0,(i,j)-> i+j ));
		
		// finding the highest number
		List<Integer> lsttt = Arrays.asList(1,4,2,5,1,8);
		
		System.err.println(lsttt.stream().reduce(0,(i,j)-> (i>j)?i:j));

		//  finding the smallest number
		List<Integer> lstttt = Arrays.asList(1,4,2,5,0,8);
		
		System.err.println(lstttt.stream().reduce(0, (i,j) -> (i<j)?i:j ));
		
		// convertting one data type to another by using Map 
		//from integer to double data type
		List<Integer> val = Arrays.asList(1,4,2,5,0,8);
		
		System.out.println(val.stream().mapToDouble(new ToDoubleFunction<Integer>() {

			@Override
			public double applyAsDouble(Integer value) {
				// TODO Auto-generated method stub
				return value;
			}
		}).findFirst());
		
		// OR 
		// same code but with in one line we are using 
		// By using ORElse we can overcome printing optional at the output
		List<Integer> vall = Arrays.asList(1,4,2,5,0,8);
		System.out.println(vall.stream().mapToDouble(i -> i).findFirst().orElse(0));
		
		
		//foreach method by using streams
		List<Integer> valll = Arrays.asList(1,4,2,5,0,8);
	    valll.stream().forEach(i -> System.out.println(i));
	    
	    //using method reference  - step 1
	    List<Integer> mr = Arrays.asList(1,4,2,5,0,8);
	    
	    System.out.println(mr.stream().map(i -> i*3).reduce(0,(i,j) -> Integer.sum(i, j)));
	
	   //Here Integer is a Wrapper class - step 2 Very Imp
	    List<Integer> mrr = Arrays.asList(1,4,2,5,0,8);
  	 System.out.println(mrr.stream().map(i->i*3).reduce(0, Integer::sum));
	
	
	}

}

//Note : Stream -> Map -> Reduce

 
