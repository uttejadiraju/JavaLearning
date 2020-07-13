package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BreakSingleTon {
	public static void main(String[] args) {
		try {
			SingleTonClass single1 = SingleTonClass.getInstance();

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
			oos.writeObject(single1);
			oos.close();

			System.out.println(single1.hashCode());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"));
			SingleTonClass single2 = (SingleTonClass) ois.readObject();
			System.out.println(single2.hashCode());
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class SingleTonClass implements Serializable {
	private SingleTonClass() {

	}

	private static SingleTonClass instance = new SingleTonClass();

	public static SingleTonClass getInstance() {
		return instance;
	}
}