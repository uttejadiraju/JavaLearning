package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;

public class StreamExample3 {
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
	
	static Predicate<Student> pre = new Predicate<Student> () {
		public boolean test(Student t) {
			// TODO Auto-generated method stub
			return t.getAge() == 23;
		}
	};
	
	static Function<Student, Integer> fun = new Function<Student, Integer>() {

		@Override
		public Integer apply(Student t) {
			// TODO Auto-generated method stub
			return t.getName().length();
		}
		
	};

	public static void main(String[] args) {
		List<Student> students = new StreamExample3().getStudents();
		// Get student names with age 23.
		students.stream().filter(pre)
				.forEach((element) -> System.out.println(element.getName()));

		students.stream().filter(pre).mapToInt(Student::getAge).average().getAsDouble();
		
		students.stream().mapToInt((element) -> element.getName().length()).forEach(System.out::println); 
	}
}
