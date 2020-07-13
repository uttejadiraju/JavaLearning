package Tricky;

public class CustomGeneric<T> {
	private T contents;
	
	public T emptyCrate() {
		return contents;
	}


	public void packCrate(T contents) {
		this.contents = contents;
	}
	
	public static <T> CustomGeneric<T> ship(T t) {
		 System.out.println("Preparing " + t);
		 return new CustomGeneric<T>();
		}
	
	public static void main(String[] args) {
		CustomGeneric<Integer> custom = new CustomGeneric<Integer>();
		// custom.packCrate("integer"); compile time error. 
		custom.packCrate(5555);
		
	}
}