
public class NewClass {
	private static class Counter {
		private static int c = 0;

		public static void increment() {
			c++;
		}

		public static void decrement() {
			c--;
		}

		public static int value() {
			return c;
		}
	}

	// Lớp tăng
	public static class Tang implements Runnable {

		public void run() {
			for (int i = 0; i < 4; i++) {
				try {
					Thread.sleep(1000);
					Counter.increment();
					System.out.println(Thread.currentThread().getName() + ": " + Counter.value());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	// Lớp giảm
	public static class Giam implements Runnable {

		public void run() {
			for (int i = 0; i < 4; i++) {
				try {
					Thread.sleep(1000);
					Counter.decrement();
					System.out.println(Thread.currentThread().getName() + ": " + Counter.value());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Tang());
		Thread t2 = new Thread(new Giam());
		
		t1.start();
		t2.start();
		
	}
}
