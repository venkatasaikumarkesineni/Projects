package com.hcl.iterations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MehodReference {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1, 2, 2, 4, 5, 6);

		Consumer<Integer> c = (Integer t) -> {

			System.out.println(t);

		};
		lst.forEach(c);

		System.out.println("----------------");
		// or
		// when we are having only one method in the functional interface
		// its not required to create an new object for an interface
		// directly we can write

		lst.forEach(sai -> {
			System.out.println(sai);
		});

		System.out.println("----------------");
		// we can reduce the above lamda expression code by using method reference

		lst.forEach(MehodReference::doubleit);
		
		
		lst.forEach(Methodreference1::refer);

		System.out.println("----------------");
		// Here i tried to refer method in another class
		
		// we can make method refernce for static methods to static methods only

	}

	public static void doubleit(int i) {
		System.out.println(2*i);
	}
}
