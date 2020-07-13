package effectiveJavaCodes;

public class UsingSingleTonAppRecommended {
	public static void main(String[] args) {
		SingleTonEnum singleTon = SingleTonEnum.Instance;
		singleTon.setValue(5);
		System.out.println(singleTon.getValue());
	}
}
