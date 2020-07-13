package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BreakSingleTonSolved {
	public static void main(String[] args) {
		try {
			SingleTonClass1 single1 = SingleTonClass1.getInstance();

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
			oos.writeObject(single1);
			oos.close();

			System.out.println(single1.hashCode());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"));
			SingleTonClass1 single2 = (SingleTonClass1) ois.readObject();
			System.out.println(single2.hashCode());
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class SingleTonClass1 implements Serializable {
	private SingleTonClass1() {
		int[] arr = new int[10000];
	}

	private static SingleTonClass1 instance = new SingleTonClass1();

	public static SingleTonClass1 getInstance() {
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}
}