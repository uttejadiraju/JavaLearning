package wrapperClasses;

public class AutoUnboxing {
	public static void main(String args[]) {
		Integer i = 10;
		int I = i; // Internally, Integer I = Integer.intValue();
		System.out.println(I);
		System.out.println(i == I);
		
		Integer Z = 10000;
		int W = Z;
		System.out.println(Z.intValue() == W);
	}
}
