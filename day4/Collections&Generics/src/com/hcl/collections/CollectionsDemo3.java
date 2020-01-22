package com.hcl.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionsDemo3 {
	public static void main(String[] args) {

		Set<Integer> values = new HashSet<Integer>();
		values.add(98);
		values.add(7);
		values.add(5);
		values.add(4);

		values.add(7);
		values.add(5);
		values.add(4);

		System.out.println(values.remove(7));
		Iterator<Integer> i = values.iterator();
		for (int j = 0; j < values.size(); j++) {
			System.out.println(i.next());
		}

	}

}
// But here the values are printing as they have stored in list 
// in order to overcome this and to print in a sequence qe r going for TREE SET
