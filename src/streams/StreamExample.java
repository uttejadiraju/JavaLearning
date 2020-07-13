package streams;

import java.util.List;
import java.util.ArrayList;

public class StreamExample {
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
		List<Student> students = new StreamExample().getStudents();
		// Get student names with age 23.
		students.stream().filter((Student s) -> s.getAge() == 23)
				.forEach((element) -> System.out.println(element.getName()));

		students.stream().filter(p -> p.getAge() == 23).mapToInt(Student::getAge).average().getAsDouble();
		
		students.stream().mapToInt((element) -> element.getName().length()).forEach(System.out::println); 
	}
}
