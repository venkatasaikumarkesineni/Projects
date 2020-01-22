package com.hcl.collections;

import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo6 {
	public static void main(String[] args) {
		List<Integer> values = new LinkedList<Integer>();
		values.add(1);
		values.add(12);
		values.add(2);
		
		values.add(1, 23);
		
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
	}

}

// but linkedlist is faster than array list for 
//adding values and deleting like modifications

// But array list is faster for searching due to having index number for every value