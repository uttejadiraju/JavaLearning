package enums;

interface BeerInterface {
	void hello();
}



public class EnumInterfaces {
	enum Beers implements BeerInterface{
		KC, BR, BL, KO;
		
		public void hello() {
			System.out.println("HELLO");
		}
	}
	public static void main(String args[]) {
		Beers b = Beers.BL;
		System.out.println(b);
		b.hello();
	}
	
	private static void hi() {
		
	}
}
