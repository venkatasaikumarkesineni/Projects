package com.hcl.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo5 {
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>();
		
		values.add(58);
		values.add(75);
		values.add(544);
		values.add(61);
		values.add(80);
		
		Comparator<Integer> com = new ComparatorImpl();
		Collections.sort(values, com);
		
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
		
	}

}
// Here we r going to use comparator for doing sorting as required

// here we r sorting based on lst digit as required