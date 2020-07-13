package streams;
class Averager implements java.util.function.IntConsumer {
		private int total = 0;
		private int count = 0;

		public String print() {
			return "total == " + total + " count == " + count;
		}

		public void accept(int i) {
			System.out.println("Accept!!!");
			total += i;
			count++;
		}

		public void combine(Averager other) {
			System.out.println("Combiner!!!");
			total += other.total;
			count += other.count;
		}
	}