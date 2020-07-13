package garbaseCollector;

public class FlushObjects {
	public static void main(String[] args) {
		FlushObjects obj = new FlushObjects();
		obj.create();
		// Two objects collected by G.C. o and o1
		
		FlushObjects obj1 = getFlushObject();
		// One object flushed by G.C. only o1 i.e obj1 => o;
	}
	
	public void create() {
		FlushObjects o = new FlushObjects();
		FlushObjects o1 = new FlushObjects();
	}
	public static FlushObjects getFlushObject() {
		FlushObjects o = new FlushObjects();
		FlushObjects o1 = new FlushObjects();
		return o;
	}
	
}
