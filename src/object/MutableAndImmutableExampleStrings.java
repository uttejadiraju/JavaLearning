package object;

public class MutableAndImmutableExampleStrings {
	static public void main(String args[]) {
		String a="a";
		System.out.println(a);
		String b=a;
		System.out.println(b);
		a.concat("abc");
		System.out.println(a);
		System.out.println(b);
		
		StringBuilder sb = new StringBuilder("i am not changed!!!");
		StringBuilder sbCopy = sb;
		System.out.println(sb);
		System.out.println("I Depend on sb. My value = " + sbCopy);
		sb.deleteCharAt(0);
		System.out.println(sb);
		System.out.println("sb:- i am changed sorry!!!");
		System.out.println("I am changed now!!! sbCopy =" +sbCopy);
	}
}
