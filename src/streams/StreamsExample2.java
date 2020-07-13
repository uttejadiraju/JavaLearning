package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsExample2 {
	class Student {
		private int age;
		private int rollNo;
		private String name;

		public Student(int age, int rollNo, String name) {
			this.age = age;
			this.rollNo = rollNo;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public int getRollNo() {
			return rollNo;
		}

		public String getName() {
			return name;
		}

		public String print() {
			return name + " " + age + " " + rollNo;
		}
	}

	public List<Student> getStudents() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(23, 82, "a"));
		list.add(new Student(23, 69, "b"));
		list.add(new Student(24, 93, "c"));
		return list;
	}

	public static void main(String[] args) {
		List<Student> students = new StreamsExample2().getStudents();
		// Get student names with age 23.

		int sum = students.stream().filter((Student s) -> s.getName() != " ").map(Student::getAge).reduce(0,
				(a, b) -> a + b);
		System.out.println(sum);

		int sum1 = students.stream().map(Student::getAge).reduce(0, (a, b) -> a + b);
		System.out.println(sum1);

	}
}
