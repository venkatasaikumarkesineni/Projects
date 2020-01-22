package com.hcl.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class CollectionsDemo1 {
	public static void main(String[] args) {
		Collection<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		Iterator<Integer> i = values.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
		v.add(42);
		v.add(25);
		System.out.println(v.capacity());
		
		Vector<Integer> v1 = new Vector<Integer>();
		v1.add(12);
		v1.add(45);
		v1.add(46);
		v1.add(48);
		v1.add(23);
		v1.add(12);
		v1.add(45);
		v1.add(46);
		v1.add(48);
		v1.add(23);
		v1.add(12);
		System.out.println(v1.capacity());
		
	}

}
// its unnecessarily printing all the values bcz its not having proper index value
// inorder to overcome that we r going for list


//note  : have u observerd one thing here the size f the vector is incrasing by 100%
//where the memory is wasted but in array list size will be increased just 50% where memory
// is saved .so,we are going for array list eventhogh vector and arraylist classes having
// the same features to save memory space.