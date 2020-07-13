package joshuaBloschCodes;

public class LambdasVsAnnonymousClasses {
	public static void main(String[] args) {
		int x = 5;
		AA a = new AA() {
			int b = 5;

			@Override
			public void B() {
				// TODO Auto-generated method stub
				System.out.println(x);
				System.out.println(b);
			}

			@Override
			public void A() {
				// TODO Auto-generated method stub

			}

		};
		a.A();
		a.B();

	}
}

interface AA {
	public void B();

	public void A();
}