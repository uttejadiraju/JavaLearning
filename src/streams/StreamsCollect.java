package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsCollect {
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
		List<Student> students = new StreamsCollect().getStudents();
		Averager averageCollect = students.stream().map(Student::getAge).collect(Averager::new, Averager::accept,
				Averager::combine);
		System.out.println(averageCollect.print());
	}

}
