package object;

import java.util.Scanner;

public class CloneExample implements Cloneable {
	private String name;
	private int age;

	public CloneExample(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void displayData() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name ");
		String name = sc.next();
		System.out.println("Enter your age ");
		int age = sc.nextInt();
		CloneExample std = new CloneExample(name, age);
		System.out.println("Contents of the original object");
		std.displayData();
		System.out.println("Contents of the copied object");
		CloneExample copiedStd = (CloneExample) std.clone();
		copiedStd.name = "v";
		copiedStd.displayData();
		std.displayData();
	}
}