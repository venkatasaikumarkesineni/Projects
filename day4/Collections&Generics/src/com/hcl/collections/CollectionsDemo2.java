package com.hcl.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo2 {
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>();

		values.add(7);
		values.add(5);
		values.add(4);
		values.add(7);
		values.add(5);
		values.add(4);
		//Collections.sort(values); for increasing order
		Collections.reverse(values);//for decreasing order
		
		values.add(1, 10);
// adding elements in between
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
	}

}
// Here the duplicate values in a list are entertained in order to overcome that we 
// are going for SET