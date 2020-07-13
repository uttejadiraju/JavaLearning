package effectiveJavaCodes;

public enum SingleTonEnum {
	Instance;
	
	int value;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int v) {
		this.value = v;
	}
}
