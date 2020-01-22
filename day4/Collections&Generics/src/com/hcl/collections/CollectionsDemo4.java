package com.hcl.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo4 {
	public static void main(String[] args) {
		Set<Integer> values = new TreeSet<Integer>();
		values.add(9);
		values.add(8);
		values.add(7);
		values.add(25);

		Iterator<Integer> i = values.iterator();
		System.out.println(i.next());
		while (i.hasNext()) {
			
			System.out.println(i.next());
			
		}
	}

}
// Here the values are printing in order even though the input is not in order