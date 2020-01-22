package com.hcl.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionsDemo {
	public static void main(String[] args) {
		
		Collection values = new ArrayList();
		values.add(1);
		values.add("sai");
		values.add('a');
		Iterator i = values.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}	

}
// Here its printing the complete object values and 
// if you want to add one Proper DATA TYPE its difficult 
// so we r moving to generics