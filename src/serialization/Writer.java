package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
	public static void main(String[] args) throws IOException {
		Employee employee = new Employee();
		employee.setName("Ashintha");
		employee.setAge((byte) 30);
		employee.setAddress("Galle");
		FileOutputStream fout = new FileOutputStream("./employee.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(employee);
		oos.close();
		fout.close();
		System.out.println("Process complete");
	}
}