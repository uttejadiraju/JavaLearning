package joshuaBloschCodes;

import java.util.ArrayList;
import java.util.List;

public class GenericsCornerCase {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3 };
		Object[] objs = arr;
		objs[0] = 4;
		/**
		 * Arrays compile time weak. Runtime strong!!! Exception in thread "main"
		 * java.lang.ArrayStoreException: java.lang.String at
		 * joshuaBloschCodes.GenericsCornerCase.main(GenericsCornerCase.java:7)
		 */
		// objs[1] = "error!"; // attempt of heap pollution
		List<String> list = new ArrayList<String>();
		// List<Integer> intList = list; Error!!!

		Object[] objectArray = new Long[1];
		objectArray[0] = "I	don't	fit	in"; // Throws ArrayStoreException

		/*
		 * Won't compile! List<Object> ol = new ArrayList<Long>(); Incompatible types
		 * ol.add("I	don't	fit	in");
		 */
		

		List<Integer> myInts = new ArrayList<Integer>();
		myInts.add(1);
		myInts.add(2);
		// List<Number> myNums = myInts; //compiler error
		// myNums.add(3.14); //heap polution

		// Buggy code
		List<String> lists = new ArrayList<String>();
		List myList = new ArrayList<>();
		myList.add(1);
		lists = myList;
		for (String s : lists) {
			System.out.println(s);
		}
		
		List<?> li = new ArrayList<>();

	}
}

/***
 * Arrays are said to be covariant which basically means that, given the
 * subtyping rules of Java, an array of type T[] may contain elements of type T
 * or any subtype of T. For instance
 * 
 * Number[] numbers = newNumber[3]; numbers[0] = newInteger(10); numbers[1] =
 * newDouble(3.14); numbers[2] = newByte(0); But not only that, the subtyping
 * rules of Java also state that an array S[] is a subtype of the array T[] if S
 * is a subtype of T, therefore, something like this is also valid:
 * 
 * Integer[] myInts = {1,2,3,4}; Number[] myNumber = myInts; Because according
 * to the subtyping rules in Java, an array Integer[] is a subtype of an array
 * Number[] because Integer is a subtype of Number.
 * 
 * But this subtyping rule can lead to an interesting question: what would
 * happen if we try to do this?
 * 
 * myNumber[0] = 3.14; //attempt of heap pollution This last line would compile
 * just fine, but if we run this code, we would get an ArrayStoreException
 * because we’re trying to put a double into an integer array. The fact that we
 * are accessing the array through a Number reference is irrelevant here, what
 * matters is that the array is an array of integers.
 * 
 * This means that we can fool the compiler, but we cannot fool the run-time
 * type system. And this is so because arrays are what we call a reifiable type.
 * This means that at run-time Java knows that this array was actually
 * instantiated as an array of integers which simply happens to be accessed
 * through a reference of type Number[].
 * 
 * So, as we can see, one thing is the actual type of the object, an another
 * thing is the type of the reference that we use to access it, right?
 * 
 * The Problem with Java Generics
 * 
 * Now, the problem with generic types in Java is that the type information for
 * type parameters is discarded by the compiler after the compilation of code is
 * done; therefore this type information is not available at run time. This
 * process is called type erasure. There are good reasons for implementing
 * generics like this in Java, but that’s a long story, and it has to do with
 * binary compatibility with pre-existing code.
 * 
 * The important point here is that since at run-time there is no type
 * information, there is no way to ensure that we are not committing heap
 * pollution.
 * 
 * Let’s consider now the following unsafe code:
 * 
 * List<Integer> myInts = newArrayList<Integer>(); myInts.add(1); myInts.add(2);
 * List<Number> myNums = myInts; //compiler error myNums.add(3.14); //heap
 * polution If the Java compiler does not stop us from doing this, the run-time
 * type system cannot stop us either, because there is no way, at run time, to
 * determine that this list was supposed to be a list of integers only. The Java
 * run-time would let us put whatever we want into this list, when it should
 * only contain integers, because when it was created, it was declared as a list
 * of integers. That’s why the compiler rejects line number 4 because it is
 * unsafe and if allowed could break the assumptions of the type system.
 * 
 * As such, the designers of Java made sure that we cannot fool the compiler. If
 * we cannot fool the compiler (as we can do with arrays) then we cannot fool
 * the run-time type system either.
 * 
 * As such, we say that generic types are non-reifiable, since at run time we
 * cannot determine the true nature of the generic type.
 */